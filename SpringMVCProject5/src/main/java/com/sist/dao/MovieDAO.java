package com.sist.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.sist.mongo.*;

@Repository
public class MovieDAO {

	
	private MongoClient mc; //connection
	private DB db; //database ex)XE
	private DBCollection dbc; //table
	
	public MovieDAO()
	{
		try{
			//�ѹ��� �����ϸ�ok
			mc=new MongoClient("localhost",27017);
			db=mc.getDB("mydb");
			dbc=db.getCollection("movie"); //making table name here
			
			
		}catch(Exception ex){}
	}
	
	//{mno: 100, title:'',...} like json shape ==> BasicDBObject(�ϳ��� �����ϸ� �ϳ��� ���� ���ִ�.)
	public void movieInsert(MovieVO vo)
	{
		try{
			BasicDBObject obj=new BasicDBObject();
			obj.put("mno", vo.getMno());
			obj.put("title", vo.getTitle());
			obj.put("poster", vo.getPoster());
			obj.put("genre", vo.getGenre());
			obj.put("grade", vo.getGrade());
			obj.put("director",vo.getDirector());
			obj.put("actor", vo.getActor());
			obj.put("story", vo.getStory());
			dbc.insert(obj);
			//���̺����!! => go to manager
			//json����, ��������x
			
		}catch(Exception ex) {}
		
	}
	
	
	public List<MovieVO> movieListData(int page){
		
		List<MovieVO> list=new ArrayList<MovieVO>();
		try{
			
			int rowSize=12;
			//1������ 0, 2������ �տ� 12���� ������ , 3������ �տ� 24�� ����
			//skip=������ ����
			int skip=(rowSize*page)-rowSize;
		
			//resultset  and find()=> select * from and skip��ŭ ���� and rowSize��ŭ �����Ͷ�.
			//limit������ ����������ŭ �ٽ� ������
			DBCursor cursor=dbc.find().skip(skip).limit(rowSize);
			while(cursor.hasNext()){
				// �ѹ������� ��ϴ���(json�Ѱ�)�� ������
				//row�Ѱ� ��������
				BasicDBObject obj=(BasicDBObject)cursor.next();
				MovieVO vo=new MovieVO();
				//�������� ���� => �÷������Ҽ�����.				
				vo.setMno(obj.getInt("mno"));//mno��� Ű ���� ��
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
			}
		}catch(Exception ex) {}
		
		return list;
	}
	
	/*
	 * NoSQL => SQL�� �������� �ʰ�, �Լ��� �̿��ؼ� ó��
	 */
	public int movieTotalPage()
	{
		
		int total=0;
		try{
			//SELECT CEIL(COUNT(*)/12.0) FROM movie
			int count=(int)dbc.count(); // dbc.count(); �Ѱ��� ,(int)����ȯ ������ �Ѱ����� long������ ������ ����.
			// SELECT COUNT(*) FROM movie
			total=(int)(Math.ceil(count/12.0)); //�Լ��� �Ѱ�� ���ϰ� �ڹٿ��� ����ϴ� �ø��޼ҵ� ���1
			
		}catch(Exception ex){}
		return total;
	}
	
	//mongodb�� ������ ���� ����� ���� - ����Ŭ�� ����ȭ�� �����͸� �ٷ�,
	//json => r => ����ȭ�Ͽ� ������
	//but twitter =>������ȭ ������ =>mongodb�� �״�� �� ��������! => �����ͼ� ����ȭ�ϰ� ����Ŭ�� ������!!
	//���� ������� �ӽ�����ҷ� ���� ����=> �� ������ �Ѿ� ���尡��=> �ӵ� ����! than oracle!
	//mongoDB�� MAPPERX => so ó���� dao����
	
	public List<MovieVO> movieFindData(String fd){
		
		//select * from movie where title like '%fd%'
		//find({"title",{"$regex","*."+fd}}) ==> ���Խ��� �̿��ؼ� ã�´�!!
		
		//insert/delete/ã��!from mongodb!
		//but mongoDB���� MYBATIS����� ���ִ�. SPRING-MONGODB
		//find({no:1})
		List<MovieVO> list=new ArrayList<MovieVO>();
		try
		{	//{no:1} => BasicDBObject�� ã���ش� no�� �ְ� 1�� ������
			
			//{"title",{"$regex","*."+fd}} �Ѱ��� {}�� �Ѱ��� BasicDBObject => �ȿ� �Ѱ� �� �ִ� ���
			BasicDBObject where =
					new BasicDBObject("title",new BasicDBObject("$regex",".*"+fd)); // $regex�� ã�ڴ�/ => fd�� ���Ե� ������ ã�ڴ�.
			//�������� ������ ����� resultset���� ������ => record������ ������
			DBCursor cursor=dbc.find(where);//where���ǿ� �ش��ϴ� �����͸� dbc����  ��� ã���� find()=select()// find()�ȿ� ������ * ����� �ǹ�
			while(cursor.hasNext())
			{
				//����ü�� �� �������⶧���� �츮�� 2���� �ʿ���.. �����Ͷ� ���� �ʿ���!(��µǴ� �κ�!)
				BasicDBObject obj=(BasicDBObject)cursor.next(); //�Ѱ��� �б� ����  {} , == rs.next()
				//go to robo3t
				MovieVO vo=new MovieVO();
				//�ʿ��� ������ vo�� �־� list�� ��������
				vo.setMno(obj.getInt("mno")); 
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
			}
			cursor.close();
			
			//where.put("title", fd); //where.put("title", fd);  => where title=fd so, �˻������� ���x
			//title���� ã�ڴ�!
		}catch(Exception ex){}
		return list;
	}
	
	
	//������ => select , delete, insert ==> (�ӽ�����!)
	public MovieVO movieDetailData(int mno)
	{
		MovieVO vo=new MovieVO();
		try{
			
			BasicDBObject where
				=new BasicDBObject("mno",mno); //mno=10
			BasicDBObject res=(BasicDBObject)dbc.findOne(where); //�Ѱ� �����ö�
			//�Ѱ�ã�⶧���� cursor�� while�ʿ�!
			vo.setMno(res.getInt("mno"));
			vo.setTitle(res.getString("title")); // "title"�� �����񿡼��� key
			vo.setActor(res.getString("actor"));
			vo.setDirector(res.getString("director"));
			vo.setPoster(res.getString("poster"));
			vo.setGenre(res.getString("genre"));
			vo.setGrade(res.getString("grade"));
			vo.setStory(res.getString("story"));
			
			
		}catch(Exception ex){}
		
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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
			//한번만 연결하면ok
			mc=new MongoClient("localhost",27017);
			db=mc.getDB("mydb");
			dbc=db.getCollection("movie"); //making table name here
			
			
		}catch(Exception ex){}
	}
	
	//{mno: 100, title:'',...} like json shape ==> BasicDBObject(하나만 생성하면 하나씩 넣을 수있다.)
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
			//테이블만들기!! => go to manager
			//json형식, 쿼리문장x
			
		}catch(Exception ex) {}
		
	}
	
	
	public List<MovieVO> movieListData(int page){
		
		List<MovieVO> list=new ArrayList<MovieVO>();
		try{
			
			int rowSize=12;
			//1페이지 0, 2페이지 앞에 12개를 버린다 , 3페이지 앞에 24개 버림
			//skip=버리는 개수
			int skip=(rowSize*page)-rowSize;
		
			//resultset  and find()=> select * from and skip만큼 버려 and rowSize만큼 가져와라.
			//limit버리고 버린개수만큼 다시 가져옴
			DBCursor cursor=dbc.find().skip(skip).limit(rowSize);
			while(cursor.hasNext()){
				// 한바퀴마다 블록단위(json한개)로 가져옴
				//row한개 가져오기
				BasicDBObject obj=(BasicDBObject)cursor.next();
				MovieVO vo=new MovieVO();
				//몽고디비의 단점 => 컬럼지정할수없다.				
				vo.setMno(obj.getInt("mno"));//mno라는 키 값을 줘
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
			}
		}catch(Exception ex) {}
		
		return list;
	}
	
	/*
	 * NoSQL => SQL이 존재하지 않고, 함수를 이용해서 처리
	 */
	public int movieTotalPage()
	{
		
		int total=0;
		try{
			//SELECT CEIL(COUNT(*)/12.0) FROM movie
			int count=(int)dbc.count(); // dbc.count(); 총개수 ,(int)형변환 이유는 총개수가 long형으로 들어오기 때문.
			// SELECT COUNT(*) FROM movie
			total=(int)(Math.ceil(count/12.0)); //함수로 총계수 구하고 자바에서 사용하는 올림메소드 사용1
			
		}catch(Exception ex){}
		return total;
	}
	
	//mongodb는 지능형 웹을 만들기 위해 - 오라클은 정형화된 데이터만 다룸,
	//json => r => 정형화하여 가져옴
	//but twitter =>비정형화 데이터 =>mongodb는 그대로 다 저장해줌! => 가져와서 정형화하고 오라클에 저장함!!
	//따라서 몽고디비는 임시저장소로 많이 쓰임=> 조 단위를 넘어 저장가능=> 속도 빠름! than oracle!
	//mongoDB는 MAPPERX => so 처리를 dao에서
	
	public List<MovieVO> movieFindData(String fd){
		
		//select * from movie where title like '%fd%'
		//find({"title",{"$regex","*."+fd}}) ==> 정규식을 이용해서 찾는다!!
		
		//insert/delete/찾기!from mongodb!
		//but mongoDB에도 MYBATIS사용할 수있다. SPRING-MONGODB
		//find({no:1})
		List<MovieVO> list=new ArrayList<MovieVO>();
		try
		{	//{no:1} => BasicDBObject가 찾아준다 no를 주고 1을 가져옴
			
			//{"title",{"$regex","*."+fd}} 한개의 {}이 한개의 BasicDBObject => 안에 한개 더 있는 모양
			BasicDBObject where =
					new BasicDBObject("title",new BasicDBObject("$regex",".*"+fd)); // $regex로 찾겠다/ => fd가 포함된 문장을 찾겠다.
			//위문장을 실행한 결과를 resultset으로 가져옴 => record단위로 가져옴
			DBCursor cursor=dbc.find(where);//where조건에 해당하는 데이터를 dbc에서  모두 찾아줘 find()=select()// find()안에 없으면 * 모두의 의미
			while(cursor.hasNext())
			{
				//블럭전체를 다 가져오기때문에 우리는 2개만 필요함.. 포스터랑 제목만 필요함!(출력되는 부분!)
				BasicDBObject obj=(BasicDBObject)cursor.next(); //한개씩 읽기 블럭을  {} , == rs.next()
				//go to robo3t
				MovieVO vo=new MovieVO();
				//필요한 데이터 vo에 넣어 list로 가져오기
				vo.setMno(obj.getInt("mno")); 
				vo.setTitle(obj.getString("title"));
				vo.setPoster(obj.getString("poster"));
				list.add(vo);
			}
			cursor.close();
			
			//where.put("title", fd); //where.put("title", fd);  => where title=fd so, 검색에서는 사용x
			//title에서 찾겠다!
		}catch(Exception ex){}
		return list;
	}
	
	
	//몽고디비 => select , delete, insert ==> (임시저장!)
	public MovieVO movieDetailData(int mno)
	{
		MovieVO vo=new MovieVO();
		try{
			
			BasicDBObject where
				=new BasicDBObject("mno",mno); //mno=10
			BasicDBObject res=(BasicDBObject)dbc.findOne(where); //한개 가져올때
			//한개찾기때문에 cursor로 while필요!
			vo.setMno(res.getInt("mno"));
			vo.setTitle(res.getString("title")); // "title"이 몽고디비에서의 key
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

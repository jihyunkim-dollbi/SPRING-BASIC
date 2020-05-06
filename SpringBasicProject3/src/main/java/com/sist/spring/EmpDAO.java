package com.sist.spring;
import java.util.*;

import com.sist.spring.EmpVO;

import java.sql.*; 
/*
 * 1. MyBasicDataSource �޸� �Ҵ� ��û
 * 2. MyBasicDataSource�� ������ �ִ� setter�� ���� ä���.
 * 3. public EmpDAO(MyBasicDataSource ds)�� ���� �־��
 * 4. private MyBasicDataSource ds; ds�� ���� ä������.
 * 5. MainClass���� ȣ���ؼ� ���!
 */
public class EmpDAO {

	private MyBasicDataSource ds;
	public EmpDAO(MyBasicDataSource ds) //�̷��� �����ڿ� ���� ä��� ��(�����ڿ� �Ű������� ä���)�� contructure di?
	{
		this.ds=ds;
		try{
			
			Class.forName(ds.getDriverClassName());
			
		}catch(Exception ex) {}
	}
	
	private Connection conn;
	private PreparedStatement ps;
	
	public void getConnection(){
		
		try{
			
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUserName(),ds.getPassword());
			
		}catch(Exception ex){}
		
		
	}
	
	
	
	public void disConnection(){
		
		try{
			
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			
		}catch(Exception ex){}
		
		
	}

	
	public List<EmpVO> empAllData(){
		
		List<EmpVO> list=new ArrayList<EmpVO>();
		
		try{
			
			getConnection();
			
			String sql="SELECT empno, ename, job, hiredate, sal "
					 + "FROM emp";
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				list.add(vo); 
				
			}
			rs.close();
			
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}finally{
			
			disConnection();
		}
		
		return list;
		
		
	}
	
	
	
	
	
}

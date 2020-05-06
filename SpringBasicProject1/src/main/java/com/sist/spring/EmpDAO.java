package com.sist.spring;

import java.util.*;
import java.sql.*;
/*
 * 수시로 바뀔 수있기 떄문에 => xml을 통해서 값을 넘겨줘야..
 * 생성자(메모리할당 후)를 먼저 생성해야 setmethod를 사용 가능!
 * 드라이버 등록은 한번이면 ok =>따라서 생성자 사용.
 * 매번 dao 객체를 생성하지 않는다. => new연산자 사용시 => bg 회수 느림.
 * =>  dao를 싱글톤으로 만들어 사용!
 * spring => 사용 후 메모리 회수해줌. => 메모리공간 절약. => 따라서 생성과(주소값know)회수까지 spring에서 관리. => 클래스를 올리고 spring에서 메모리할당
 * => lifecycle! 생성에서 소멸까지!
 * 따라서, xml에 클래스만 등록하면 spring에서 알아서 관리해줌!
 * 
 * ** 하나만 가지고 전체를 제어(단한개의 주소) => 싱클톤
 * ** 하나를 여러번 생성(여러주소) => prototype 생성!
 * 
 * 클래스를 관리할때 생성, 소멸 => CONTAINER 관리..
 * 
 * 
 */
public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	
	//변경 가능한
	private String driverName;
	private String url;
	private String userName;
	private String password;
	
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void init()
	{
		try{
			
			Class.forName(driverName); //메모리할당!
			
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
		
	}
	
	//DI => 값을 채우고 시작하기.. INJECTION.
	public void getConnection()
	{
		
		try
		{
			conn=DriverManager.getConnection(url,userName,password);
			
		}catch(Exception ex){}
		
	}
	
	
	
	public void disConnection()
	{
		
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

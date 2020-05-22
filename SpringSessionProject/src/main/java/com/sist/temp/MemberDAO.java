package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement ps;
	private String URL="jdbc:oracle:thin:@localhost:XE:1521";
	//트랜젝션프로그램 =>AOP
	//실행끝 커밋
	//캐치절 ROLLBACK
	//파이널 AUTOCOMMIT
	
	public MemberDAO(){//생성자
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){}
	}
	
	public void getConnection()
	{
		try{		
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	
	public void disConnection()
	{
		try{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	
	
	public List<MemberVO> memberListData()
	{
		/*
		 * <select id="memberListData" resultType="MemberVO" parameterType="">
		 * 	select * from trans_member
		 * </select>
		 * 
		 * ResultSet = resultType="MemberVO"
		 * 코딩에서 파란색으로 된 부분을 xml에서 정의해놓으면 spring에서 알아서 값을 넣어주는 것!
		 */
		List<MemberVO> list=new ArrayList<MemberVO>();
		try{
			getConnection();
			String sql="SELECT * FROM trans_member";
			ps=conn.prepareStatement(sql);
			//결과값 가져오기
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MemberVO vo=new MemberVO();
				vo.setNo(rs.getInt("no")); //마이바티스는 컬럼명이 들어간다!
				vo.setName(rs.getString("name"));
				vo.setSex(rs.getNString("sex"));
				list.add(vo);
			}
			rs.close();
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}finally{
			
			disConnection();
		}
		return list;
		
	}
	
	
	public void memberInsert(MemberVO vo1, MemberVO vo2) //동시에 테이블에 insert를 두개하기위함
	{
		try{
			getConnection();
			String sql="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo1.getNo());
			ps.setString(2, vo1.getName());
			ps.setString(3, vo1.getSex());
			ps.executeUpdate(); // inside commit();
			
			//
			sql="INSERT INTO trans_member VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo2.getNo());
			ps.setString(2, vo2.getName());
			ps.setString(3, vo2.getSex());
			ps.executeUpdate(); // inside commit();
			//두번째 문장 실패시 처리하기!!
			
			
	
		}catch(Exception ex){
			ex.printStackTrace(); //첫번쨰 문장 실패시 실행
			
		}finally{
			disConnection();
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

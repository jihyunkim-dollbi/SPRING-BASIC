package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	//id="mapper" 의 주소값을 자겨옴!(has ds, ssf)
	@Autowired
	private BoardMapper mapper;
	
	//from interface BoardMapper
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	
	//총페이지구하기!
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	//insert!
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	
	//상세보기 => +hit & detail 두개를 동시에 처리
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no); //+hit는 이렇게 끝=> 조회수 증가!
		return mapper.boardDetailData(no);
	}
	
	
	//상세보기 메소드를 재사용
	public BoardVO boardUpdateData(int no)
	{
		//조회수 증가x
		return mapper.boardDetailData(no); 
	}
	
	
	//비번 비교 
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPwd(vo.getNo());
		
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdate(vo);
			
		}else{
			
			bCheck=false;
		}
		return bCheck;
		
	}
	
	
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck=false;
		
		String db_pwd=mapper.boardGetPwd(no);
		
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			mapper.boardDelete(no);
			
		}else{
			
			bCheck=false;
		}
		return bCheck;
		
	}
	
	
	
}

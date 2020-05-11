package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	//id="mapper" �� �ּҰ��� �ڰܿ�!(has ds, ssf)
	@Autowired
	private BoardMapper mapper;
	
	//from interface BoardMapper
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	
	
	//�����������ϱ�!
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	//insert!
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	
	//�󼼺��� => +hit & detail �ΰ��� ���ÿ� ó��
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no); //+hit�� �̷��� ��=> ��ȸ�� ����!
		return mapper.boardDetailData(no);
	}
	
	
	//�󼼺��� �޼ҵ带 ����
	public BoardVO boardUpdateData(int no)
	{
		//��ȸ�� ����x
		return mapper.boardDetailData(no); 
	}
	
	
	//��� �� 
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

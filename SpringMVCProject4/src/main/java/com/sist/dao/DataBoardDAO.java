package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DataBoardDAO {

	@Autowired //같은 클래스로 지정되면 찾지못함 =>MAPPER여러개 경우  @RESOUCE(autowired+qualifier) 사용!
	@Qualifier("mapper") 
	private DataBoardMapper mapper;
	
	//리스트출력
	public List<DataBoardVO> databoardListData(Map map)
	{	
		return mapper.databoardListData(map);
	}
	
	//파일 올리기
	public void databoardInsert(DataBoardVO vo)
	{
		mapper.databoardInsert(vo);
	}
	
	
	//detail처리
	public DataBoardVO databoardDetailData(int no)
	{
		//조회수 올리고
		mapper.hitIncrement(no);
		
		//상세보기
		return mapper.databoardDetailData(no);
		
	}
	
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
	
	//detail처리
	public DataBoardVO databoardUpdateData(int no)
	{
		//조회수 올리고
		mapper.hitIncrement(no);
			
		//상세보기
		return mapper.databoardDetailData(no);
	}
	
	public String databoardGetPassword(int no){
		
		return mapper.databoardGetPassword(no);
	}
		
	public void databoardUpdate(DataBoardVO vo)
	{	
		mapper.databoardUpdate(vo);	
	}
	
	//데이터처리는 controller and dao possible!!
	public boolean databoardDelete(int no, String pwd)
	{	
		boolean bCheck=false; // 안맞으면 false!
		String db_pwd=mapper.databoardGetPassword(no); //비번 가져옴!
		if(db_pwd.equals(pwd))
		{
			mapper.databoardDelete(no);
			bCheck=true;
		}
		return bCheck;
	}
	
	
	public DataBoardVO databoardFileInfoData(int no)
	{	
		return mapper.databoardFileInfoData(no);
	}
	
	
}

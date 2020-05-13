package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class DataBoardDAO {

	@Autowired //���� Ŭ������ �����Ǹ� ã������ =>MAPPER������ ���  @RESOUCE(autowired+qualifier) ���!
	@Qualifier("mapper") 
	private DataBoardMapper mapper;
	
	//����Ʈ���
	public List<DataBoardVO> databoardListData(Map map)
	{	
		return mapper.databoardListData(map);
	}
	
	//���� �ø���
	public void databoardInsert(DataBoardVO vo)
	{
		mapper.databoardInsert(vo);
	}
	
	
	//detailó��
	public DataBoardVO databoardDetailData(int no)
	{
		//��ȸ�� �ø���
		mapper.hitIncrement(no);
		
		//�󼼺���
		return mapper.databoardDetailData(no);
		
	}
	
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
	
}

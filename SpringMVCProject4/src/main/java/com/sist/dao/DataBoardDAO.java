package com.sist.dao;

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
	
	//detailó��
	public DataBoardVO databoardUpdateData(int no)
	{
		//��ȸ�� �ø���
		mapper.hitIncrement(no);
			
		//�󼼺���
		return mapper.databoardDetailData(no);
	}
	
	public String databoardGetPassword(int no){
		
		return mapper.databoardGetPassword(no);
	}
		
	public void databoardUpdate(DataBoardVO vo)
	{	
		mapper.databoardUpdate(vo);	
	}
	
	//������ó���� controller and dao possible!!
	public boolean databoardDelete(int no, String pwd)
	{	
		boolean bCheck=false; // �ȸ����� false!
		String db_pwd=mapper.databoardGetPassword(no); //��� ������!
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

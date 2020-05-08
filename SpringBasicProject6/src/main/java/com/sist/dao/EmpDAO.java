package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
	//ssf�޾ƿ�! => then opensession etc ��밡��!
	//id="ssf" �� ���� ���Ե�.
	@Autowired 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<EmpVO> empAllData()
	{	
		return getSqlSession().selectList("empAllData"); //���������� �����ϴ� ���
		//��� �޾ұ⶧����  getSqlSession() ��밡��!
		//getSqlSession()
		//opensession & session.close ����!
	}
	

	public EmpVO empFindData(int empno)
	{	
		return getSqlSession().selectOne("empFindData", empno);
	}
	
	
	
}

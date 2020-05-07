package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;

public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
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

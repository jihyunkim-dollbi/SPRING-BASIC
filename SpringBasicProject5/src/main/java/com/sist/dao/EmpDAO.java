package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.*;

//dao�Ҵ�! 
//<bean id="eDao" class="com.sist.dao.EmpDAO">
//ID�� �ο� ���ϸ� �ڵ� ID ������ => Ŭ�������� ù���ڸ� �ҹ��ڷ� �ٲ��� =>empDAO 
@Repository("eDao")
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
	public List<EmpVO> empAllData()
	{	
		return getSqlSession().selectList("empAllData"); //���������� �����ϴ� ���
		//��� �޾ұ⶧����  getSqlSession() ��밡��!
		//opensession & session.close ����!
	}
	
	
	public EmpVO empFindData(int empno)
	{	
		return getSqlSession().selectOne("empFindData", empno);
	}
	
	
	
}

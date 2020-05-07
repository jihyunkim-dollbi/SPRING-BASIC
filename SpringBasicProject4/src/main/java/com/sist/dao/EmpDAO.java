package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;

public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
	public List<EmpVO> empAllData()
	{	
		return getSqlSession().selectList("empAllData"); //스프링에서 지원하는 방식
		//상속 받았기때문에  getSqlSession() 사용가능!
		//getSqlSession()
		//opensession & session.close 포함!
	}
	
	
	public EmpVO empFindData(int empno)
	{	
		return getSqlSession().selectOne("empFindData", empno);
	}
	
	
	
}

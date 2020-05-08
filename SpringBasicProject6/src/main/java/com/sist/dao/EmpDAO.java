package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
	//ssf받아옴! => then opensession etc 사용가능!
	//id="ssf" 의 값이 주입됨.
	@Autowired 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
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

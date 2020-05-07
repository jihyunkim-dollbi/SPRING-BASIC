package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.*;

//dao할당! 
//<bean id="eDao" class="com.sist.dao.EmpDAO">
//ID를 부여 안하면 자동 ID 생성됨 => 클래스명의 첫글자만 소문자로 바꿔짐 =>empDAO 
@Repository("eDao")
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	
	public List<EmpVO> empAllData()
	{	
		return getSqlSession().selectList("empAllData"); //스프링에서 지원하는 방식
		//상속 받았기때문에  getSqlSession() 사용가능!
		//opensession & session.close 포함!
	}
	
	
	public EmpVO empFindData(int empno)
	{	
		return getSqlSession().selectOne("empFindData", empno);
	}
	
	
	
}

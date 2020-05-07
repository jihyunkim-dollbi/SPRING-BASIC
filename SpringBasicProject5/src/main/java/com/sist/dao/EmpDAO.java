package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="dao" class="com.sist.dao.EmpDAO"
		p:sqlSessionFactory-ref="ssf"  => set메소드에 ssf를 채워라..
	/>
	 
	 
	  1.set메소드에 직접 값을 채우거나
	  	setUsername("hr");
		setPassword("happy");
		setMaxActive(20);		
	  
	  2.set메소드에 값을 받아서 채우거나
  		 ssf 받기!!	
 * 	
 */
import org.springframework.stereotype.Repository;
import java.util.*;

//dao할당! 
//<bean id="eDao" class="com.sist.dao.EmpDAO">
//ID를 부여 안하면 자동 ID 생성됨 => 클래스명의 첫글자만 소문자로 바꿔짐 =>empDAO 
//@Repository("eDao")
@Repository // 값을 지정 안한 경우 첫글자를 소문자로 변경하여 자동 저장된다 => 따라서 getBean에서 자동저장된 것을 기입해준다!!
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	

	//set매소드에 직접 값을 채우지 않고 다른곳에서 가져올때. => override/implements => change to @Autowired!
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
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

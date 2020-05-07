package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="dao" class="com.sist.dao.EmpDAO"
		p:sqlSessionFactory-ref="ssf"  => set�޼ҵ忡 ssf�� ä����..
	/>
	 
	 
	  1.set�޼ҵ忡 ���� ���� ä��ų�
	  	setUsername("hr");
		setPassword("happy");
		setMaxActive(20);		
	  
	  2.set�޼ҵ忡 ���� �޾Ƽ� ä��ų�
  		 ssf �ޱ�!!	
 * 	
 */
import org.springframework.stereotype.Repository;
import java.util.*;

//dao�Ҵ�! 
//<bean id="eDao" class="com.sist.dao.EmpDAO">
//ID�� �ο� ���ϸ� �ڵ� ID ������ => Ŭ�������� ù���ڸ� �ҹ��ڷ� �ٲ��� =>empDAO 
//@Repository("eDao")
@Repository // ���� ���� ���� ��� ù���ڸ� �ҹ��ڷ� �����Ͽ� �ڵ� ����ȴ� => ���� getBean���� �ڵ������ ���� �������ش�!!
public class EmpDAO extends SqlSessionDaoSupport{ //includes sqlsessionfactory(in app.xml)
	

	//set�żҵ忡 ���� ���� ä���� �ʰ� �ٸ������� �����ö�. => override/implements => change to @Autowired!
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	
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

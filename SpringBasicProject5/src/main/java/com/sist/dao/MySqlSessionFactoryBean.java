package com.sist.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
		
	/>
 * 
 */
@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	//�ڵ����� => �ڵ����� ������ ��ü�� �ּҰ��� �־��� by spring => ���������� ������ datasource�� ã�Ƽ� �־���
	
	//@Autowired =>id�𸣸� ����ϱ� => ã����.
	//@Qualifier("ds")
	@Resource(name="ds") // @autowired+@qualifier
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

	
	
}

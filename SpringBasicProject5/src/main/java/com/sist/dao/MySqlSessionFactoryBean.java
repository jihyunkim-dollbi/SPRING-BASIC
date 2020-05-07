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

	//자동주입 => 자동으로 생성된 객체의 주소값을 넣어줌 by spring => 스프링에서 생성된 datasource를 찾아서 넣어줌
	
	//@Autowired =>id모르면 사용하기 => 찾아줌.
	//@Qualifier("ds")
	@Resource(name="ds") // @autowired+@qualifier
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

	
	
}

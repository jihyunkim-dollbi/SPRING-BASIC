package com.sist.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/*
  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
	/>
	 
	
	@Autowired => 자동주입 => 클래스의 메모리 주소만 주입 => 스프링에 등록된 클래스만 사용 가능!
 	@ => TYPE
 	public class A
 	{
 		@
 		MyDAO dao; =>필드 위에

		@
 		public A(MyDAO dao => String a(사용x =>always shoud be class)){} => 생성자위에

 		@
 		public void setMyDAO(MyDAO dao){} => 파라미터 위에
 		
 		@
 		public void display(MyDAO dao){} => 
 	
 	}

		 	<Spring Roll>
			 * 1.클래스 메모리 할당 해준다.(클래스 관리자)
			 * 2.맴버 변수에 값을 주입!
			 * 3.클래스의 메모리 해제
			 * 4.반복코딩을 제거 => 소스 간결화, 가독성, 공통성
			 * 
			 * 1.간결, 누구나 알기쉽게, 퍼포먼스!!
			
 
 * 
 */
@Component("ssf") //@target(value={type})
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	//자동주입 => 자동으로 생성된 객체의 주소값을 넣어줌 by spring => 스프링에서 생성된 datasource를 찾아서 넣어줌
	
	@Autowired //=>id모르면 사용하기 => 찾아줌. => 스프링 내부에서 DATASOURCE로 등록된 것을 알아서 찾아줌.
	//@Qualifier("ds")
	//@Resource(name="ds") // @autowired+@qualifier
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}


	public MySqlSessionFactoryBean()
	{
		try{
			
			//충돌되는 클래스는(이미 위에서 annotation에서 사용중)=> 앞에 패키지까지 기입해야..
			org.springframework.core.io.Resource res=new ClassPathResource("Config.xml");
			//java.util.Date date=new java.util.Date(); //패키지 충돌시 기입!!
			setConfigLocation(res);
			
		}catch(Exception ex) {}
		
	}
	
}






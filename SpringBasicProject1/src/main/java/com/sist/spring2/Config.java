package com.sist.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//5.0버전 => 순수하게 자바만 이용해서 코딩할수있도록 바뀜! no xml!!
@Configuration
public class Config {
	//<bean id="empDAO" class="com.sist.spring2.EmpDAO">
	@Bean
	public EmpDAO empDAO()//메소드 명칭이 ID 명칭이 된다!
	{
		EmpDAO dao=new EmpDAO(); 
		
		dao.setDriverName("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin@localhost:XE:1521");
		dao.setUserName("hr");
		dao.setPassword("happy");
		dao.init();
		
		return dao;
		
	}
	
}

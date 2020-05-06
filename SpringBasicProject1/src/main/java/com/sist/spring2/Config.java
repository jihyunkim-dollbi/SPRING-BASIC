package com.sist.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//5.0���� => �����ϰ� �ڹٸ� �̿��ؼ� �ڵ��Ҽ��ֵ��� �ٲ�! no xml!!
@Configuration
public class Config {
	//<bean id="empDAO" class="com.sist.spring2.EmpDAO">
	@Bean
	public EmpDAO empDAO()//�޼ҵ� ��Ī�� ID ��Ī�� �ȴ�!
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

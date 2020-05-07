package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * Ŭ���� �޸� �Ҵ� Annotation
 * @Component :�Ϲ� Ŭ����
 * @Repository : DAO
 * @Service : BI(BUSINESS INTEGRATION) => ���� => DAO+DAO => SERVICE(������ DAO����) VS REPOSITORY(�ܵ�DAO) 
 * ============ for APPLICATION
 * @Controller : MODEL CLASS(jsp ���ϸ�),sendredirect..
 * @RestController : Restful => �ʿ��� ������ ����(AJAX) ==> xml or json ����
 * @ControllerAdvice :  AOP
 * ==================TOTAL: for WEB
 */
//�Ϲ� Ŭ���� �Ҵ�
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{

	/*<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		p:maxActive="20"
		p:maxIdle="10"
		p:maxWait="-1"
		made by spring
	 */
	
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(20);
		setMaxIdle(10);
		setMaxWait(-1);
		
	}
	
}

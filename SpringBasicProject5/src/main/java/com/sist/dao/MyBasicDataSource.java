package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
 * 클래스 메모리 할당 Annotation
 * @Component :일반 클래스
 * @Repository : DAO
 * @Service : BI(BUSINESS INTEGRATION) => 통합 => DAO+DAO => SERVICE(여러개 DAO묶음) VS REPOSITORY(단독DAO) 
 * ============ for APPLICATION
 * @Controller : MODEL CLASS(jsp 파일명),sendredirect..
 * @RestController : Restful => 필요한 데이터 전송(AJAX) ==> xml or json 사용시
 * @ControllerAdvice :  AOP
 * ==================TOTAL: for WEB
 */
//일반 클래스 할당
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

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
	
	
	
}

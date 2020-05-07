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
	 
	
	@Autowired => �ڵ����� => Ŭ������ �޸� �ּҸ� ���� => �������� ��ϵ� Ŭ������ ��� ����!
 	@ => TYPE
 	public class A
 	{
 		@
 		MyDAO dao; =>�ʵ� ����

		@
 		public A(MyDAO dao => String a(���x =>always shoud be class)){} => ����������

 		@
 		public void setMyDAO(MyDAO dao){} => �Ķ���� ����
 		
 		@
 		public void display(MyDAO dao){} => 
 	
 	}

		 	<Spring Roll>
			 * 1.Ŭ���� �޸� �Ҵ� ���ش�.(Ŭ���� ������)
			 * 2.�ɹ� ������ ���� ����!
			 * 3.Ŭ������ �޸� ����
			 * 4.�ݺ��ڵ��� ���� => �ҽ� ����ȭ, ������, ���뼺
			 * 
			 * 1.����, ������ �˱⽱��, �����ս�!!
			
 
 * 
 */
@Component("ssf") //@target(value={type})
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	//�ڵ����� => �ڵ����� ������ ��ü�� �ּҰ��� �־��� by spring => ���������� ������ datasource�� ã�Ƽ� �־���
	
	@Autowired //=>id�𸣸� ����ϱ� => ã����. => ������ ���ο��� DATASOURCE�� ��ϵ� ���� �˾Ƽ� ã����.
	//@Qualifier("ds")
	//@Resource(name="ds") // @autowired+@qualifier
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}


	public MySqlSessionFactoryBean()
	{
		try{
			
			//�浹�Ǵ� Ŭ������(�̹� ������ annotation���� �����)=> �տ� ��Ű������ �����ؾ�..
			org.springframework.core.io.Resource res=new ClassPathResource("Config.xml");
			//java.util.Date date=new java.util.Date(); //��Ű�� �浹�� ����!!
			setConfigLocation(res);
			
		}catch(Exception ex) {}
		
	}
	
}






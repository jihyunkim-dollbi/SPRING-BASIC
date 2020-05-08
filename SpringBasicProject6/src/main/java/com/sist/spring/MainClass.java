package com.sist.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

/* Ŭ���� �޸� �Ҵ�
 * @Component, @Repository, @Service, @Controller, @RestController,@ControllerAdvice, 
 * 
 * ����(DI)
 * @Required, @Autowired, @PostConstruct, @PreDestroy, @Resource, 
 * 
 * 
 */
//������ ���� dao�� ����� �̱⶧���� dao�� @autowired�Ͽ� �������� ��Ƴ��� ����ϱ�!

//�Ϲ�Ŭ����
@Component
public class MainClass {
	
	//�������� ���
	@Autowired
	private EmpDAO dao;
	
	@PostConstruct // => init-method�� annotation version
	public void init(){
		
		System.out.println("=========�������========");
	}
	
	@PreDestroy   // => destroy-method annotation version
	public void destroy()
	{
		System.out.println("========���α׷� ����=======");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//xml�Ѱ��ֱ�
		//ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//�������, doesn't have close()
		
		//�޸��������� �����ϴ�.
		GenericApplicationContext app=new GenericXmlApplicationContext("app.xml");
		
		
		//dao�� ���Ե�mc��������
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println(mc.dao);
		
		EmpVO vo=mc.dao.empFindData(7788);
		System.out.println("���: "+vo.getEmpno());
		System.out.println("�̸�: "+vo.getEname());
		System.out.println("����: "+vo.getJob());
		System.out.println("�Ի���: "+vo.getHiredate());
		System.out.println("�޿�: "+vo.getSal());
		
	}

}

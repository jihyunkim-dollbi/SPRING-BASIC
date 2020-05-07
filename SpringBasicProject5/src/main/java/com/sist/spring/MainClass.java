package com.sist.spring;

/*
 * ��� 1. �ڵ����� ã�ų�=> spring�� ����ؼ� ����ϱ�!! => @Autowired�� =>@component
 * ��� 2. getBean���� ���� �޾Ƽ� ����ϰų�
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component
public class MainClass {

	//���1.
	@Autowired
	private EmpDAO dao; //injected data from spring
	//=====
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		//���1.
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> list=mc.dao.empAllData();
		System.out.println(mc.dao);
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" " + vo.getJob()+ " " + vo.getSal());
		}
		
		//���2. 
	/*	EmpDAO dao=(EmpDAO)app.getBean("empDAO"); //ù���ڴ� �ҹ��ڷ�.
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" " + vo.getJob()+ " " + vo.getSal());
		}
*/
		
	}

}

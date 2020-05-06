package com.sist.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao"); //클래스 하나를 가져옴..
		List<EmpVO> list=dao.empAllData();
		
		for(EmpVO vo:list){
			
			System.out.println(vo.getEname()+ " "+ vo.getJob() + " " + vo.getHiredate().toString());
		}
		
	}

}

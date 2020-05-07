package com.sist.spring;

/*
 * 방법 1. 자동으로 찾거나=> spring에 등록해서 사용하기!! => @Autowired로 =>@component
 * 방법 2. getBean으로 직접 받아서 사용하거나
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component
public class MainClass {

	//방법1.
	@Autowired
	private EmpDAO dao; //injected data from spring
	//=====
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		//방법1.
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> list=mc.dao.empAllData();
		System.out.println(mc.dao);
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" " + vo.getJob()+ " " + vo.getSal());
		}
		
		//방법2. 
	/*	EmpDAO dao=(EmpDAO)app.getBean("empDAO"); //첫글자는 소문자로.
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" " + vo.getJob()+ " " + vo.getSal());
		}
*/
		
	}

}

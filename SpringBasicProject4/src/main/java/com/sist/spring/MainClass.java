package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//xml 파일읽기
		ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		
		//id를 주고 클래스 객체를 가져옴
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			
			System.out.println(vo.getEname()+ " " + vo.getJob());
			
		}
	}

}

package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//xml �����б�
		ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		
		//id�� �ְ� Ŭ���� ��ü�� ������
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			
			System.out.println(vo.getEname()+ " " + vo.getJob());
			
		}
	}

}

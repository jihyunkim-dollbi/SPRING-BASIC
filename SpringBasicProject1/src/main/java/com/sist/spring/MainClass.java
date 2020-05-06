package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

//DL => 등록한 것을 찾아서 사용하는 곳!
public class MainClass {
	
	// about => ref 
	private EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DL => 등록한 것을 찾아서 사용하는 곳!
		//DL => 등록된 클래스를 읽어 올때!
		
		ApplicationContext app= new ClassPathXmlApplicationContext("app.xml"); //xml 파싱 끝!
		
		MainClass mc=(MainClass)app.getBean("mc");
		
		//DL과정! getBean() => direct로 부루지 않기
		//EmpDAO dao=(EmpDAO)app.getBean("dao"); 
		
		List<EmpVO> list=mc.dao.empAllData();
		
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+ " "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+ " "
					+vo.getSal());
		}
		
		
	}

}

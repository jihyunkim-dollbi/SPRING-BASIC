package com.sist.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
 
		@Autowired
		private EmpDAO dao;
		
		public void setDao(EmpDAO dao) { // setmethod를 읽어서 값을 넣어주기때문에 항상 setmethod를 만들어줘야..new하지 않는다=> spring에서 di해줄것임.
			this.dao = dao;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			//DL => 등록한 것을 찾아서 사용하는 곳!
			//DL => 등록된 클래스를 읽어 올때!
			
			ApplicationContext app= new ClassPathXmlApplicationContext("app.xml"); //xml 파싱 끝!
						
			MainClass2 mc=(MainClass2)app.getBean("mc2");

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


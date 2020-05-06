package com.sist.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
 
		@Autowired
		private EmpDAO dao;
		
		public void setDao(EmpDAO dao) { // setmethod�� �о ���� �־��ֱ⶧���� �׻� setmethod�� ��������..new���� �ʴ´�=> spring���� di���ٰ���.
			this.dao = dao;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			//DL => ����� ���� ã�Ƽ� ����ϴ� ��!
			//DL => ��ϵ� Ŭ������ �о� �ö�!
			
			ApplicationContext app= new ClassPathXmlApplicationContext("app.xml"); //xml �Ľ� ��!
						
			MainClass2 mc=(MainClass2)app.getBean("mc2");

			//DL����! getBean() => direct�� �η��� �ʱ�
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


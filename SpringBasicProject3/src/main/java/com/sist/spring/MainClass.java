package com.sist.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//컨테이너에 XML파일 전송 => 파싱 => 등록된 클래스의 메모리 할당!
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		/*
		 * 1.클래스 메모리 할당! 
		 * 2.setxxx()에 값을 채운다
		 * 3.init-method가 존재하면 호출까지 끝!
		 * ===========================
		 * 프로그래머가 필요한 메소드를 호출 사용 가능
		 * ===========================
		 * 5.destroy-method를 호출!
		 * 6.메모리를 해제
		 * 
		 */
		
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empAllData();
		
		for(EmpVO vo:list)
		{
			
			System.out.println(vo.getEname()+ " "+ vo.getSal()+ " " + vo.getJob());
			
		}
		
	}

}

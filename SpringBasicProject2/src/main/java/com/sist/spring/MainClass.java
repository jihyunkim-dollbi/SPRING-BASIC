package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		SawonContainer sc=(SawonContainer)app.getBean("sc"); //dl id를 넣어주고 주소값을 찾아오는 것.
		sc.display();
		
		/*
		 *  1 홍길동 30 남자
			2 춘향이 31 여자
			3 이순신 29 남자
		 * 
		 */
	}

}

package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app= new ClassPathXmlApplicationContext("app.xml");
		SawonContainer sc=(SawonContainer)app.getBean("sc"); //dl id�� �־��ְ� �ּҰ��� ã�ƿ��� ��.
		sc.display();
		
		/*
		 *  1 ȫ�浿 30 ����
			2 ������ 31 ����
			3 �̼��� 29 ����
		 * 
		 */
	}

}

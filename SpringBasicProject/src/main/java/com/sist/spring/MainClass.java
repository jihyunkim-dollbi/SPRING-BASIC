package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//메모리 할당 과정!
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//XML 파싱
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//클래스 관리하는 아이 => 여기에 등록된 것을 모두 app에 넣음
		
		//등록된 사원클래스를 사용!
		Sawon sa=(Sawon)app.getBean("sa5");//id명칭 sa3
		//클래스 사용 .getBean("id넣기!")
		System.out.println("sa:"+sa);
		System.out.println("사번:"+sa.getSawon());
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		
		/*  sa:com.sist.spring.Sawon@64f6106c
			사번:1
			이름:홍길동
			부서:개발부
			depengency injection? DI => 저장해 놓은 값을 메모리 할당할때! => 값을 채워놓는 것.
			
			1. DI
			2. AOP
		*/
		
		//sa.display();
		//sa.setSawon(1);
		//sa.setName("홍길동");
		//sa.setDept("개발부");
		
		//Sawon sa1=(Sawon)app.getBean("sa");
		//System.out.println("sa1:"+sa1);
		//sa1.display();

		//sa1.setSawon(2);
		//sa1.setName("심청이");
		//sa1.setDept("영업부");
		//싱글톤의 단점 => 마지막으로 저장된 값으로 모두 값이 바뀐다.
		
		/*
		  	sa:com.sist.spring.Sawon@2a742aa2
			Sawon:display() call...
			sa1:com.sist.spring.Sawon@2a742aa2
			Sawon:display() call...

		 * 	싱글톤! 주소값이 동일!
		 *  따라서 Sawon의 getter,setter의 값을 변경 가능함=> 그 전의 값들을 바꿀 수있다.
		 *  
		 * 객체 메모리..배열과 다르게 다른 데이터 형이 와도 오케이!
		 * sawon name dept자체가  하나의 객체!
		 */
		
		// scope="protoType" 을 설정후 ==> 아래처럼 주소가 서로 바뀜! 
		/*
		sa:com.sist.spring.Sawon@bd8db5a
		sa1:com.sist.spring.Sawon@2f943d71
		홍길동
		심청이
		*/
		
	}
	
}

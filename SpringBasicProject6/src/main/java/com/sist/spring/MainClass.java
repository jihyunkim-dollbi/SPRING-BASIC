package com.sist.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

/* 클래스 메모리 할당
 * @Component, @Repository, @Service, @Controller, @RestController,@ControllerAdvice, 
 * 
 * 주입(DI)
 * @Required, @Autowired, @PostConstruct, @PreDestroy, @Resource, 
 * 
 * 
 */
//앞으로 여러 dao가 생길것 이기때문에 dao를 @autowired하여 전역으로 잡아놓고 사용하기!

//일반클래스
@Component
public class MainClass {
	
	//전역으로 사용
	@Autowired
	private EmpDAO dao;
	
	@PostConstruct // => init-method의 annotation version
	public void init(){
		
		System.out.println("=========사원정보========");
	}
	
	@PreDestroy   // => destroy-method annotation version
	public void destroy()
	{
		System.out.println("========프로그램 종료=======");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//xml넘겨주기
		//ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//종료못함, doesn't have close()
		
		//메모리해제까지 가능하다.
		GenericApplicationContext app=new GenericXmlApplicationContext("app.xml");
		
		
		//dao가 주입된mc가져오기
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println(mc.dao);
		
		EmpVO vo=mc.dao.empFindData(7788);
		System.out.println("사번: "+vo.getEmpno());
		System.out.println("이름: "+vo.getEname());
		System.out.println("직위: "+vo.getJob());
		System.out.println("입사일: "+vo.getHiredate());
		System.out.println("급여: "+vo.getSal());
		
	}

}

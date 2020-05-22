package com.sist.aspect;

import java.security.Signature;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//공통기반의 클래스 => 메모리할당은 따로 해줘야한다. 
@Aspect
@Component
public class MyAspect {
	
	// execution(* com.sist.dao.EmpDAO.emp_*(..)) => pointCut
	// @Before => JoinPoint
	// total => advice 
	// advices => advisor!
	/*
	 * 	메소드 호출전
	 * 	* com.sist.dao.EmpDAO.emp_*(..)
	 *  =리턴형
	 *    ==========클래스명
	 *    					  =====시작하는 메소드..(매개변수 는 관계없이) 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	@Before("execution(* com.sist.dao.EmpDAO.emp_*(..))") //* 메소드의 리턴형!!(스트링/인트형!) => 전에 호출!/ .. 매개변수 0 이상!!
	public void getConenction()
	{
		System.out.println("오라클 연결");
	}
	
	@After("execution(* com.sist.dao.EmpDAO.emp_*(..))")  //후에 호출!
	public void disConenction()
	{
		System.out.println("오라클 연결 해제");
	}
	
	
	//정상수행이 된 경우 ret=리턴값
	//returing => "ret" => 리턴값을 받았다는 것은 정상수행을 했다는 것.
	//2개 매개변수
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp_*(..))", returning="ret")
	public void returnValue(Object ret)
	{
		if(ret!=null)
			System.out.println(ret);
	}
	
	//메소드 수행하는 과정 => 오류가 발생할 경우에 처리.
	//2개 매개변수
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp_*(..))", throwing="ex")
	public void exevrionValue(Throwable ex)
	{
		System.out.println(ex.getMessage());
	}
	
	//트랜젝션 처리시
	//log 파일제작! 시작과 끝의 시간을 도출할때. 처리시간구하기.
	//어떤 메소드를 많이 사용하는지
	@Around("execution (* com.sist.dao.EmpDAO.display())")
	public Object display(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println(jp.getSignature().getName());
		long start=System.currentTimeMillis();
		//setAutoCommit(false)
		Object obj=jp.proceed(); //display 호출@
		//conn.commit()
		long end=System.currentTimeMillis();
		System.out.println("수행시간"+ (end-start));
		
		return obj;
	}
	
	
}

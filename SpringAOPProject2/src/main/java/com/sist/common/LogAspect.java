package com.sist.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//서비스! 여러 dao를 동시에 사용가능1!
@Component
@Aspect
public class LogAspect {

	//LOG 파일 만들기 => 파일에 저장하기
	@Around("execution(* com.sist.web5.EmpController.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("사용자 요청 기능: "+jp.getSignature().getName()); //어떤 함수 호출되었는지
		long start=System.currentTimeMillis(); //시작시간
		Object obj=jp.proceed(); //호출한 메소드
		long end=System.currentTimeMillis(); //종료시간
		System.out.println("수행시간: "+(end-start));
		System.out.println(jp.getSignature().getName()+":종료");
		return obj;
		
		/*사용자 요청 기능: emp_list
		    수행시간: 536
		  emp_list:종료
		    사용자 요청 기능: emp_insert
		    수행시간: 5
		  emp_insert:종료 
		 */
		
	}
	
}

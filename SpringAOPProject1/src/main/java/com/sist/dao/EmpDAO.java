package com.sist.dao;

import org.springframework.stereotype.Repository;

/*
 * oop => 반복 => method로 만들어서 함수화 반복해서 사용가능하도록
 * 객체지향 => spring에 의해 자동으로 호출될 수있도록 만듬. => 공통부분을 자동으로 호출되도록 하는것 => AOP방식
 * AOP => ASPECT OBJECT PROGRAMMING => 행단지향적 => 모든 절차에 필요한 위치에 적용시키기 가능..(게시판, 로그인, ETC.. )
 * 자바에는 CALL BACK 함수 없어서(NOT BY 사용자정의)..ONLY MAIN
 * 
 * AOP(클래스 단위)=INTERCEPTER(function단위)
 * 
 * AOP=> 
 * 1)공통모듈화 : Aspect
 * ===================================
 * 2)사용해야할 메소드 : PointCut
 * 3)어떤시점에서?=> 특정 처리 전후 : Join Point
 * 	  public  select()
 * 	  {	
 * 				BEFORE(항상 실행하는 문장이되,, 중요처리 전 실행해라 )
 * 
 * 		try{
 * 			=> AROUND 위 아래 두군데! 
 * 		
 * 		}
 * 		catch(exception ex){
 * 			
 * 			=>AFTER-THROWING => ERROR에서 처리
 * 		
 * 		}finally{
 * 
 * 			=> AFTER(항상 실행하는 문장이되,, 중요처리 후 실행해라 )
 * 		}
 * 		return 		=> AFTER-RETURNING
 * 
 *    }
 * 
 * 		AFTER-THROWING/RETURNING => 결과값을 알수있다. 정상수행시 OR 에러시
 * 
 * ===================================> Advice => Advisor(advice's') => Aspect!
 */
@Repository
public class EmpDAO {

	
	public void emp_select(){
		
		//getConenction(); => 공통!
		System.out.println("데이터 가져옴!"); // => 핵심!
		//disConenction();
	}
	
	public void emp_insert(){
		
		//getConenction();
		System.out.println("데이터 입력!");
		//disConenction();
	}

	public void emp_update(){
		
		//getConenction();
		//int a=10/0;
		System.out.println("데이터 수정!");
		//disConenction();
	}

	public String emp_delete(){
		
		//getConenction();
		System.out.println("데이터 삭제!");
		//disConenction();
		
		return "삭제완료!!";
	}
	
	//자동호출이 적용되는 메소드와 적용시키지 말아야하는 메소드를 구분하여 처리하기.
	//자동호출이 되는 부분에 적용시키기 => 모든 클래스에 적용이 된다 => LIKE "로그인 하세요.."
	public void driverClassNameConfig()
	{
		System.out.println("오라클 드라이버 연결");
	}
	
	public void display()
	{
		for(int i=0; i<=100000000; i++)
		{
			System.out.println("for문 종료");
		}
		
	}
	
	
	
}

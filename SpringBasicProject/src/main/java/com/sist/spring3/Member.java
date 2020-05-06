package com.sist.spring3;

//스프링은 xml을 통해 객체를 생성해야한다.
//따라서 DI해야.
//따라서 필요한 데이터가 있을땐 setmethod를 사용하던지 construction을 사용하던지..
//meta-data..
public class Member {

	public void display(){
		
		System.out.println("member: display() CALL...");
		
	}
	
}

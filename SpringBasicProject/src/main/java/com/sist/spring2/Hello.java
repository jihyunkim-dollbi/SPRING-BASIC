package com.sist.spring2;

public interface Hello {

	public void display();
	
	//1.8에서 변경된 interface 기능!
	//interface 만들고 다시 수정시 이미 구현된 메시지는=> 구현 후에  default를 추가해주면 => 오류 사라짐 => 1.8에서 변경됨!
	//+default, +static
	public default void sayHello(){}
	public static void sayHello2(){}
	
	//앞으로 interface의 역학을 클
	
}

package com.sist.spring2;

public interface Hello {

	public void display();
	
	//1.8���� ����� interface ���!
	//interface ����� �ٽ� ������ �̹� ������ �޽�����=> ���� �Ŀ�  default�� �߰����ָ� => ���� ����� => 1.8���� �����!
	//+default, +static
	public default void sayHello(){}
	public static void sayHello2(){}
	
	//������ interface�� ������ Ŭ
	
}

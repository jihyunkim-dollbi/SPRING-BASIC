package com.sist.spring;

public class Sawon {
	
	private int sawon;
	private String name, dept;
	
	//����Ʈ�� �Ű������� ���� �����ڷ� ����� �߰� �Ʒ��� �Ű������� �ִ� �����ڸ� ���� ����.."com.sist.spring.Sawon"
	public Sawon(){
		
		
	}
	
	//source => using feild
	public Sawon(int sawon, String name, String dept) {
		
		this.sawon = sawon;
		this.name = name;
		this.dept = dept;
	}


	public int getSawon() {
		return sawon;
	}
	public void setSawon(int sawon) {
		this.sawon = sawon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	
	public void display(){
		System.out.println("Sawon:display() call...");
		
	}
}

package com.sist.spring;

public class Sawon {
	
	private int sawon;
	private String name, dept;
	
	//디폴트로 매개변수가 없는 생성자로 사용을 했고 아래는 매개변수가 있는 생성자를 따로 만들어봄.."com.sist.spring.Sawon"
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

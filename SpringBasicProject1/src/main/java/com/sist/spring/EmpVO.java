package com.sist.spring;
/*
 * DI!
 * XML을 이용해서 만들기!
 *	
 * 스프링이 관리하는 클래스가 아니다.
 * vo => 일반 테이터형! 사용자정의 데이터형! => 따라서, 등록x
 * bean class(not vo) => 기능을 가진 class => ex ) dao.. etc
 * 
 * 스프링에서의 등록이란
 * 1) XML
 * 2) ANNOTATION
 * 3) XML+ANNOTATION
 * 	  ==============
 * 		=> ANNOTATION : 사용자 정의 클래스에 사용가능!
 * 		=> XML : 라이브러리 등록시 사용(MYBATIS, JDBC => 이미 만들어져있는 클래스 ANNOTATION 사용X)
 *   ex) sqlsessionfactory => 기존의 라이브러리에는 annotation사용 불가능..so by xml 


@메모리할당
@repository 
dao/data

@service
dao+manager

@component
일반 클래스

@controller
모델 클래스        
    
@aspect 
공통기반    
    
 */
//dao 연동하기
import java.util.*;
public class EmpVO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int comm;
	private int sal;
	private int deptno;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}

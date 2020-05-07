package com.sist.spring;
/*
 * DI!
 * XML�� �̿��ؼ� �����!
 *	
 * �������� �����ϴ� Ŭ������ �ƴϴ�.
 * vo => �Ϲ� ��������! ��������� ��������! => ����, ���x
 * bean class(not vo) => ����� ���� class => ex ) dao.. etc
 * 
 * ������������ ����̶�
 * 1) XML
 * 2) ANNOTATION
 * 3) XML+ANNOTATION
 * 	  ==============
 * 		=> ANNOTATION : ����� ���� Ŭ������ ��밡��!
 * 		=> XML : ���̺귯�� ��Ͻ� ���(MYBATIS, JDBC => �̹� ��������ִ� Ŭ���� ANNOTATION ���X)
 *   ex) sqlsessionfactory => ������ ���̺귯������ annotation��� �Ұ���..so by xml 


@�޸��Ҵ�
@repository 
dao/data

@service
dao+manager

@component
�Ϲ� Ŭ����

@controller
�� Ŭ����        
    
@aspect 
������    
    
 */
//dao �����ϱ�
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

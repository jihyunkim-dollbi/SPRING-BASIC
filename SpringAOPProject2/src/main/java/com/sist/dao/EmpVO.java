package com.sist.dao;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpVO {

	private int empno, mgr, comm, sal, deptno;
	private String ename, job;
	private Date hiredate;
	
	private DeptVO dvo=new DeptVO();
}

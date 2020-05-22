package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;



public interface EmpMapper1 {


	@Results({
		//join시
		//resultmap은 이렇게 받기
		@Result(property="empno",column="empno"), //변수명, 컬럼명 //like resultMap => annotaion에서는 results
		@Result(property="ename",column="ename"),
		@Result(property="job",column="job"),
		@Result(property="mgr",column="mgr"),
		@Result(property="hiredate",column="hiredate"),
		@Result(property="sal",column="sal"),
		@Result(property="comm",column="comm"),
		@Result(property="deptno",column="deptno"),
		@Result(property="dvo.dname",column="dname"),
		@Result(property="dvo.loc",column="loc")
		
	}) 
	@Select("SELECT empno, ename, job, hiredate, sal, dname, loc "
			+"FROM emp , dept "
			+"WHERE emp.deptno=dept.deptno "
			+"ORDER BY sal DESC")
	public List<EmpVO> empAllData(); 	
	
	@Select("SELECT DISTINCT mgr FROM emp")
	public List<Integer> empGetMgr();
	
	@Select("SELECT DISTINCT job FROM emp")
	public List<String> empGetJob();
	
	//join과 관련x
	//
	@SelectKey(keyProperty="empno",resultType=int.class, before=true,
			statement="SELECT NVL(MAX(empno)+1,1) as empno FROM emp")
	@Insert("INSERT INTO emp VALUES("
			+"#{empno},#{ename}, #{job}, #{mgr}, #{hiredate},#{sal}, #{comm}, #{deptno})")
	public void empInsert(EmpVO vo);
}

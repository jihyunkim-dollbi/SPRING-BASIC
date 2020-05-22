package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
//setEmpno(rs.getInt("empno"))
//column을 찾아서 동일한 컴럼에 있는 값을 property의 set메소드와 일치하는 변수명에 값을 넣어.
//dvo.dname => getDvo().setDname(rs.getString("dname"));
//index번호 사용x => 컬럼명지정!                     ======컬럼명 or 순번! =>함수x => alias사용하기!
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

public interface EmpMapper {

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
	@Select("SELECT empno, ename, job, hiredate, sal, dname, loc, comm "
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
			+"#{empno},#{ename}, #{job}, #{mgr}, SYSDATE ,#{sal}, #{comm}, #{deptno})")
	public void empInsert(EmpVO vo);
}

package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;
//xml필요
//sql문장 주고 함수 만들기
public interface MemberMapper {

	
	@SelectKey(keyProperty="no",resultType=int.class, before=true, 
			statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	@Insert("INSERT INTO spring_member VALUES("
			+ "#{no},#{name},#{sex},#{addr}, #{tel})"
			)
	//함수만들기
	public void memberInsert(MemberVO vo); //구현
	//	  void: resulttype	 memberInsert:id   MemberVO vo: parameter class
	//resultType => 리턴형, parameterType => 매개변수 , id => 메소드명
	
	/*
	 * <select id="memberAllData" resulttype="membervo">
	 * SELECT * FROM spring_member
	 * </select>
	 */
	@Select("SELECT * FROM spring_member")
	public List<MemberVO> memberAllData(); 
	
	
	@Select("SELECT * FROM spring_member "
			+"WHERE no=#{no}")
	public MemberVO MemberDetailData(int no);
	
}

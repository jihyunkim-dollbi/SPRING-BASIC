package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import java.util.*;
//xml�ʿ�
//sql���� �ְ� �Լ� �����
public interface MemberMapper {

	
	@SelectKey(keyProperty="no",resultType=int.class, before=true, 
			statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_member")
	@Insert("INSERT INTO spring_member VALUES("
			+ "#{no},#{name},#{sex},#{addr}, #{tel})"
			)
	//�Լ������
	public void memberInsert(MemberVO vo); //����
	//	  void: resulttype	 memberInsert:id   MemberVO vo: parameter class
	//resultType => ������, parameterType => �Ű����� , id => �޼ҵ��
	
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

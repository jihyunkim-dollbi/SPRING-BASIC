package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * vo는 데이터형이기때문에 spring에서 관리x => 나머지 클래서는 spring에서 관리
 * 
 * Model => Controller=> BoardController managed by spring
 * VO
 * DAO managed by spring ,@repository
 * Service managed  by spring ,@service
 * Manager managed by spring ,@component
 * ======================================> Model
 * 
 * @Component
 * @Repository
 * @Service
 * @Controller
 * @RestController
 * 
 * ==================================================
 * 
 * 
 * Spring Life-Cycle => 객채관리 생명주기
 * 
 * 1. 메모리 할당 =>등록된 모든 클래스 =>Map에 저장!
 * 		c: (생성자값 있는지 확인) <constructor-arg>
 * 2. 검색 =><property> or p tag search! => so , DI 존재여부 확인!!
 * 3. 존재하면 => setXxx()메소드에 주입!
 * 4. 메소드 DI가 존재하는지 여부 확인(FIRST init-method)
 * 5. 존재하면 => 메소드 호출!
 * ==================================================
 * 6. 프로그래머가 필요한 메소드 호출(사용자 사용)
 * 		=> 프로그램 종료, 사이트 이동시 => 자동으로 컨테이너가 닫긴다.
 * ==================================================
 * 7. 메소드 존재여부 확인(destroy-method)
 * 8. 객체 소멸
 * 
 */
import org.springframework.stereotype.Repository;

//auto commit, auto close, auto open => 스프링에서 모두 구현해준다.
//xml을 줄이고 자바로만 코딩
@Repository  
public class MemberDAO {
	
	  //membermapper를 spring이 구현 => 구현된 주소값 받기
	  @Autowired
	  private MemberMapper mapper;
	  
	  public List<MemberVO> memberAllData()
	  {  
		  return mapper.memberAllData();
	  }
	  
	  public MemberVO memberDetailData(int no)
	  {  
		  return mapper.MemberDetailData(no);
	  }
	  
	  
	  public void memberInsert(MemberVO vo)
	  {
		  mapper.memberInsert(vo);  
	  }
	  
	  
	  
}

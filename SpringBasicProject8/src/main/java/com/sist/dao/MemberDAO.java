package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * vo�� ���������̱⶧���� spring���� ����x => ������ Ŭ������ spring���� ����
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
 * Spring Life-Cycle => ��ä���� �����ֱ�
 * 
 * 1. �޸� �Ҵ� =>��ϵ� ��� Ŭ���� =>Map�� ����!
 * 		c: (�����ڰ� �ִ��� Ȯ��) <constructor-arg>
 * 2. �˻� =><property> or p tag search! => so , DI ���翩�� Ȯ��!!
 * 3. �����ϸ� => setXxx()�޼ҵ忡 ����!
 * 4. �޼ҵ� DI�� �����ϴ��� ���� Ȯ��(FIRST init-method)
 * 5. �����ϸ� => �޼ҵ� ȣ��!
 * ==================================================
 * 6. ���α׷��Ӱ� �ʿ��� �޼ҵ� ȣ��(����� ���)
 * 		=> ���α׷� ����, ����Ʈ �̵��� => �ڵ����� �����̳ʰ� �ݱ��.
 * ==================================================
 * 7. �޼ҵ� ���翩�� Ȯ��(destroy-method)
 * 8. ��ü �Ҹ�
 * 
 */
import org.springframework.stereotype.Repository;

//auto commit, auto close, auto open => ���������� ��� �������ش�.
//xml�� ���̰� �ڹٷθ� �ڵ�
@Repository  
public class MemberDAO {
	
	  //membermapper�� spring�� ���� => ������ �ּҰ� �ޱ�
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

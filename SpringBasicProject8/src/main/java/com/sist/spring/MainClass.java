package com.sist.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import java.util.*;
/*
 * 여러개의 함수가 있는 경우 dao를 사용하는 곳에서 전역으로 올리고 사용하도록한다.
 * <dao를 사용하는 곳이 여러군데..>
 * insert() -dao
 * update() -dao
 * delete() -dao
 * select() -dao
 * detail() -dao
 * 
 * 현재, 메인 한군데서만 사용하므로 getBean으로 클래스객체 가져오는 게 편리.
 */

//스프링 메모리할당 =>내가 요청한 객체주소 받기 가능!
@Component
public class MainClass {
	
	//주소값 받기는 스프링에서 메모리할당을 한 후에 가능하다.
	@Autowired
	private MemberDAO dao;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");// xml넘기고 파싱하고 메모리할당 하고 setter까지 값 주입까지 끝!!
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<MemberVO> list=mc.dao.memberAllData();
		for(MemberVO vo:list)
		{
			System.out.println(vo.getNo()+" "+ vo.getName()+ " "+vo.getAddr()+ " "+ vo.getTel()+ " "+vo.getSex());
		}
		
		
	}

}

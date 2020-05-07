package com.sist.temp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * =================================
 * app
 * =================================
 * key			class 주소
 * =================================
 * boardDAO		100
 * =================================
 * noticeDAO	200
 * =================================
 * mainclass	300 ==> MyDAO
 * =================================
 */

@Component
public class MainClass {

	//주소값을 자동 주입
	//@Autowired =>단점:id를 특정할수없다.
	//@Qualifier("boardDAO")  => autowired와 같이 사용
	//@Autowired + @Qualifier => @Resource
	@Resource(name="noticeDAO")
	private MyDAO dao;
	//메모리 할당 해야 dao에 주소 값을 넣어주어야한다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//noticedao / boarddao
		//두 개의 dao는 spring에서 메모리할당을 해야(xml로 등록) 사용 가능하다. => 할당된 메모리를 사용하기 위해서는 같은 spring 관리영역 안에서 존재해야한다.
		//xml읽고 getBean() 사용하여 할당된 메모리를 끌어다 사용 가능!
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//package를 등록해놓았고 그 안에서 annotation된 것을 메모리할당 할 것
	
		//스프링에서 할당한 주소값을 가져올때
		MainClass mc=(MainClass)app.getBean("mainClass"); //주소이름 mainClass
		mc.dao.select();
		// error 
		// expected single matching bean but found 2: boardDAO,noticeDAO
		// @Autowired 쓰되 특정객체를 지정 해줘야한다. => @QUALIFIER를 함께 사용해야한다.
		
	}

}

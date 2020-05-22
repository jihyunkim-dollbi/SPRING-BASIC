package com.sist.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Component
public class MainClass {
	@Autowired
	private EmpDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자정의 클래스를 스프링 컨데이너에 올림 => ApplicationContext => WEB에서는 DS가 올려줌.(CHECK IT IN WEB.XML)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");// Class path를 사용하는 
		
		//최적하하기
		//인덱스 => sort해서 가져옴! better than order by(2차배열..so slow)
		//메모 => 하나만 생성
		//call back => 한 단계만 거쳐서 매번 호출가능
		//트리거
		
		MainClass mc=(MainClass)app.getBean("mainClass");
	
		mc.dao.emp_select();
		mc.dao.emp_delete();
		mc.dao.emp_insert();
		mc.dao.emp_update();
		mc.dao.display();
		
		
	}

}

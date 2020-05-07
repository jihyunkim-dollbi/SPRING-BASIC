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
 * key			class �ּ�
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

	//�ּҰ��� �ڵ� ����
	//@Autowired =>����:id�� Ư���Ҽ�����.
	//@Qualifier("boardDAO")  => autowired�� ���� ���
	//@Autowired + @Qualifier => @Resource
	@Resource(name="noticeDAO")
	private MyDAO dao;
	//�޸� �Ҵ� �ؾ� dao�� �ּ� ���� �־��־���Ѵ�.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//noticedao / boarddao
		//�� ���� dao�� spring���� �޸��Ҵ��� �ؾ�(xml�� ���) ��� �����ϴ�. => �Ҵ�� �޸𸮸� ����ϱ� ���ؼ��� ���� spring �������� �ȿ��� �����ؾ��Ѵ�.
		//xml�а� getBean() ����Ͽ� �Ҵ�� �޸𸮸� ����� ��� ����!
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//package�� ����س��Ұ� �� �ȿ��� annotation�� ���� �޸��Ҵ� �� ��
	
		//���������� �Ҵ��� �ּҰ��� �����ö�
		MainClass mc=(MainClass)app.getBean("mainClass"); //�ּ��̸� mainClass
		mc.dao.select();
		// error 
		// expected single matching bean but found 2: boardDAO,noticeDAO
		// @Autowired ���� Ư����ü�� ���� ������Ѵ�. => @QUALIFIER�� �Բ� ����ؾ��Ѵ�.
		
	}

}

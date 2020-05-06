package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//�޸� �Ҵ� ����!
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//XML �Ľ�
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//Ŭ���� �����ϴ� ���� => ���⿡ ��ϵ� ���� ��� app�� ����
		
		//��ϵ� ���Ŭ������ ���!
		Sawon sa=(Sawon)app.getBean("sa5");//id��Ī sa3
		//Ŭ���� ��� .getBean("id�ֱ�!")
		System.out.println("sa:"+sa);
		System.out.println("���:"+sa.getSawon());
		System.out.println("�̸�:"+sa.getName());
		System.out.println("�μ�:"+sa.getDept());
		
		/*  sa:com.sist.spring.Sawon@64f6106c
			���:1
			�̸�:ȫ�浿
			�μ�:���ߺ�
			depengency injection? DI => ������ ���� ���� �޸� �Ҵ��Ҷ�! => ���� ä������ ��.
			
			1. DI
			2. AOP
		*/
		
		//sa.display();
		//sa.setSawon(1);
		//sa.setName("ȫ�浿");
		//sa.setDept("���ߺ�");
		
		//Sawon sa1=(Sawon)app.getBean("sa");
		//System.out.println("sa1:"+sa1);
		//sa1.display();

		//sa1.setSawon(2);
		//sa1.setName("��û��");
		//sa1.setDept("������");
		//�̱����� ���� => ���������� ����� ������ ��� ���� �ٲ��.
		
		/*
		  	sa:com.sist.spring.Sawon@2a742aa2
			Sawon:display() call...
			sa1:com.sist.spring.Sawon@2a742aa2
			Sawon:display() call...

		 * 	�̱���! �ּҰ��� ����!
		 *  ���� Sawon�� getter,setter�� ���� ���� ������=> �� ���� ������ �ٲ� ���ִ�.
		 *  
		 * ��ü �޸�..�迭�� �ٸ��� �ٸ� ������ ���� �͵� ������!
		 * sawon name dept��ü��  �ϳ��� ��ü!
		 */
		
		// scope="protoType" �� ������ ==> �Ʒ�ó�� �ּҰ� ���� �ٲ�! 
		/*
		sa:com.sist.spring.Sawon@bd8db5a
		sa1:com.sist.spring.Sawon@2f943d71
		ȫ�浿
		��û��
		*/
		
	}
	
}

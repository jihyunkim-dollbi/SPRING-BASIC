package com.sist.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class MainClass {
	
	public MainClass() {
		// TODO Auto-generated constructor stub
	
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(Config.class);
		
		EmpDAO dao=(EmpDAO)ctx.getBean("empDAO", EmpDAO.class); // 후자와 같이 형변환을 안해도 ok!
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEname()+" "+vo.getJob()+" "+ vo.getSal());
			
		}
		
	}
	
	
}

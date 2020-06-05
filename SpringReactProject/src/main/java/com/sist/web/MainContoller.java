package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//JS파일을 번들로 묶어서 배포하여 => 배포한것을 스프링에 적용한다
//데이터는 스프링에서 오라클을 이용해 가져오고 가져와서 JSON으로 파일을 만들고 JSON을 JS에게 보낸다!
//REACT, REDUX 하이버전은 웹팩으로 해야 스프링에 적용가능 !!
@Controller
public class MainContoller {
		
	  //서버돌리기위해
	  @RequestMapping("main/main.do")
	  public String main_page()
	  {
		  return "main/main";
	  }
}

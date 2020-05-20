package com.sist.web;
//ajax - sugguest 검색창!

import org.springframework.stereotype.Controller;
//화면이동 위한 컨트롤러!
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	
	//실제로 화면을 뛰우기위함 not for data 'json'
	@RequestMapping("main/list.do")
	public String main_list()
	{
		return "main/list";
	}
	
	@RequestMapping("main/detail.do")
	public String main_detail()
	{
		return "main/detail";
	}
	
	
	
}

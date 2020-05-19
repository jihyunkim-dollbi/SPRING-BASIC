package com.sist.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("main.do")
	public String main_page()
	{
		
		return "main"; //definition => name명과동일하게.
	}
	
	@RequestMapping("board/list.do")
	public String board_list()
	{
		
		return "board/list"; //definition => name명과동일하게.
	}
	
	
	@RequestMapping("notice/list.do")
	public String notice_list()
	{
		
		return "notice/list"; //definition => name명과동일하게. => value의 파일을 실행한다.
	}
}

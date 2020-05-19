package com.sist.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("main.do")
	public String main_page()
	{
		
		return "main"; //definition => name��������ϰ�.
	}
	
	@RequestMapping("board/list.do")
	public String board_list()
	{
		
		return "board/list"; //definition => name��������ϰ�.
	}
	
	
	@RequestMapping("notice/list.do")
	public String notice_list()
	{
		
		return "notice/list"; //definition => name��������ϰ�. => value�� ������ �����Ѵ�.
	}
}

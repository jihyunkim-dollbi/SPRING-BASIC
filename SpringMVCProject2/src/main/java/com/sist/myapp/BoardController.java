package com.sist.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.*;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list(Model model, String page) //data from web is always String!
	{
		//매개변수(로 사용자의 요청값 받음!)의 역할=> 사용자의 요청값을 받는다.
		
		//int로 page를 받을 수도 있지만 맨처음 default page를 지정해줘야하기 때문에 String으로!
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		//시작,끝 맵에 넣기
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		
		map.put("start", start);
		map.put("end", end);
	
		List<BoardVO> list=dao.boardListData(map);
		
		int totalpage=dao.boardTotalPage();
		//////// 요청에 대한 처리
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		//////// 처리된 결과값 전송!
		
		return "board/list";
	}
	
	//http://localhost/myapp/board/insert.do
	//				   =====>package name => 디폴트 path
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";		
		//화면만 보여줌..
	}
	
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)//사용자로 부터 받은 입력값을 vo에 넣어줘! => spring이 자동으로 vo에 값을 넣어줌!!
	{
		//dao연결!
		dao.boardInsert(vo);
		
		return "redirect:../board/list.do";
	}
	
	
	//form tag  => post
	//else => get
	@GetMapping("board/detail.do")
	public String board_detail(Model model, int no)
	{					//model => 보내주는 값 있어? , int no => 사용자로부터 받는 매개변수
		
		//dao연동
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		
		return "board/detail";
		
	}
	
	
	@GetMapping("board/update.do")
	public String board_update(Model model, int no)
	{
		//dao연동
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		
		return "board/update";
		
	}
	
	//삭제 눌렀을때  비번비교 창 뛰우는 것까지!  비번 확인 누르는 것은 => delete_ok.do => restcontroller에서 처리하기!!
	@GetMapping("board/delete.do")
	public String board_delete(Model model, int no) //detail에 있던 hidden no를 넘겨 받음!
	{
		model.addAttribute("no", no); //이 no는 다시 delete.jsp로 아래처럼!리턴후 delete_ok.do에서 사용될 것임!!
		
		return "board/delete";
	}
	
	
	
}

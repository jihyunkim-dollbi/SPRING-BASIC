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
		//�Ű�����(�� ������� ��û�� ����!)�� ����=> ������� ��û���� �޴´�.
		
		//int�� page�� ���� ���� ������ ��ó�� default page�� ����������ϱ� ������ String����!
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		//����,�� �ʿ� �ֱ�
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		
		map.put("start", start);
		map.put("end", end);
	
		List<BoardVO> list=dao.boardListData(map);
		
		int totalpage=dao.boardTotalPage();
		//////// ��û�� ���� ó��
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		//////// ó���� ����� ����!
		
		return "board/list";
	}
	
	//http://localhost/myapp/board/insert.do
	//				   =====>package name => ����Ʈ path
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";		
		//ȭ�鸸 ������..
	}
	
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)//����ڷ� ���� ���� �Է°��� vo�� �־���! => spring�� �ڵ����� vo�� ���� �־���!!
	{
		//dao����!
		dao.boardInsert(vo);
		
		return "redirect:../board/list.do";
	}
	
	
	//form tag  => post
	//else => get
	@GetMapping("board/detail.do")
	public String board_detail(Model model, int no)
	{					//model => �����ִ� �� �־�? , int no => ����ڷκ��� �޴� �Ű�����
		
		//dao����
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		
		return "board/detail";
		
	}
	
	
	@GetMapping("board/update.do")
	public String board_update(Model model, int no)
	{
		//dao����
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		
		return "board/update";
		
	}
	
	//���� ��������  ����� â �ٿ�� �ͱ���!  ��� Ȯ�� ������ ���� => delete_ok.do => restcontroller���� ó���ϱ�!!
	@GetMapping("board/delete.do")
	public String board_delete(Model model, int no) //detail�� �ִ� hidden no�� �Ѱ� ����!
	{
		model.addAttribute("no", no); //�� no�� �ٽ� delete.jsp�� �Ʒ�ó��!������ delete_ok.do���� ���� ����!!
		
		return "board/delete";
	}
	
	
	
}

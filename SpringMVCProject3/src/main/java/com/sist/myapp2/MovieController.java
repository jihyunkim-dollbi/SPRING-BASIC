package com.sist.myapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.mgr.NewsManager;
import com.sist.mgr.NewsVO;
/*
 * JDBC(���üҽ�) => ORM
 * 
 */

@Controller
@RequestMapping("movie/")
public class MovieController {
	
	@Autowired
	private MovieDAO dao;
	
	@Autowired
	private NewsManager mgr;
	//new ���� �ʰ� spring ���� �Ҵ������� �Ҹ���� ������ٰ���
	
	@RequestMapping("list.do") //list�� ������ ���� model�� �ʿ��ϴ�
	public String movie_list(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//����  page�� ���� string page�� page������ �����ֱ⵵
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum�� 1������ ����
		
		//���α׷��� ���۹�ȣ
		//�迭,����Ŭ 1
		//�ڹ� 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 1);
		
		//dao���� ������ �ޱ�
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(1);
		
		//jsp�� ������!
		//main���
		model.addAttribute("list", list);
		
		//list���� ���
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "���� �� ��ȭ");
		
		return "main/main";
		
	}
	
	
	@RequestMapping("shc.do") //list�� ������ ���� model�� �ʿ��ϴ�
	public String movie_shc(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//����  page�� ���� string page�� page������ �����ֱ⵵
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum�� 1������ ����
		
		//���α׷��� ���۹�ȣ
		//�迭,����Ŭ 1
		//�ڹ� 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 2);
		
		//dao���� ������ �ޱ�
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(2);
		
		//jsp�� ������!
		//main���
		model.addAttribute("list", list);
		
		//list���� ���
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "���� ���� ��ȭ");
		
		return "main/main";
		
	}
	
	
	@RequestMapping("box.do") //list�� ������ ���� model�� �ʿ��ϴ�
	public String movie_box(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//����  page�� ���� string page�� page������ �����ֱ⵵
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum�� 1������ ����
		
		//���α׷��� ���۹�ȣ
		//�迭,����Ŭ 1
		//�ڹ� 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 5);
		
		//dao���� ������ �ޱ�
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(5);
		
		//jsp�� ������!
		//main���
		model.addAttribute("list", list);
		
		//list���� ���
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "�ڽ����ǽ�");
		
		return "main/main";
		
	}
	
	
	
	@RequestMapping("news.do")
	public String movie_news(Model model)//�����͸� �о ���
	{			
		List<NewsVO> list=mgr.newsAllData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp","../movie/news.jsp");

		return "main/main";
	}
	
	
	@RequestMapping("detail.do")
	public String movie_detail(Model model, int mno)
	{
		//���� ���ϴ� ��ġ���� �ڵ����� ȣ��ǵ��� !
		//advice => advisor => aspect(�������Լ����� ����!)
		//1.point cut
		//2.join point-after-throwing(for rollback), after(commit(true)), before(commit(false)) ,after-returning(commit)
		//�޼ҵ����� @transaction�� �ø��� => �ڵ� Ʈ��������α׷��� ��!	
		//AOP => callback �Լ�! �ڵ�ȣ�� �Լ�! ex)ajax!, DS�ȿ� SERVICE()
		
		//����
		MovieVO vo=dao.movieDetailData(mno); 
		
		model.addAttribute("main_jsp", "../movie/detail.jsp"); // ../ =>  movie��  ���ͼ�  �����!
		model.addAttribute("vo", vo);
		
		return "main/main";
	}	
	
	
	
	
	
}


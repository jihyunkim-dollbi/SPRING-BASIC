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
 * JDBC(원시소스) => ORM
 * 
 */

@Controller
@RequestMapping("movie/")
public class MovieController {
	
	@Autowired
	private MovieDAO dao;
	
	@Autowired
	private NewsManager mgr;
	//new 하지 않고 spring 으로 할당했으니 소멸까지 담당해줄것임
	
	@RequestMapping("list.do") //list를 보내기 위해 model이 필요하다
	public String movie_list(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//여기  page가 위에 string page로 page정보를 보내주기도
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum은 1번부터 시작
		
		//프로그램의 시작번호
		//배열,오라클 1
		//자바 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 1);
		
		//dao에서 데이터 받기
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(1);
		
		//jsp로 보내기!
		//main사용
		model.addAttribute("list", list);
		
		//list에서 사용
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "현재 상영 영화");
		
		return "main/main";
		
	}
	
	
	@RequestMapping("shc.do") //list를 보내기 위해 model이 필요하다
	public String movie_shc(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//여기  page가 위에 string page로 page정보를 보내주기도
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum은 1번부터 시작
		
		//프로그램의 시작번호
		//배열,오라클 1
		//자바 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 2);
		
		//dao에서 데이터 받기
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(2);
		
		//jsp로 보내기!
		//main사용
		model.addAttribute("list", list);
		
		//list에서 사용
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "개봉 예정 영화");
		
		return "main/main";
		
	}
	
	
	@RequestMapping("box.do") //list를 보내기 위해 model이 필요하다
	public String movie_box(Model model, String page)
	{
		if(page == null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		//여기  page가 위에 string page로 page정보를 보내주기도
		
		Map map=new HashMap();
		
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		//rownum은 1번부터 시작
		
		//프로그램의 시작번호
		//배열,오라클 1
		//자바 0
		
		map.put("start", start);
		map.put("end", end);
		map.put("type", 5);
		
		//dao에서 데이터 받기
		List<MovieVO> list=dao.movieListData(map);
		
		//from other mapper
		int totalpage=dao.movieTotalPage(5);
		
		//jsp로 보내기!
		//main사용
		model.addAttribute("list", list);
		
		//list에서 사용
		model.addAttribute("main_jsp", "../movie/list.jsp");
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("title", "박스오피스");
		
		return "main/main";
		
	}
	
	
	
	@RequestMapping("news.do")
	public String movie_news(Model model)//데이터만 읽어서 출력
	{			
		List<NewsVO> list=mgr.newsAllData();
		model.addAttribute("list", list);
		model.addAttribute("main_jsp","../movie/news.jsp");

		return "main/main";
	}
	
	
	@RequestMapping("detail.do")
	public String movie_detail(Model model, int mno)
	{
		//내가 원하는 위치에서 자동으로 호출되도록 !
		//advice => advisor => aspect(공통사용함수들의 집합!)
		//1.point cut
		//2.join point-after-throwing(for rollback), after(commit(true)), before(commit(false)) ,after-returning(commit)
		//메소드위에 @transaction을 올리면 => 자동 트랜잭션프로그래밍 됨!	
		//AOP => callback 함수! 자동호출 함수! ex)ajax!, DS안에 SERVICE()
		
		//연결
		MovieVO vo=dao.movieDetailData(mno); 
		
		model.addAttribute("main_jsp", "../movie/detail.jsp"); // ../ =>  movie를  나와서  샐행됨!
		model.addAttribute("vo", vo);
		
		return "main/main";
	}	
	
	
	
	
	
}


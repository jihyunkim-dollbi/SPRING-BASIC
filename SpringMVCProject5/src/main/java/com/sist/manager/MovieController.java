package com.sist.manager;

import java.util.List;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;

@Controller
public class MovieController {
	
	@Autowired
	private MovieDAO dao;
	
	@RequestMapping("movie/list.do")
	public String movie_list(Model model, String page)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<MovieVO> list=dao.movieListData(curpage);
		int totalpage=dao.movieTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "movie/list";
	}
	
	
	@PostMapping("movie/find.do")
	public String movie_find(Model model, String fd) //model 보낼값이 있을때,
	{
		//dao연결 for mapping fd
		List<MovieVO> list=dao.movieFindData(fd);
		model.addAttribute("list", list);
		
		return "movie/find";
	}
		
	//form tag를 제외하고 는 모두 get mapping . ajax는 명시한 방식으로	
	@GetMapping("movie/detail.do")
	public String movie_detail(Model model, int mno)
	{
		//detail.do?mno= =>int mno를 매개변수로
		//DAO연결!
		//결과값 => model(request)
		MovieVO vo=dao.movieDetailData(mno);
		model.addAttribute("vo", vo);
		
		return "movie/detail"; //model을 사용한다는 것은 보낼 값이 있다는 것이고 ==> forward!
 	}


	
}

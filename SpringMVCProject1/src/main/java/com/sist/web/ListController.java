package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * default로 생성된 패키지에 controller클래스! 
 * 
 */
@Controller
public class ListController {

	@RequestMapping("main/list.do")
	public String main_list(HttpServletRequest request)
	{
		request.setAttribute("msg", "Hello Spring");
		return "list";
	}
	
	
	//값을 보내는 방법!
	/*Model을 이용해 전송하면 setAttribute 포함됨.
	 * public class Model
	 * {
	 * 	public void addAttribute(String key, Objet obj)
	 * 	{
	 * 		request.setAttribute(key, obj)
	 * 	}
	 * }
	 */
	@RequestMapping("main/list2.do")
	public String main_list2(Model model,ModelAndView modelandview)
	{
		//model은 jsp에  데이터를 전송할때! => 전송할 값이 없으면 사용x, 받을 값이 있다면 vo혹은 list를 매개변수로..
		//그 외에 값은 매개변수로 ..(db에서 가져온 값을 갖고있진 않다.)
		//request.getParameter 하지 않고 
		model.addAttribute("msg","Hello Spring~~");
		//model
		
		//doesn't work
		modelandview.setViewName("/main/list2");;
		modelandview.addObject("data","12341234");
		
		return "list2";
			    //view
	}
	
	
	//출처: https://hongku.tistory.com/116
	@RequestMapping("main/list3.do") 
	public Object main_list3(ModelAndView mv) { 
		
		// 데이터와 뷰를 동시에 설정이 가능  
		mv.setViewName("main/list2"); 
		
		// 뷰의 이름 
		mv.addObject("data", "12341234"); 
		
		// 뷰로 보낼 데이터 값 
		return mv; 
		
		}
	
	

	@GetMapping("main/input.do")
	public String main_input()
	{
		//form 띄울때 => 매개변수가 없어도 ok
		
		return "input";
	}
	
	//받는 방식1 from input.do
	@PostMapping("main/output.do")
	public String main_output(HttpServletRequest request)
	{
		try{//request사용시 인코딩 필요!	
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("addr");
		String tel=request.getParameter("tel");
		String content=request.getParameter("content");
		
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		//vo.setAddr(addr);
		vo.setContent(content);
		vo.setTel(tel);
		
		request.setAttribute("vo", vo);
		return "output";
	}
	
	
	
	//받는 방식2 from input.do
	@PostMapping("main/output2.do")// 모든 내용은 매개변수를 통해서 값을 주고 받을 수있다. 
	public String main_output2(Model model, MemberVO vo)
	{
		//input 의 name의 값과 vo의 변수명이 일치해야한다.
		//스프링이 위의 output.do의 코딩을 해준다.
		
		//?name=홍길동
		//setName<=홍길동 -> 자동으로 setMethod에 넣어준다.-> setName(name)이라는 메소드를 찾아서 invoke(적용)를 해준다.		
		
		//값을 보낼때의 변수명과 매개변수명이 일치해야한다.
		//list.do?p=2
		//		  ==
		//board_list(Model model, int p)
		//							  ==		
		//find.do?title=영화
		//movie_find(Model model, String title)

		model.addAttribute("vo", vo);
		
		return "output";
	}

	
	
}

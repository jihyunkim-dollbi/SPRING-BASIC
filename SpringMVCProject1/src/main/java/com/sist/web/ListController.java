package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * default�� ������ ��Ű���� controllerŬ����! 
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
	
	
	//���� ������ ���!
	/*Model�� �̿��� �����ϸ� setAttribute ���Ե�.
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
		//model�� jsp��  �����͸� �����Ҷ�! => ������ ���� ������ ���x, ���� ���� �ִٸ� voȤ�� list�� �Ű�������..
		//�� �ܿ� ���� �Ű������� ..(db���� ������ ���� �������� �ʴ�.)
		//request.getParameter ���� �ʰ� 
		model.addAttribute("msg","Hello Spring~~");
		//model
		
		//doesn't work
		modelandview.setViewName("/main/list2");;
		modelandview.addObject("data","12341234");
		
		return "list2";
			    //view
	}
	
	
	//��ó: https://hongku.tistory.com/116
	@RequestMapping("main/list3.do") 
	public Object main_list3(ModelAndView mv) { 
		
		// �����Ϳ� �並 ���ÿ� ������ ����  
		mv.setViewName("main/list2"); 
		
		// ���� �̸� 
		mv.addObject("data", "12341234"); 
		
		// ��� ���� ������ �� 
		return mv; 
		
		}
	
	

	@GetMapping("main/input.do")
	public String main_input()
	{
		//form ��ﶧ => �Ű������� ��� ok
		
		return "input";
	}
	
	//�޴� ���1 from input.do
	@PostMapping("main/output.do")
	public String main_output(HttpServletRequest request)
	{
		try{//request���� ���ڵ� �ʿ�!	
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
	
	
	
	//�޴� ���2 from input.do
	@PostMapping("main/output2.do")// ��� ������ �Ű������� ���ؼ� ���� �ְ� ���� ���ִ�. 
	public String main_output2(Model model, MemberVO vo)
	{
		//input �� name�� ���� vo�� �������� ��ġ�ؾ��Ѵ�.
		//�������� ���� output.do�� �ڵ��� ���ش�.
		
		//?name=ȫ�浿
		//setName<=ȫ�浿 -> �ڵ����� setMethod�� �־��ش�.-> setName(name)�̶�� �޼ҵ带 ã�Ƽ� invoke(����)�� ���ش�.		
		
		//���� �������� ������� �Ű��������� ��ġ�ؾ��Ѵ�.
		//list.do?p=2
		//		  ==
		//board_list(Model model, int p)
		//							  ==		
		//find.do?title=��ȭ
		//movie_find(Model model, String title)

		model.addAttribute("vo", vo);
		
		return "output";
	}

	
	
}

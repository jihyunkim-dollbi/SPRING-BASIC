package com.sist.web;
//ajax - sugguest 검색창!

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//화면이동 위한 컨트롤러!
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.dao.MusicDAO;
import com.sist.dao.MusicVO;
@Controller
public class MainController { //spring 커맨트 객체 제공 => 데이터형 자동 변환 (no parse), vo에 값을 알아서 채워주고 읽어줌!
	
	@Autowired
	private MusicDAO dao;
	
	//실제로 화면을 뛰우기위함 not for data 'json'
	@RequestMapping("main/list.do")
	public String main_list()
	{
		return "main/list";
	}
	
	@RequestMapping("main/detail.do")
	public String main_detail(int mno,Model model)
	{
		//자바에서 react로 값을 보낼수있음!
		MusicVO vo=dao.musicDetailData(mno); //vo문자열을 보내려함
		JSONObject obj=new JSONObject();
		obj.put("mno", vo.getMno());
		obj.put("title", vo.getTitle());
		obj.put("singer", vo.getSinger());
		obj.put("album",vo.getAlbum());
		obj.put("state", vo.getState());
		obj.put("poster", vo.getPoster());
		obj.put("idcliment", vo.getIdcliment());
		obj.put("key", vo.getKey());
		
		
		model.addAttribute("json", obj.toJSONString());
		model.addAttribute("mno", mno);
		//상세이동으로 화면이동만
		//데이터 db연동은 restController에서. // detail.do에서 mno를 detail로 보내고 detail에서 받은 mno를 restController로 보내서 db연동!!

		return "main/detail";
	}
	
	
	@GetMapping("main/login.do")
	public String main_login()
	{
		//창만 띄우기
		return "main/login";
	}
	
	/* DS의 내장객체 => 모두 매개변수로 받아서 처리하기!
	 * request, response, session, pageContext, page, excepttion,config, out ==> DispatcherServlet이 가지고 있다.
	 * DS안에 존재하는 내장 객체를 받아서 데이터를 전달받아야한다. 
	 * 
	 * 	DS안에 invoke()함수가 있어서 가능!
	 *  invoke(Object.. obj) ==> 가변형 데이터형 => 원하는 데이터형을 개수만큼 찾아서 값을 넣어줌. 가변매개변수! 
	 *  ex) Systme.out.println()
		forward!! jsp파일을 화면에 채워라!!  => 같은 바탕위에 새로운 화면으로 채운다=> .jsp를 리턴함! => request를 매개변수로 받음! => 따라서 같은 request값을 유지할수있음.
		redirect는 다른화면으로! =>새로운 서비스를 호출 => .do를 호출하므로 => 새로운 reuqest값을 갖게됨. request값이 달라진다.
		
		//쿠기는 저장하지 않기 때문에 response로 받아야 => 쿠키는 내장객체가 아니다 cookie cook= new cookie() => reponse.addcookie(cook)
		//다운로드 또한 => response필요!
		
	 */
	//세션처리하기!
	@PostMapping("main/login_ok.do")
	public String main_login_ok(String id, String pwd, Model model, HttpSession session) //세션을 controller로 맴개변수로 받음!by DS!
	{
		String result="";
		int count=dao.idCount(id);
		if(count==0)
		{	
			//id가 없는 경우
			result="NOID";
			
		}else{ 
			
			//비번체크하기
			String db_pwd=dao.memberGetPassword(id);
			if(db_pwd.equals(pwd))
			{
				//비번이 일치하는 경우
				result="OK";
				session.setAttribute("id", id);
				
			}else
			{	//비번틀림
				result="NOPWD";
				
			}
			
			model.addAttribute("result", result);
			//위 3개중의 한 값에 해당하는 것을 모두 처리해주러 GOGO => IN LOGIN_OK.JSP에서
			
			
		}
		return "main/login_ok"; 
	}
	
	@RequestMapping("main/logout.do")
	public String logout(HttpSession session)
	{
		session.invalidate(); // 세션해재시킴!
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

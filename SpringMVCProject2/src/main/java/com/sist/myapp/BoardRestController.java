package com.sist.myapp;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//일반 컨트롤러는 파일명이 넘어가지면
//restcontroller는 파일명이 넘어가지 않고 script파일이나 json이 넘어간다
//ex) 비빌번호 비교후 데이터 처리할때..
//스크립트를 넘기다.. => 일반문자열이 넘어간다.
//ajax, react 사용시 => 필요한 데이터(xml, json)
// 결과로 스크립트 사용해야할때 사용!
@RestController 
public class BoardRestController {
	
	//prototype =>일때 매번 다른 dao생성됨!
	@Autowired
	private BoardDAO dao;//모든 컨트롤러에서 메모리 할당시 하나의 싱글톤 dao
	
	
	//비번 비교!
	@PostMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo) //vo가 들어와야 업데이트된다.
	{
		String result="";
		
		//db에서 true, false를 받아옴
		boolean bCheck=dao.boardUpdate(vo); //dao연동 => true or false의 값을 갖는다!
		
		if(bCheck == true)
		{	
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";	
		}
		else
		{
			//필요한 html, script를 보낼때 RESTCONTROLLER를 사용!
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		
		return result;
	}
	
	
	@PostMapping("board/delete_ok.do")
	public String board_delete_ok(int no, String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);

		if(bCheck == true)
		{	
			result="<script>location.href=\"list.do\"</script>";	
		}
		else
		{
			//필요한 html, script를 보낼때 RESTCONTROLLER를 사용!
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
}

package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//json 처리,값만 이동,리턴값으로 값 넘김 화면이동 x=> model 필요x
// {} => 1row => made by array
// [{mno:..,..},{},{},{},..] => 배열로 묶어서 보내기 => made by jsonObject 
import java.util.*;
import com.sist.dao.*;
@RestController
public class MusicController {

	@Autowired
	private MusicDAO dao;
	
	@RequestMapping("main/music.do")
	public String main_music()
	{
		String result="";
		List<MusicVO> list=dao.musicListData();
		JSONArray arr=new JSONArray();
		for(MusicVO vo:list)
		{
			//배열로 잡아준다 => 1row를 하나로 묶어준댜 =>obj에 넣는다,
			JSONObject obj=new JSONObject();
			obj.put("mno", vo.getMno());
			obj.put("title", vo.getTitle());
			obj.put("singer", vo.getSinger());
			obj.put("album", vo.getAlbum());
			obj.put("state", vo.getState());
			obj.put("poster", vo.getPoster());
			obj.put("idcliment", vo.getIdcliment());
			//하나의 1row를 모아서
			arr.add(obj); //[]안에 모두 넣기!

		}
		result=arr.toJSONString();
		System.out.println(result);
		return result; //출력하러 고고!
		
	}
	
	
	
}

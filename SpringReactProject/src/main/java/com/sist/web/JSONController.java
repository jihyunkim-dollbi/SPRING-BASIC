package com.sist.web;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.CategoryVO;
import com.sist.dao.FoodService;
//json을 넘긴다 => to REACT

// has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. 검사
//@CrossOrigin(origins="http://localhost:3000,http://localhost:3355") //이 port가 들어와서 이 서비스를 사용할수있게.
//node cross domain! => 다중서버 이용시!
//예) 채팅
//서버 http-스프링 , ws - 리액트


//List => React,vue => [] {} => json!
//var a={} 객체
@RestController
@CrossOrigin(origins="http://localhost:3000") //이 port가 들어와서 이 서비스를 사용할수있게.
public class JSONController {

	@Autowired
	private FoodService service;
	
	@RequestMapping("category.do")
	public String category()
	{
		//detail => object
		//list => array 에 넣기
		List<CategoryVO> list=service.categoryListData();
		JSONArray arr=new JSONArray(); // [{title: "", subject:""},{},{},...]
		//필요한건 {}
		for(CategoryVO vo:list) //{}를 만들자!
		{
			JSONObject obj=new JSONObject();
			obj.put("title", vo.getTitle());
			obj.put("subject", vo.getSubject());
			arr.add(obj); //json생성
		}
		
		return arr.toJSONString();
		
	}    
	
}

package com.sist.news;
import java.util.*;
import java.io.*;
import com.sist.xml.*;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//다음주 aop => transaction => trigger!(댓글! and 영화나 맛집의 hit수 자동기능 설정!, 방문한 곳 저장 cookie에 , 세션.)
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class NewsController {

	@Autowired //==>xml 에서 세팅하지 않는 경우는 new로 사용해도 ok!
	private NewsManager nm;
	//private NewsManager nm = new NewsManager();
	
	@RequestMapping("main/newsList.do")
	public String main_news(Model model, String fd)
	{
		if(fd==null)
			fd="코로나";//디폴트검색어
		
		List<Item> list=nm.newsAllData(fd); //값을 받아옴
		
		try{
			
			String temp="";
			for(Item i:list)
			{
				temp+=i.getDescription()+"\r\n"; //메모장은 \r을 해야 \n을 읽는다.
			}
			FileWriter fw=new FileWriter("c:\\data\\naver.txt");
			fw.write(temp);
			fw.close();
			model.addAttribute("list",list);
			rGraph();
			
		}catch(Exception ex){}
		
		return "main/news";
	}
	
	
	public void rGraph()
	{
		try{
			
		
		RConnection rc=new RConnection();
		rc.voidEval("library(rJava)");
		rc.voidEval("library(KoNLP)");
		rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject6/main/news.png\",width=700,height=450)\")");
		rc.voidEval("data<-readLines(\"c:/data/naver.txt\")");
		rc.voidEval("data2<-sapply(data,extractNoun,USE.NAMES = F)");
		rc.voidEval("data3<-unlist(data2)");
		rc.voidEval("data3<-gsub(\"[ A-Za-z]\"),\"\",data3)");
		rc.voidEval("data3<-gsub(\"[0-9]\",\"\",data3)");
		rc.voidEval("data4<-table(data3)");
		rc.voidEval("data5<-head(sort(data4,decreasing = T), 100)");
		rc.voidEval("C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject6/main/news/");
		rc.voidEval("dev.off");
		rc.close();
		
		}catch(Exception ex) {}
		
	}
	
}

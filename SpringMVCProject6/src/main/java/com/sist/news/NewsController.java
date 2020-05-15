package com.sist.news;
import java.util.*;
import java.io.*;
import com.sist.xml.*;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//������ aop => transaction => trigger!(���! and ��ȭ�� ������ hit�� �ڵ���� ����!, �湮�� �� ���� cookie�� , ����.)
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class NewsController {

	@Autowired //==>xml ���� �������� �ʴ� ���� new�� ����ص� ok!
	private NewsManager nm;
	//private NewsManager nm = new NewsManager();
	
	@RequestMapping("main/newsList.do")
	public String main_news(Model model, String fd)
	{
		if(fd==null)
			fd="�ڷγ�";//����Ʈ�˻���
		
		List<Item> list=nm.newsAllData(fd); //���� �޾ƿ�
		
		try{
			
			String temp="";
			for(Item i:list)
			{
				temp+=i.getDescription()+"\r\n"; //�޸����� \r�� �ؾ� \n�� �д´�.
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

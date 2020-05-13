package com.sist.mgr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.*;
import java.io.*;
import java.net.*;

//json jsoup

@Component
public class MovieManager {

	//json 파싱
	/*
	 * json 파일!
	 * {} object
	 * [{키:값},{키:값},{키:값}...]
	 */
	
	
	public static void main(String[] args) {
		
		MovieManager m=new MovieManager();
		
		System.out.println(m.movieGetJson("searchMainDailyBoxOffice.do"));
	}
	
	
	
	
	public String movieGetJson(String url)
	{
		String json="";
		
		try
		{
			URL strURL= new URL("http://www.kobis.or.kr/kobis/business/main/"+url);
			HttpURLConnection conn=(HttpURLConnection)strURL.openConnection();
			StringBuffer sb=new StringBuffer();
			if(conn!=null)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				
				while(true)
				{
					String temp=br.readLine();	
					if(temp==null)
						break;
					sb.append(temp);
				}
			}
			json=sb.toString();
			
			//Document doc=Jsoup.connect("http://www.kobis.or.kr/kobis/business/main/"+url).get();
			//json=doc.toString();
			//System.out.println(json);
		}catch(Exception ex) {}
		
		return json;
		
	}
	
}

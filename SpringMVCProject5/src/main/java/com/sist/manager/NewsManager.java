package com.sist.manager;

import java.util.*;
import java.text.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sist.dao.MovieDAO;
//실시간으로 뉴스를 읽으려 메모리할당
//일반테이블 1개 repository, 2개 3개 이상의 기능 여러개를 통하발때는 service! 비즈니스 로직 통합!
@Component 
public class NewsManager {

	  
    public List<NewsVO> newsAllData()
    {
    	List<NewsVO> list=new ArrayList<NewsVO>();
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	String today=sdf.format(date);
    	MovieDAO dao=new MovieDAO(); 
    	try
    	{
    		//페이지 안에 모든 html 코드 저장!

    		/*// 뉴스
    	     * <ul class="list_line #list">

    								<li>
    					<a href="http://v.movie.daum.net/v/20200218165207877" class="thumb_line bg_noimage2 @1">
    																					<span class="thumb_img" style="background-image:url(//img1.daumcdn.net/thumb/S320x200/?fname=https://t1.daumcdn.net/news/202002/18/starnews/20200218165207830ydsf.jpg);"></span>
    					</a>
    					<span class="cont_line">
    						<strong class="tit_line"><a href="http://v.movie.daum.net/v/20200218165207877" class="link_txt @1">유아인·공효진, 코로나19로 버버리 패션쇼 입장 금지? "사실무근" </a></strong>
    						<a href="http://v.movie.daum.net/v/20200218165207877" class="desc_line @1">
    							[스타뉴스 김미화 기자]유아인, 공효진 / 사진=스타뉴스 배우 유아인 공효진 등이 코로나19 여파로 영국 버버리 패션쇼 참석을 거부당했다는 보도가 나온 가운데 양쪽 배우 모두 "사실이 아니다"라는 입장을 밝혔다. 18일 한 매체는 배우 유아인 공효진이 17일 영국 런던에서 열린 버버리 컬렉션 쇼에 참석할 예정이었으나, 코로나19 안전 대책이 마련되지 않아
    						</a>
    						<span class="state_line">
    							스타뉴스<span class="txt_dot">・</span><span class="screen_out">발행일자</span>20.02.18
    						</span>
    					</span>
    				</li>
    	     * 
    	     */
    		
    		
    		// 
    		//url을 확인하여 변수에 대해서 for문에서 바꿔줘야하는 것 무엇인지 확인하기!!
    		/*for(int i=1; i<=18; i++) // 18페이지!
    		{*/
    			
    		Document doc=Jsoup.connect("https://movie.daum.net/magazine/new?tab=nws&regdate="+today+"&page=1").get();
    		Elements title=doc.select("ul.list_line strong.tit_line a"); //타이들이 들어간 태그들 모두 모음
    		Elements poster=doc.select("ul.list_line a.thumb_line span.thumb_img");
    		Elements link=doc.select("ul.list_line strong.tit_line a");
    	
    		Elements temp=doc.select("span.cont_line span.state_line");
    		Elements content=doc.select("span.cont_line a.desc_line");
    		int k=1;
    		for(int j=0; j<title.size();j++)
    		{
    			
    		System.out.println(title.get(j).text());
    		String ss=poster.get(j).attr("style");
    		ss=ss.substring(ss.indexOf("(")+1,ss.lastIndexOf(")")); //background () =>사이에 값 가져오기!! 
    		System.out.println(ss);
    		
    		System.out.println(poster.get(j).attr("style"));
    		System.out.println(link.get(j).attr("href"));
    		String str=temp.get(j).text();
    		
    		System.out.println(temp.get(j).text());
    		System.out.println(content.get(j).text());
    		
    		System.out.println("========================================================");
    		
    		NewsVO vo=new NewsVO();
    		vo.setTitle(title.get(j).text());
    		vo.setLink(link.get(j).attr("href"));
    		vo.setContent(content.get(j).text());
    		vo.setPoster(ss);
    		vo.setAuthor(str); //날짜 등등 같이 읽음
    		//list.add(vo);
    		dao.newsInsert(vo);
    		k++;
    		
    		}	
    	 //}
    		System.out.println("Save End...!");
    		
    	}
    	catch(Exception ex)
    	{
    		
    		System.out.println(ex.getMessage());
    	}
    	return list;
    }
    
    public static void main(String[] args) {
		NewsManager news=new NewsManager();
		news.newsAllData();
	}
	
	
}

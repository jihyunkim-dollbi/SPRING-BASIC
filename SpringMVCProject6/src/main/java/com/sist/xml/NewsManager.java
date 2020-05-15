package com.sist.xml;
//네이버 뉴스를 xml로 파싱하기
//newssearch.naver.com/search.naver?where=rss&query=영화
//그롬에 입력하면 xml 파일이 나옴.
//		com까지 서버주소	  / rss가 xml파일, query 검색어
/*<rss xmlns:media="http://search.yahoo.com/mrss/" xmlns:dc="http://purl.org/dc/elements/1.1/" version="2.0">
<channel>
<title>네이버 뉴스검색 :: '영화'</title>
<link>
https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94&sm=tab_pge&sort=0&photo=0=&field=0&pd=0&ds=&de=&refresh=-1&docid=
</link>
<description>네이버 뉴스검색 '영화'에 대한 검색결과입니다.</description>
<language>ko</language>
<lastBuildDate>Fri, 15 May 2020 12:19:43 +0900</lastBuildDate>
<ttl>5</ttl>
<image>
<title>네이버 뉴스검색 :: '영화'</title>
<link>
https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94&sm=tab_pge&sort=0&photo=0=&field=0&pd=0&ds=&de=&refresh=-1&docid=
</link>
<url>
http://imgnews.naver.net/image/news/naverme/news_40x40.jpg
</url>
</image>
 * 
 * rss밑에 channel => rss는 클래스가 되고, channel도 클래스 items를 갖고있기때문에.. items도 클래스 
 * items는 7개의 변수가 있다 tag and tag사이에 tag가 있으면 클래스 , 값이 있으면 변수
 * xml binding => jaxb
 * jaxp => 
 * jaxb => 클래스와 xml-tag를 연결
 * 
 * rss => xe 데이터베이스
 * chaneel => table
 * item, title link, => 컬럼
 * item => 한개의 vo가된다.
 * items안에 title, link=> 변수

 */
// http://newssearch.naver.com/search.naver?where=rss&query=%EC%98%81%ED%99%94 ==> 인코딩되었기때문에  디코딩처리 필요? .net에서 처리
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import java.net.*;
@Component  //일반 클래스의 경우!
public class NewsManager {

	public List<Item> newsAllData(String fd)
	{
		List<Item> list=new ArrayList<Item>();
		try
		{
			//연결
			JAXBContext jc=JAXBContext.newInstance(Rss.class); //객체생성=> 누가받을까? Rss => rootElement! => 가장 최상위 태그
			//자바로 변환해줘
			Unmarshaller un=jc.createUnmarshaller(); //xml을 java로 변환
			URL url=new URL("http://newssearch.naver.com/search.naver?where=rss&query="
					+URLEncoder.encode(fd,"UTF-8")); //인코딩하기
			//rss에 값을 채우기
			Rss rss=(Rss)un.unmarshal(url); //리턴형이 object이기때문에 rss로 형변환
			list=rss.getChannel().getItem(); //chennal에서 item을 리스트로 갖고있기때문에 따로 add할 필요x
			
		}catch(Exception ex){}
		
		return list;
	}
}

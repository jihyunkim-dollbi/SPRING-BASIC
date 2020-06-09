package com.sist.manager;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;
/*
 * 	<td class="title">
		<div class="tit5">
		<a href="/movie/bi/mi/basic.nhn?code=181710" title="포드 V 페라리">포드 V 페라리</a>
			</div>
	</td>
 * 
 */
public class MovieManager {
	
	public List<String> movieLinkData()
	{
		List<String> list=new ArrayList<String>();
		
		try{
			for(int i=1; i<=40; i++)
			{
				Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page="+i).get(); //1~40페이지!
				Elements link=doc.select("td.title div.tit5 a"); 
				
				for(int j=0;j<link.size();j++)
				{
					
					String strLink=link.get(j).attr("href");
					list.add("https://movie.naver.com"+strLink);
				}
	
			}
		}catch(Exception ex) {}
		
		return list;
	}
	/*
	 * private int mno, like;
	private String title, poster, genre, grade, director, actor, story; 
	 */
	
	//값을 가져오는 곳 몽고디비에 insert로 넣을 예정
	public void movieAllData(){
		
		try{
			
			//dao에서 mongodb connection and inserting!
			MovieDAO dao=new MovieDAO(); 
			List<String> list=movieLinkData(); //리스트에 값이 채워짐
			int k=1;
			for(String url:list) //한줄씩 처리
			{
				try{ // 19금은 찾지 못하기 때문에! 안에서 찾지 못해도 다시 for문으로고고.	
					
				Document doc=Jsoup.connect(url).get(); //url 한개씩 페이지 않에 데이터 읽기 시작
				//한개씩만 읽고 한개의 vo씩 몽고디비에 넣기
				/*
				 * <div class="mv_info">
		<h3 class="h_movie">
			
			<a href="./basic.nhn?code=171539">그린 북</a><!-- N=a:ifo.title -->
			
			<!-- 포스터 -->
	<div class="poster">
		
			
				<a href="#" onclick="javascript:common.iwopen('171539');clickcr(this,'ifo.img','','',event);return false;"><img src="https://movie-phinf.pstatic.net/20190115_228/1547528180168jgEP7_JPEG/movie_image.jpg?type=m77_110_2" alt="그린 북" onerror="this.src='https://ssl.pstatic.net/static/movie/2012/06/dft_img77x110_1.png'"/><span>포스터 크게보기</span></a>
			
			<p class="info_spec">
			
				<span>
				<a href="/movie/sdb/browsing/bmovie.nhn?genre=1">드라마</a>
				</span>
				/
				<span>
					[국내]<a href="/movie/sdb/browsing/bmovie.nhn?grade=1001002">12세 관람가</a>
				 * 
				 */
				
				Element title=doc.selectFirst("div.mv_info h3.h_movie a"); //한개만 가져옴. 리턴형이 element tag한개만 가져옴
				Element poster=doc.selectFirst("div.poster a img");
				Element genre=doc.selectFirst("dl.info_spec span a");
				Element grade=doc.selectFirst("dl.info_spec dd");
				Element director=doc.selectFirst("div.info_spec2 dl.step1 a");
				Element actor=doc.selectFirst("div.info_spec2 dl.step2 a");
				Element story=doc.selectFirst("div.video div.story_area p.con_tx");
				//값이 없음 Element like=doc.selectFirst("");
				//vo에 값 넣기
				MovieVO vo=new MovieVO();
				vo.setMno(Integer.parseInt(url.substring(url.lastIndexOf("=")+1))); // 181710 고유번호를 자름
				
				System.out.println("============영화정보============");
				System.out.println("k="+k);
				System.out.println("title: "+ title.text());
				System.out.println("poster: " +poster.attr("src"));
				System.out.println("genre: " + genre.text());
				System.out.println("grade: " + grade.text());
				System.out.println("director: " + director.text());
				System.out.println("actor: " + actor.text());
				System.out.println("stoty: "+ story.text());
				
				vo.setTitle(title.text());
				vo.setPoster(poster.attr("src"));
				vo.setGenre(genre.text());
				vo.setGrade(grade.text());
				vo.setDirector(director.text());
				vo.setActor(actor.text());
				vo.setStory(story.text());
				//go to dao for connecting and making table with mongodb
				dao.movieInsert(vo); //값 채우기
				k++;
				
				}catch(Exception ex) {}	
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		m.movieAllData();
	}
}
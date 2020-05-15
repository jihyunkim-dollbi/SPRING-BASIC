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
		<a href="/movie/bi/mi/basic.nhn?code=181710" title="���� V ���">���� V ���</a>
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
				Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page="+i).get(); //1~40������!
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
	
	//���� �������� �� ������ insert�� ���� ����
	public void movieAllData(){
		
		try{
			
			//dao���� mongodb connection and inserting!
			MovieDAO dao=new MovieDAO(); 
			List<String> list=movieLinkData(); //����Ʈ�� ���� ä����
			int k=1;
			for(String url:list) //���پ� ó��
			{
				try{ // 19���� ã�� ���ϱ� ������! �ȿ��� ã�� ���ص� �ٽ� for�����ΰ��.	
					
				Document doc=Jsoup.connect(url).get(); //url �Ѱ��� ������ �ʿ� ������ �б� ����
				//�Ѱ����� �а� �Ѱ��� vo�� ������ �ֱ�
				/*
				 * <div class="mv_info">
		<h3 class="h_movie">
			
			<a href="./basic.nhn?code=171539">�׸� ��</a><!-- N=a:ifo.title -->
			
			<!-- ������ -->
	<div class="poster">
		
			
				<a href="#" onclick="javascript:common.iwopen('171539');clickcr(this,'ifo.img','','',event);return false;"><img src="https://movie-phinf.pstatic.net/20190115_228/1547528180168jgEP7_JPEG/movie_image.jpg?type=m77_110_2" alt="�׸� ��" onerror="this.src='https://ssl.pstatic.net/static/movie/2012/06/dft_img77x110_1.png'"/><span>������ ũ�Ժ���</span></a>
			
			<p class="info_spec">
			
				<span>
				<a href="/movie/sdb/browsing/bmovie.nhn?genre=1">���</a>
				</span>
				/
				<span>
					[����]<a href="/movie/sdb/browsing/bmovie.nhn?grade=1001002">12�� ������</a>

				 * 
				 */
				
				Element title=doc.selectFirst("div.mv_info h3.h_movie a"); //�Ѱ��� ������. �������� element tag�Ѱ��� ������
				Element poster=doc.selectFirst("div.poster a img");
				Element genre=doc.selectFirst("dl.info_spec span a");
				Element grade=doc.selectFirst("dl.info_spec dd");
				Element director=doc.selectFirst("div.info_spec2 dl.step1 a");
				Element actor=doc.selectFirst("div.info_spec2 dl.step2 a");
				Element story=doc.selectFirst("div.video div.story_area p.con_tx");
				//���� ���� Element like=doc.selectFirst("");
				//vo�� �� �ֱ�
				MovieVO vo=new MovieVO();
				vo.setMno(Integer.parseInt(url.substring(url.lastIndexOf("=")+1))); // 181710 ������ȣ�� �ڸ�
				
				System.out.println("============��ȭ����============");
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
				dao.movieInsert(vo); //�� ä���
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

package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

//네이버 영화 크롤링
//https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page=1
//링크를 구해오고
//안으로 들어가서 수집하기
@Getter
@Setter
public class MovieVO {

	private int mno, like;
	private String title, poster, genre, grade, director, actor, story;
	
}

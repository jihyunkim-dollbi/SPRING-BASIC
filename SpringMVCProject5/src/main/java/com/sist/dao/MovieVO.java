package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

//���̹� ��ȭ ũ�Ѹ�
//https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200513&page=1
//��ũ�� ���ؿ���
//������ ���� �����ϱ�
@Getter
@Setter
public class MovieVO {

	private int mno, like;
	private String title, poster, genre, grade, director, actor, story;
	
}

package com.sist.dao;

import lombok.Getter;
import lombok.Setter;
//로그인 처리 Session 처리!

/* 
MNO       NOT NULL NUMBER        
RANK               NUMBER        
TITLE              VARCHAR2(500) 
SINGER             VARCHAR2(300) 
ALBUM              VARCHAR2(300) 
POSTER             VARCHAR2(300) 
IDCLIMENT          NUMBER        
STATE              CHAR(6)       
KEY                VARCHAR2(100) 
HIT                NUMBER  
 */
@Getter
@Setter
public class MusicVO {
	// trigger for hit
	// function is better than join in oracle
	// tomorrow
	private int mno, rank, idcliment, hit;
	private String title, singer, album,state, poster, key;
}

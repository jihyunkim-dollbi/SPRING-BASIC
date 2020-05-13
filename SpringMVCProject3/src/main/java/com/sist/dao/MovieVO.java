package com.sist.dao;
/*
 * MNO       NOT NULL NUMBER(4)      
TITLE     NOT NULL VARCHAR2(1000) 
POSTER    NOT NULL VARCHAR2(2000) 
SCORE              NUMBER(4,2)    
GENRE     NOT NULL VARCHAR2(200)  
REGDATE            VARCHAR2(200)  
TIME               VARCHAR2(50)   
GRADE              VARCHAR2(200)  
DIRECTOR           VARCHAR2(200)  
ACTOR              VARCHAR2(500)  
STORY              CLOB           
TYPE               NUMBER         
THEATERNO          VARCHAR2(200)  

 * 
 */

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieVO {

	
	private int mno, score, type;
	private String title, poster, genre, time, grade, director, actor, story;
	private String regdate;
	
}

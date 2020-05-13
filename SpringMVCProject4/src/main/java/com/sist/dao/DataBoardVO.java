package com.sist.dao;
/*
 * NO        NOT NULL NUMBER         
SUBJECT   NOT NULL VARCHAR2(1000) 
CONTENT   NOT NULL CLOB           
PWD       NOT NULL VARCHAR2(20)   
REGDATE            DATE           
HIT                NUMBER         
FILENAME           VARCHAR2(1000) 
FILESIZE           VARCHAR2(1000) 
FILECOUNT          NUMBER   


<input type="text" name="names[0]"/>
<input type="text" name="names[1]"/>
<input type="text" name="names[2]"/>
<input type="text" name="names[3]"/>
<input type="text" name="names[4]"/>
=> List<String> names;

배열형식으로 하고=> 리스트로 받을 수있다.

getparameter로 배열들을 받아서 => 리스트로 변환!
Arrays.asList(배열)
배열을 리스트에 넣을때!!
 */
import java.util.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataBoardVO {

	private int no, hit, filecount;
	private String subject, name, content, pwd, filename, filesize;
	private Date regdate;
	private List<MultipartFile> files;
}

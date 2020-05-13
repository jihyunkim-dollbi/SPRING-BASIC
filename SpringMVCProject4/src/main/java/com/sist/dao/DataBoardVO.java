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

�迭�������� �ϰ�=> ����Ʈ�� ���� ���ִ�.

getparameter�� �迭���� �޾Ƽ� => ����Ʈ�� ��ȯ!
Arrays.asList(�迭)
�迭�� ����Ʈ�� ������!!
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

package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface BoardMapper {

	@Select("SELECT no, subject, name, regdate, hit, num "		
			+"FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+"FROM (SELECT no, subject, name, regdate, hit "
			+"FROM board ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	//		리턴형		  메소드명			매개변수
	

	//총페이지구하기
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM board")
	public int boardTotalPage();
	
	
	//자동증가번호
	@SelectKey(statement="SELECT NVL(MAX(no)+1,1) as no FROM board",
				keyProperty="no", resultType=int.class , before=true)
	@Insert("INSERT INTO board VALUES("
		   +"#{no}, #{name}, #{subject}, #{content}, #{pwd}, SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	
	//상세보기
	//UPDATE
	@Update("UPDATE board SET "
			+"hit=hit+1"
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM board "
		   +"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	//수정하기- 비번 가져오기
	@Select("SELECT pwd FROM board "
			+"WHERE no=#{no}")
	public String boardGetPwd(int no);
	//수정하기 - 수정하기
	@Update("UPDATE board SET "
			+"name=#{name}, subject=#{subject}, content=#{content} "
			+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo); //4개의 매개변수가 들어간다.
	
	
	@Delete("Delete FROM board "
			+"WHERE no=#{no}")
	public void boardDelete(int no);
	
	
	
}

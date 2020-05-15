package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface DataBoardMapper {

	@Select("SELECT no, name, subject, regdate, hit, num "
			+"FROM (SELECT no, name, subject, regdate, hit, rownum as num "
			+"FROM (SELECT no, name, subject, regdate, hit "
			+"FROM spring_databoard ORDER BY no DESC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(Map map);
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_databoard")
	@Insert("INSERT INTO spring_databoard VALUES("
			+"#{no},#{name},#{subject},#{content},#{pwd},"
			+"SYSDATE,0,#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_databoard")
	public int databoardTotalPage();
	
	@Update("UPDATE spring_databoard SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, regdate, hit, filename, filesize, filecount "
			+"FROM spring_databoard "
			+"WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	

	//UPDATE_OK
	//PWD 가져오기
	@Select("SELECT pwd from spring_databoard "
			+"WHERE no=#{no}")
	public String databoardGetPassword(int no);
	
	//수정하기
	@Update("UPDATE spring_databoard set "
			+"name=#{name}, content=#{content}, subject=#{subject} "
			+"WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo); //#이 많을때 map or vo, 한개면 vo
	
	
	//이 게시물이 삭제 되기전에 게시물안에 파일들을 삭제할 것임!
	//파일이 없는 게시물의 경우 count가 0이 아니면 지울필요x , 0이상일때만 지울것!!
	@Select("SELECT filename, filecount FROM spring_databoard "
			+"WHERE no=#{no}")
	public DataBoardVO databoardFileInfoData(int no); 
	
	//비번체크는 재사용 예정!!
	@Delete("DELETE FROM spring_databoard "
			+"WHERE no=#{no}")
	public void databoardDelete(int no); // parameter type은 한개만 가능!!
	
	
}

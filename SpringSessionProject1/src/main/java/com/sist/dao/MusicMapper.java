package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface MusicMapper {
	
	//리스트 출력
	@Select("SELECT * FROM music_genie ORDER BY mno ASC")
	public List<MusicVO> musicListData();
	
	//상세보기
	@Select("SELECT * FROM music_genie "
			+"WHERE mno=#{mno}")
	public MusicVO musicDetailData(int mno);
	 
	//로그인처리
	@Select("SELECT COUNT(*) FROM member "
			+"WHERE id=#{id}")
	public String idCount(String id);
	
	//pwd체크
	@Select("SELECT pwd FROM member "
			+"WHERE id=#{id}")
	public String memberGetPassword(String id);
	
}

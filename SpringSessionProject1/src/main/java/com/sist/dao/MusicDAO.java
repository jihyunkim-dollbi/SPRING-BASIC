package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * Spring에서 메모리할당하는 객체 5
 * 
 * 1.@Component - 일반클래스(mainclass, ~manager =>외부에서 데이터 읽어올때)
 * 2.@Repository(저장송) - DAO(데이터가 연결된 곳)
 * 3.@Controller - Model ,파일명+( ~controller(spring), ~action(struts), ~model(사용자정의))  
 * 4.@RestController - Json, XML을 보낼때, AJAX, REACT 사용시 
 * 5.@Service  - DAO를 여러개 연결하여 사용하는 부분!=> DI(Integration)

 * Spring DI
 * 1.@Autowired 자동주입!
 * 2.@Resource id 지정하여 값을 가져옴
 * 3.@Inject
 * 4.@Import
 * 
 */
@Repository
public class MusicDAO {

	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData()
	{
		return mapper.musicListData();	
	}
	
	public MusicVO musicDetailData(int mno)
	{
		return mapper.musicDetailData(mno);
	}
	
	public int idCount(String id)
	{
		return mapper.idCount(id);
	}
	
	public String memberGetPassword(String id)
	{
		return mapper.memberGetPassword(id);
	}
	
	
}

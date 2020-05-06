package com.sist.spring2;

import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface EmpMapper {

	@Select("SELECT * FROM emp")
	public List<EmpVO> empAllData();
	// 		리턴형		매개변수! => parameter 없음!
	
	
}

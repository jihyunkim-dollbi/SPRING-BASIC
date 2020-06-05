package com.sist.dao;

import java.util.List;
//ctrl shift o =>사용 lib만 !
import org.apache.ibatis.annotations.Select;
public interface CategoryMapper {
	
	@Select("SELECT * FROM category")
	public List<CategoryVO> categoryListData();
	
}

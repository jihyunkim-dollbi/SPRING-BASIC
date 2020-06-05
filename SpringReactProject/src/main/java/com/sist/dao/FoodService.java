package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
//서비스를 사용하는 이유는 dao유지보수에서도 이전의 service는 유지되기때문에..보완과 유지보수에 좋다.
@Service
public class FoodService {
	
	@Autowired
	private CategoryDAO cdao;
	
	@Autowired
	private FoodDAO fdao;
	
	public List<CategoryVO> categoryListData()
	{
		return cdao.categoryListData();
	}
	
	
}

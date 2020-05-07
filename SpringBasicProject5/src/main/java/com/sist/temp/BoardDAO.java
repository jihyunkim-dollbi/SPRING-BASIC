package com.sist.temp;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements MyDAO{

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
		System.out.println("select() from boardDAO");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert() from boardDAO");
	}

 
	
}

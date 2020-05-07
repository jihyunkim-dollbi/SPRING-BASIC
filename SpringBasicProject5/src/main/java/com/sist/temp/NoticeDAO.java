package com.sist.temp;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements MyDAO {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("select() from notice");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert() from notice");
	}

}

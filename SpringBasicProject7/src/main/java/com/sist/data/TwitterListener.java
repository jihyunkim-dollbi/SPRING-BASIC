package com.sist.data;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterListener implements StatusListener {

	@Override
	public void onException(Exception ex) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//실제데이터 처리
	@Override
	public void onStatus(Status status) {
		// TODO Auto-generated method stub
		//하나를 읽을떄 값 읽기
		System.out.println(status.getUser().getScreenName()); //id
		System.out.println(status.getText()); //내용
		System.out.println(status.getCreatedAt()); //쓴 날짜
		System.out.println(status.getFavoriteCount()); //좋아요개수
		System.out.println(status.getUser().getOriginalProfileImageURL()); // 프로필 사진
		System.out.println("=============================================");
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

}

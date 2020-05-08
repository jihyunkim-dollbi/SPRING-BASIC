package com.sist.data;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
//실시간 트위터 내용 가져오기!!
public class TwitterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			
			TwitterStream ts=new TwitterStreamFactory().getInstance(); //트위터를 읽어올수있는 통로, io를 만든 통로
			String[] data={"개발자"};
			TwitterListener listener=new TwitterListener(); //listener가 갖고있는 onstatus를 읽어라..
			ts.addListener(listener); //연결이 된다
			
			//데이터 넘기는
			FilterQuery fq=new FilterQuery();
			fq.track(data);
			
			//데이터 읽어라
			ts.filter(fq);
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
			
		}
		
		
	}

}

package com.sist.data;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
//�ǽð� Ʈ���� ���� ��������!!
public class TwitterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			
			TwitterStream ts=new TwitterStreamFactory().getInstance(); //Ʈ���͸� �о�ü��ִ� ���, io�� ���� ���
			String[] data={"������"};
			TwitterListener listener=new TwitterListener(); //listener�� �����ִ� onstatus�� �о��..
			ts.addListener(listener); //������ �ȴ�
			
			//������ �ѱ��
			FilterQuery fq=new FilterQuery();
			fq.track(data);
			
			//������ �о��
			ts.filter(fq);
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
			
		}
		
		
	}

}

package com.sist.xml;
//���̹� ������ xml�� �Ľ��ϱ�
//newssearch.naver.com/search.naver?where=rss&query=��ȭ
//�׷ҿ� �Է��ϸ� xml ������ ����.
//		com���� �����ּ�	  / rss�� xml����, query �˻���
/*<rss xmlns:media="http://search.yahoo.com/mrss/" xmlns:dc="http://purl.org/dc/elements/1.1/" version="2.0">
<channel>
<title>���̹� �����˻� :: '��ȭ'</title>
<link>
https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94&sm=tab_pge&sort=0&photo=0=&field=0&pd=0&ds=&de=&refresh=-1&docid=
</link>
<description>���̹� �����˻� '��ȭ'�� ���� �˻�����Դϴ�.</description>
<language>ko</language>
<lastBuildDate>Fri, 15 May 2020 12:19:43 +0900</lastBuildDate>
<ttl>5</ttl>
<image>
<title>���̹� �����˻� :: '��ȭ'</title>
<link>
https://search.naver.com/search.naver?where=news&query=%EC%98%81%ED%99%94&sm=tab_pge&sort=0&photo=0=&field=0&pd=0&ds=&de=&refresh=-1&docid=
</link>
<url>
http://imgnews.naver.net/image/news/naverme/news_40x40.jpg
</url>
</image>
 * 
 * rss�ؿ� channel => rss�� Ŭ������ �ǰ�, channel�� Ŭ���� items�� �����ֱ⶧����.. items�� Ŭ���� 
 * items�� 7���� ������ �ִ� tag and tag���̿� tag�� ������ Ŭ���� , ���� ������ ����
 * xml binding => jaxb
 * jaxp => 
 * jaxb => Ŭ������ xml-tag�� ����
 * 
 * rss => xe �����ͺ��̽�
 * chaneel => table
 * item, title link, => �÷�
 * item => �Ѱ��� vo���ȴ�.
 * items�ȿ� title, link=> ����

 */
// http://newssearch.naver.com/search.naver?where=rss&query=%EC%98%81%ED%99%94 ==> ���ڵ��Ǿ��⶧����  ���ڵ�ó�� �ʿ�? .net���� ó��
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import java.net.*;
@Component  //�Ϲ� Ŭ������ ���!
public class NewsManager {

	public List<Item> newsAllData(String fd)
	{
		List<Item> list=new ArrayList<Item>();
		try
		{
			//����
			JAXBContext jc=JAXBContext.newInstance(Rss.class); //��ü����=> ����������? Rss => rootElement! => ���� �ֻ��� �±�
			//�ڹٷ� ��ȯ����
			Unmarshaller un=jc.createUnmarshaller(); //xml�� java�� ��ȯ
			URL url=new URL("http://newssearch.naver.com/search.naver?where=rss&query="
					+URLEncoder.encode(fd,"UTF-8")); //���ڵ��ϱ�
			//rss�� ���� ä���
			Rss rss=(Rss)un.unmarshal(url); //�������� object�̱⶧���� rss�� ����ȯ
			list=rss.getChannel().getItem(); //chennal���� item�� ����Ʈ�� �����ֱ⶧���� ���� add�� �ʿ�x
			
		}catch(Exception ex){}
		
		return list;
	}
}

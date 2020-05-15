package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
//마샬
//언마샬 => 자바로 변환하기
//xml 의 tag명과 클래스명 일치시키기
@Getter
@Setter
@XmlRootElement
public class Rss {

	private Channel channel=new Channel();
	
	
}

package com.sist.xml;
//xml 의 tag명과 클래스명 일치시키기
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Channel {
	//item은 50개를 가져올것이다
	private List<Item> item=new ArrayList<Item>();
	
}

package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
//����
//�𸶼� => �ڹٷ� ��ȯ�ϱ�
//xml �� tag��� Ŭ������ ��ġ��Ű��
@Getter
@Setter
@XmlRootElement
public class Rss {

	private Channel channel=new Channel();
	
	
}

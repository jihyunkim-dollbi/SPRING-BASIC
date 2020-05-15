package com.sist.xml;

import lombok.Getter;
import lombok.Setter;

//xml �� tag��� Ŭ������ ��ġ��Ű��
/*
<items>

<title>'�ѻ�: ���� ����', ������-������-�ȼ��� �� ĳ���� Ȯ��... '��' ���� �մ´�</title>
<link>
http://www.stardailynews.co.kr/news/articleView.html?idxno=271563
</link>
<description>
<![CDATA[
 ��ȭ '��'�� ���ѹ� ������ �����ϴ� �̼��� 3���� �� �� ��° ������Ʈ�� '�ѻ�: ���� ����'�� �Ϻ���... ��ȭ '�ѻ�: ���� ����'�� �� ��ø 5�� ��, ������ ���� ������ ����ϱ� ���� �̼��� �屺�� ������������ ������...
]]>
</description>
<pubDate>Fri, 15 May 2020 12:18:00 +0900</pubDate>
<author>��Ÿ���ϸ�����</author>
<category>���Ǿ���</category>
<media:thumbnail url="https://imgnews.pstatic.net/image/thumb140/5401/2020/05/15/205217.jpg"/>

</item>
 */
@Getter
@Setter
public class Item {

	private String title, link, description, author;
}

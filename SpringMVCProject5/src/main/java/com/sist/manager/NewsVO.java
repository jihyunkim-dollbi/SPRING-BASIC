package com.sist.manager;

import lombok.Getter;
import lombok.Setter;

/*
 * <ul class="list_line #list">

							<li>
				<a href="http://v.movie.daum.net/v/20200512115920097" class="thumb_line bg_noimage2 @1">
																				<span class="thumb_img" style="background-image:url(//img1.daumcdn.net/thumb/S320x200/?fname=https://t1.daumcdn.net/news/202005/12/10asia/20200512115920437knxr.jpg);"></span>
				</a>
				<span class="cont_line">
					<strong class="tit_line"><a href="http://v.movie.daum.net/v/20200512115920097" class="link_txt @1">'초미의 관심사' 조민수·치타, 카메라 안과 밖 180도 다른 '케미'</a></strong>
					<a href="http://v.movie.daum.net/v/20200512115920097" class="desc_line @1">
						영화 '초미의 관심사'의 조민수와 치타(김은영)가 사랑스러운 모녀 바이브로 시선을 사로잡았다.        '초미의 관심사'는 돈을 들고 튄 막내를 쫓기 위해 단 하루 손잡은 극과 극 모녀의 예측불허 추격전. 공개된 메이킹 스틸 속, 환하게 웃고 있는 조민수와 치타는 사랑스럽고 훈훈한 모녀 케미를 풍기고 있어 눈길을 끈다.극 중 물과 기름 같은 정반대 성격
					</a>
					<span class="state_line">
						텐아시아<span class="txt_dot"></span><span class="screen_out">발행일자</span>20.05.12
					</span>
				</span>
			</li>
 * REACT!
 * task programm
 * scheduler programm
 * 실시간으로 데이터 변경해줌..
 * 
 * JS => setInterval => 동일하지만 깜빡거림..
 * 
 */
@Getter
@Setter
public class NewsVO {

	private String title, poster, content, link, author;
	
}

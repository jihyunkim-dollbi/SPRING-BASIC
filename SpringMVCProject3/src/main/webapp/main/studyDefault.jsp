<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react-dom.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="root"></div>
	<!-- /*
artmovieYn: null
audiCnt: 2298
director: "첸 카이거"
dtNm: "(주)제이앤씨미디어그룹,(주)드림팩트엔터테인먼트"
endDate: "2020년 05월 11일(월)"
endYearDate: "2020.05.11"
genre: "드라마,멜로/로맨스"
indieYn: null
movieCd: "20173226"
movieNm: "패왕별희 디 오리지널"
movieNmEn: "Farewell My Concubine"
moviePrdtStat: "개봉"
movieType: "장편"
multmovieYn: "Y"
openDt: "20170330"
prNm: null
prdtYear: "1993"
rank: 4
rankInten: 1
rankOldAndNew: "OLD"
repNationCd: "중국"
rownum: 4
salesAmt: 19139620
scrCnt: 367
showCnt: 479
showDt: "20200511"
showTm: "171"
showTs: "15"
startDate: "2020년 05월 11일(월)"
startYearDate: "2020.05.11"
synop: "어렸을 때부터 함께 경극을 해온 ‘두지’(장국영)와 ‘시투’(장풍의). 
↵세상에 둘도 없는 절친한 아우와 형이지만, 
↵‘두지’는 남몰래 ‘시투’에 대한 마음을 품고 있다.
↵
↵하지만 ‘시투’는 여인 ‘주샨’(공리)에 마음을 빼앗기고, 
↵그로 인해 ‘두지’는 감정의 소용돌이에 빠지게 되는데…
↵
↵사랑과 운명, 아름다움을 뒤바꾼 화려한 막이 열린다!
↵"
thumbUrl: "/common/mast/movie/2020/04/thumb/thn_0deb57925f8147f4892d0b5742fa4b07.jpg"
watchGradeNm: "15세이상관람가"
*/
 -->
	<script type="text/babel">
/*

	1. 항상 열고닫기
	2. hltml은 항상 소문자
	3. style={{""}}  ==> {{ }}  붙이기!
	4. class => className
5. 클래스이름 반드시 대문자 아무거나 가능
6.{} 출력
*/

	class MainMovieList extends React.Component
	{
			constructor(props)생성자함수의 기본
			{
				super(props 속성값);
				this.state={		---변수선언 this 멤버변수
					movie:[],
					no:1  객체단위이기때문에 .으로 가져올수잇다
				}
			}
			




-- json이 있어야하는 곳!
			{
				axios.get("http://localhost/myapp2/main/def.do",{ axios => ajax역할! 서버연결!!
				
					params:{
						no:this.state.no
					}

				}).then((res)=>{
					this.setState({movie:res.data}) 
					console.log(res.data);				
				});
				
			}

			render()   -- html에 출력하는 곳, 데이터를 계속 갱신함!
			{
				const html=this.state.movie.map((m)=>
					<tr>
						<td className="text-center">
							<img src={"http://www.kobis.or.kr"+m.thumbUrl} width="35" height="35"/>
						</td>
						<td className="text-center">{m.movieNm}</td>
						<td className="text-center">{m.genre}</td>
						<td className="text-center">{m.watchGradeNm}</td>
					</tr>			
					/* 10개 누적됨!! */

				)         리턴값 안에 html이 root div안에 들어간다.
				return(
					<div className="row">
					   <div className="col-sm-6">
						</div>
						<div className="col-sm-6">
							<table className="table table-hover">
								<thead>
									<tr>
										<th className="text-center"></th>
										<th className="text-center">영화명</th>
										<th className="text-center">장르</th>
										<th className="text-center">등급</th>
									</tr>
								</thead>
								<tbody>
									{html}
								</tbody>
							</table>
						</div>
					</div>	
				);
			}
	}
	ReactDOM.render(<MainMovieList/>,document.getElementById('root'))
						랜더의 리턴값을 받음 				root에 innerhtml해!!

componentDidMount => onload!!
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react-dom.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="root"></div>
	<script type="text/babel">
		class Detail extends React.Component{ //무조건 state로 변수를 잡아야 다른 클래스에서 사용이 가능하다. 따라서 필요한 변수를 this.state에 모두 선언해놓고 아래 render에서 사용해야한다.
			constructor(props)
			{	
				super(props);		//state에서 변수를 잡고 데이터 받기 가능!//시작하자마자 페이지에서 필요한 데이터들을 생성자에서 받아놓고 시작함!
				this.state={		//jsp파일이기때문에 ${} => el형식이 가능한 것이고 스크립트부분을 JS파일로 만들경우는 EL불가능하다. 따라서 모든 경우의수를 알고있어야.
					mno:${mno}, 	//el코딩 가능! 자바에서 보낸 것을 받음!
					detail:${json}  //java에서 direct로 받기 가능! controller에서 json문자열을 "json"으로 키값으로 보냄!! => {this.state.detail.title} 하여 
				}
				//this.data=${json} ==>이렇게 맴버변수로 사용할 수도 있겠지만 처음에는 출력되고 그 다음 데이터를 사용 못한다 =>따라서 state에서 변수를 선언해놓고 setState(render()포함)하여 아래서 데이터를 계속 사용할 수있게해야한다.  
			}
			/*
			async componentDidMount()  //?로 받은 해당페이지와 값 넘기는 것과 같은 형식! //=> async비동기화 설정!
			{
				axios.get("http://localhost/web/main/detail_data.do",{
					param:{
						mno:this.state.mno
					}
				
			}).then((result)=>{
				this.setState({detail:result.data}) //가져와서 detail데이터 저장하고 render에서 화면출력함! setState에는 render함수를 포함하고 있다! 변수는 setState할때 변수값이 변경되기때문에 반드시 setState하여야하는데 setState하려면 생성자에서 state변수를 잡아놓고 사용해야한다.
				console.log(this.state.detail)
				});
			
			}*/
			render(){ // root에 보낼 html
				return ( //리턴의 ( 괄호로 내리지 않기- 문법! //el을 사용할수있으므로 session등등 모두 동일하게 사용!
					<div className="row">
					<h1 className="text-center">뮤직 상세보기(${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.id})</h1>
						<table className="table">
							<tr>	
								<td colSpan="2" className="text-center">
									<iframe src={"http://youtube.com/embed/"+this.state.detail.key} width="900" height="450"></iframe>
								</td>
							</tr>
							<tr>
								<td ><b>노래명</b></td>
								<td>{this.state.detail.title}</td>
							</tr>
							<tr>
								<td><b>앨범</b></td>
								<td>{this.state.detail.album}</td>
							</tr>
							<tr>
								<td><b>가수명</b></td>
								<td>{this.state.detail.singer}</td>
							</tr>
						</table>
						<table className="table">
							<tr>
								<td className="text-right">
									<c:if test="${sessionScope.id!=null}">
									<a href="logout.do" className="btn btn-sm btn-danger">로그아웃</a>
									</c:if>
									<a href="list.do" className="btn btn-sm btn-primary">목록</a>
								</td>
							</tr>
						</table>
					</div>
				)
			}
		}
		ReactDOM.render(<Detail/>,document.getElementById('root'))
		//detail클래스를 랜더할거야
		//						document.getElementById('root')) => $('#root').html()
		
	</script>
	<c:if test="${sessionScope.id!=null }">
	<div class="container">
		<h2 class="text-center">댓글</h2>
		<div class="row">
			<table class="table">
				<tr>
					<td></td>
				</tr>
				
			</table>
		</div>
	</div>
	</c:if>
</body>
</html>
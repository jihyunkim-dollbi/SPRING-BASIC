<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react-dom.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container" id="root">
		<!-- react 출력위치: id가 root인곳에 결과를 출력해줘! 가상메모리에 저장되기때문에 소스확인이 어렵다! 미리보기 소스가 없어서 jsoup 불가능!!!
			자바스크립트가 많으면 webpack으로 바꿔서..올린다?, 지능형 웹 - 실시간 채팅창! 채팅서버 by nodeJS(REACT,..재사용가능!)
			ex) import, 소스를 고치려면 => xml로 변경.
				재사용! 수정-오버라이딩(modify), 추가-오버로딩(new), 삭제 가능해야!! => 다형성(상속,포함클래스!=> 재사용!) , 캡슐화!
			-->
	</div>
	
	<!-- 
	
	
	JSX => ES6버전 => JAVASCRIPT+XML => \"\" 안해도되고, ; 안해되되고
	EX8버전 =>ANNOTATION!, ARRAYLIST.. ETC..
	
	babel 버전! 
	
	단방향 통신! 한방향으로만 데이터가 송신됨! 
	스프링 서버 => 에서 json을 넘어옴/가져옴 ==> App => props ==>  musicTable => props => musicRow
						searchBar => App => same!
	but json을 서버 밖에 전역으로 빼버린다면!?
	table, row, bar => class 각각에서 데이터를 모두 사용가능함! => (지역변수로 서버에서 받아서 사용경우는 매개변수로 데이터를 받는 것=> react!, 전역으로 빼서 데이터를 효율적으로 가져다 쓰는게 redux!, spring처럼! 라이브러리로 되어있는것이 mobix! )
	리액트의 단점! 단방향통신!
	
	먼저! music:[]에 데이터를 출력하자!
	
	this. => 멤버변수로 바뀐다!
	1.initialization => constructor
	2.Mounting
	*componentWillMount(데이터가져오기)(사라짐!)
	*render => 데이터에 해당하는 html구현/출력  * didMount => html을 트리형태로 메모리에 저장! =>화면에 출력됨(window.onload화면 초기화,=$(function))
		didmount에서 render로 다시 올라가기 가능해짐! this.setstate({})(렌더로 가는아이)를 하고 => updation로 고고! => and then 값을 다시 또 변경하려면 setstate를 변경해면됨 =>again updation gogo
		didMount는 데이터를 제정의하는 공간!
		가상으로 가져오고 다시 updationg에서 states(has data)rerendering하는 형식으로 바뀜! 
	
		결과적으로 render는 html만 출력해주는 곳!
		
		<순서>
		 <App/> 
		1.constructor() :초기화(변수설정) -> 설정만하는 공간, 이벤트 등록만하는 곳, 데이터X
		2.render () : 데이터를 받아서 화면출력(HTML)
		3.componentDidMount : 완료 => 브라우저에 출력!
			-----------------
			완료가 된 다음에 => 화면을 변경해라 명령을 내리기! => render()를 다시 호출
						------------
							reRendering => setState() 하게되면 렌더를 다시 호출하면서 그림을 다시 그림
							
		가상메모리/단방향통신!					
							
		INSIDE 리액트 시스템! => 가상메모리 사용! (ex. streambuffer!) => and 오라클도 임시저장에 저장하고 commit해야 실제저장소에 저장됨!				
		 A가상돔 (가상메모리) B 실제출력공간					
		"Mount" =>가상메모리에 올려주는 아이==> 깜빡거림X,속도GOOD! 가상으로 dom(A)을 만들고 rerendering하면 추가된 내용만 B에 변경된다.
	
		**호출하는 과정! => 처리 순서 정리하기!!
		
	-->
	<script type="text/babel">
/*	
	
	https://medium.com/@ralph1786/intro-to-react-component-lifecycle-ac52bf6340c
	
	변수 종류 2개!
	<App name="홍길동">  ==>과동일 new App("홍길동")  매개변수의 값을 받을때 속성값이라고 한다.=> 변경할수x
	1. props : name="홍길동" => 변경이 불가능한 값 (생성자에서 보통 사용됨!변경할수없는 값으로 사용됨)
	2. state : 변경이 가능한값!
		
	music:[] 들어오는 것이 배열
	music:{} row1줄
	ss:'' searchBar => ''안에서 받을 값을..
	//아래 3개의 데이터를 조립된 곳으로 가져와서 출력해야한다. => 조립된 곳은 App! 따라서 여기서 받는다. 
	// => 전체클래스를 관리한다 여러 컴포넌트의 처리과정이 하나로 연결되어있기때문에
		
	
	함수 만드는 방법
1	function H(){

	}
2	var H=function(){} => 함수를 변수로 받아서도 가능!
3 	var H=()=>{}	//람다식 function 삭제
	
*/
		const H=()=>{ //함수의 주소를 받아서 처리하기
		const color=['red','green','blue','yellow','pink']; //변경안하는 변수
		let rand=parseInt(Math.random()*5) //변경되는 변수
		let s={"color":color[rand]}
		return(
			<h1 className="text-center" style={{s}}>뮤직 Top 200</h1>
		)
	}

/*		
		상위버전 => memo,hook...
		const H2=React.memo(()=>{ //메모리제이션 한번 호출하고 그 다음은 그전에 것을 다시 사용1 => 첫번째 컬러만 호출되고 그다음 검색에서는 컬러변경x
		const color=['red','green','blue','yellow','pink']; //변경안하는 변수
		let rand=parseInt(Math.random()*5) //변경되는 변수
		let s={"color":color[rand]}
		return(
			<h1 className="text-center" style={{s}}>뮤직 Top 200</h1>
	}
*/
	class App extends React.Component{
		//생성자		속성값을 받을지도?  super:Component(기능을 가진 객체:상속을 받는다.)t this:app
		constructor(props){ //디폴트 화면에서 띄워줄 데이터들(music, ss...)을 선언초기화해준다.
			super(props); //속성값을 받을때
			//서버에서 들어오는 데이터를 받아서 저장할때
			this.state={
				music:[],
				ss:''

			} 
			//react에서 이벤트 등록할때 사용! 이벤트 네임 = onUserInput
			this.handlerUserInput=this.handlerUserInput.bind(this);
		}
		//따라서 app에서 ss의 값을 받아서 다른테이블로 전송해야한다.
		handlerUserInput(ss) //searchbar에서 받은 정보를 다른테이블에 직접적으로 넘길 수가 없다. => 포함관계가 있어야 속성값으로 값을 넘기고 받을수있다. 속성을 통해서 이벤트자체도 넘길수있다.
		{		
			this.setState({ss:ss});
		}
		//ss값이 테이블에 넘어감!
		componentDidMount() //state안에 값을 채우자.
		{
			//서버연결  ==> 서버에 연결이 되어있기때문에 여기서 다시 값을 보내줘야한다. 아래 제목의 detail.do는 그냥 이벤트정도이다..=> props를 속성값으로 어떻게 보낼까.. 생각해봐야..
			// 이미 list.do에는 json이 출력되어있는 상태! .then()데이터 받는 아이  값받는 변수명은 아무거나 가능! json파일이 모두 result에 담김! => call back 함수 => .do를 실행하면 then()을 실행하여 값을 받음
			axios.get('http://localhost/web/main/music.do').then((result)=>{
				
				console.log(result.data); // .data를 해줘야 콘솔창에서 config, header의 값을없애고 data만 확인할 수있다. => object에는 어떤 값들이 있는지 확인하기
				//현재 result는 지역변수 따라서 state에 저장해야(멤버변수로 만들어서=> music[]에 넣어야 아래 클래스 에서 사용가능) => 아래 class에서 사용가능! 
				//가져온 데이터를 []에 넣기위해서는 setstate()를 사용한다.
				this.state.music=result.data; //this에 저장만 한 상태
				//setState()를 사용해야 그 안에 함수 {render()}가 데이터를 출력가능하게 한다. 반드시 렌더가 호출되야 한다. => 채워진 값으로 화면이 바뀜 by setState() and render()
				this.setState({music:result.data})
				//여기에 this는 axios의 this이다 따라서 app의 this를 사용해야 오류x
				//axios.get('http://localhost/web/main/music.do').then(function (result){ 에서 위와 같이 function 지우고 람다식으로 => 사용해야 app클래스의 this를 사용할수있다
				//콘솔 object에 데이터 나오는지만 확인하고 실제출력은 musicTable로 고고!!
			})
		}

		//실제 메모리에 저장됨 => 화면출력 (html로..)
		//this.setState({music:result.data})의  값을 가져와야함
		//xml형식의 html
		//계층구조가 명확해야한다.(열고닫기 주의) =>xml html을 자동으로 변환해준다.
		render() {
			
			return ( //항상 어떤 리턴값이 있어야 데이터를 가져올수있다.
			<div className="row">
				<H/>	
				<SearchBar ss={this.state.ss} onUserInput={this.handlerUserInput}/>
				<div style={{"height":"30px"}}></div>
				<MusicTable music={this.state.music} ss={this.state.ss} /> 
			</div>

			)	//<SearchBar ss={this.state.ss} onUserInput={this.handlerUserInput}/> 매개변수는 속성으로 2개 넘김!!! this.props.ss는 app이 가진 ss!? ss가 가진것!?
				//<H/> ==> 함수를 호출한다는 것은 리턴값을 받겠다는 것임!
				//<MusicTable music={this.state.music} ss={this.state.ss} />  => 렌더를 호출해서  리턴값을 가져옴! 클래스 호출하는 것임!
				//데이터를 보낼때는 내가 포함한 관계에 잇는 것에만 보낼수있다. 따라서 app => table => row,row, row =======>depth가 많을 수록 복잡해져서 redux나 mobix로 고고!!
				//												  => seachabar
		}
	
	}
	//music={this.state.music}/>  => props
	class MusicTable extends React.Component{
		//m은 
		render(){
		let rows=[];
		//[{title: , mno: , ....},{},{},..] []는 music object=> m=[] , m[0]으로 가져옴, {a:, b: ,..}는 m 클래스 =>m.a m.b  
		this.props.music.forEach((m,key)=>{ //매개변수가 들어가야한다!
			if(m.title.indexOf(this.props.ss)===-1) //같다 === ss가 -1이면 타이틀안에 포함이 안되었다는 뜻. ss가 title과 일치하지 않는다면.. return; // indexOf =-1일때 존재하지 않음..
			{
				return;
			}
			//데이터를 rows에 추가해라// ss로 찾은것만 rows에 추가해~ <MusicRow에 이 클래스에 첨부해
			rows.push(<MusicRow music={m}/>)

	   	})
		 	return ( //항상 return을 해놔야 render가 작동한다.=>받은 데이터를 console에서 확인가능 //m은 200줄의 rows중 1줄! => vo한개! music가 list!
				<table className="table">
					
					<thead>
						<tr className="danger">
							<th className="text-center">순의</th>
							<th className="text-center">등폭</th>
							<th className="text-center"></th>
							<th className="text-center">노래명</th>
							<th className="text-center">가수명</th>
						</tr>
					</thead>
					<tbody>
						{rows}
					</tbody>
				</table>
			)//변수 출력할때 {} 사용!!
		}
	}
	//{rows}를 여기서 받아서 여기서는 여러개의 rows있는 상태
	//여기서 한줄씩 명시 해주기
	class MusicRow extends React.Component{
		render()
		{
			//this를 반드시 붙여야함 맨 위에서 받아온 값?!
			//변수는 "" 안붙인다  붙이면 문자로인식
			//리턴안에는 for문이나 조건문 사용x, 	{/* 다중조건문 */}
			return (
			
				<tr>
					<td className="text-center">{this.props.music.mno}</td>
					<td className="text-center">
						{
							this.props.music.state==="상승" && 
							<span style={{"color":"red"}}>▲ {this.props.music.idcliment}</span>
						}
						
						{
							this.props.music.state==="하강" && 
							<span style={{"color":"blue"}}>▼ {this.props.music.idcliment}</span>
						}
						
						{
							this.props.music.state==="유지" && 
							<span style={{"color":"gray"}}>-</span>
						}
					</td>					
					<td className="text-center">
						<img src={this.props.music.poster} width="30" height="30"/>
					</td>
					<td><a href={"detail.do?mno="+this.props.music.mno}>{this.props.music.title}</a></td>
					<td>{this.props.music.singer}</td>
				</tr>
		
			)
		}

	}
	class SearchBar extends React.Component{
			constructor(props)
			{
				super(props);
				this.onChange=this.onChange.bind(this); //이벤트는 여기서 발생하지만 데이터는 app에서 받는다,
			}
			onChange(e) //target.value입력한 값 가져옴
			{
				this.props.onUserInput(e.target.value)
			}

			render(){
			
				return (

				<input type="text" size="30" className="input-sm" placeholder="검색"
					value={this.props.ss} onChange={this.onChange}
				/>
				
				)// value={this.props.ss}  => ss가 가진 값?
			}
			//searchbar 호출하러 고고! //반드시 리턴을 해야 다른 곳에서 사용가능함!!
	
	}
	ReactDOM.render(<App/>,document.getElementById('root'));
	//main역할 가장 먼저 실행됨!
	//inner html 해!
	//String data=new App().render() 화면출력 부분! ==> $('root').html(data) => 이 전체 한줄이<App/> 와 동일! 
		
	//render()
	//	{
	//		return (
	//			<h1>hello</h1>
	//		)
	//	}
		
	</script>
	<!-- app(main)에서 리턴하는 html을 root여기에 집어넣어.. 
		app에 아래의 모든 클래스를 넣을 예정!
		<~~~/>의 리턴형인 <h1>hello</h1>자체 =>  html을 root에 그대로 들어간다.
	-->
</body>
</html>
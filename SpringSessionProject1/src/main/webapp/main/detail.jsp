<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		class Detail extends React.Component{
			render(){ // root에 보낼 html
				return ( //리턴의 ( 괄호로 내리지 않기- 문법!
					<div className="row">
					<h1 className="text-center">영화 상세보기</h1>
					</div>
				)
			}
		}
		ReactDOM.render(<Detail/>,document.getElementById('root'))
		//detail클래스를 랜더할거야
		//						document.getElementById('root')) => $('#root').html()
		
	</script>
</body>
</html>
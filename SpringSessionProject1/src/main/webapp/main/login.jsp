<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Isert title here</title>
<style type="text/css">
.row{
	margin:0px auto;
	width: 350px;

}
</style>
</head>
<body>
	<div class="container">
		<h2 class="text-center">로그인</h2>
		<form method="post" action="login_ok.do">
		<div class="row" >
			<table class="table">
				<tr>
					<th width="30%" class="text-right danger">아이디</th>
					<td width="70%">
						<input type=text name=id class="input-sm" size=15><!-- form tag에서 사용자가 입력한 name값을 읽어가 controller에서 매개변수로 받을수있다. --> 
					</td>
				</tr>
				<tr>
					<th width="30%" class="text-right danger">비밀번호</th>
					<td width="70%">
						<input type=password name=pwd class="input-sm" size=15>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<button class="btn btn-sm btn-primary">로그인</button><!-- button 을 사용하면 submit기능 있음 -->
						<input type=button class="btn btn-sm btn-danger" value="취소">
					</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
	<!-- pom.xml에 tiles 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using Tiles Structure</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table" style="height: 700px; width: 900px">
				<tr>
					<td colspan="2" height="100" class="success text-center">
						<tiles:insertAttribute name="header"/>
					</td>
				</tr>
				<tr>
					<td width="200" height="500" class="danger">
						<tiles:insertAttribute name="menu"/>
					</td>
					<td width="700" height="500" class="warning">
						<tiles:insertAttribute name="content"/><!-- default=> 바뀌는 명령 => web-inf -->
					</td>
				</tr>
				<tr>
					<td colspan="2" height="100" class="info text-center">
						<tiles:insertAttribute name="footer"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
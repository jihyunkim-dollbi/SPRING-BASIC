<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${vo.name }<br>
성별:${vo.sex }<br>
주소:${vo.address }<br>
<!-- name=addr로 되었기 때문에 주소는 출력되지 않는다. 
	따라서 vo의 변수명(address)과  form 에서 값을 넘길때 name=addr이 일치해야한다!
-->
전화:${vo.tel }<br>
소개:${vo.content }<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.row {
	margin:0px auto;
	width:750px;
}
</style>
</head>
<%--
	JSP => MovieController
		
		find.do => 처리하기 => @PostMapping("find.do")
		==> 사용자 요청값 name=fd 을 받아서 => DAO연결! => DB검색후
		결과값을 JSP로 전송! => JSP화면 출력!

		
 --%>
<body>
<div class="container">
 <div class="row">
	<h1 class="text-center">영화 목록</h1>
	<table class="table">
		<tr>
			<td>
				<form method="post" action="find.do"> <!-- find.do를 누르면 fd(사용자 입력값)가 넘어가서  -->	
				Search:<input type=text name=fd size=15 class="input-sm">
				<input type=submit value="찾기" class="btn btn-sm btn-primary"><!-- 몽고디비-> 유사문자열 찾기! -->
				</form>
			</td>
		</tr>
	</table>
	<c:forEach var="vo" items="${list }">
    <div class="col-md-4">
      <div class="thumbnail">
        <a href="detail.do?mno=${vo.mno} " >
          <img src="${vo.poster }" alt="Lights" style="width:100%">
          <div class="caption">
            <p>${vo.title }</p>
          </div>
        </a>
      </div>
    </div>
    </c:forEach>
</div>
</div>
	<!-- 페이징 버튼 -->
	<div class="row text-center">
		<a href="../movie/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
		${curpage } page /  ${totalpage } pages
		<a href="../movie/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
	</div>


</body>
</html>
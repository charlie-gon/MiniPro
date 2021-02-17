<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<style>

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
<script>
	function goPage(page){
		location.href='${pageContext.request.contextPath}/paging.do?pageNo='+page;
	}
</script>
</head>
<body>
	<div align="center">
		<jsp:include page="../common/menu.jsp" />
		<h1>처음 접속 시 나오는 페이지</h1>
		<!-- From CursorType.java -->
		<h3>${vo}</h3>
		<!-- http://localhost/MiniPro/cursor.do -->
		
		<h1>&#9786;&#9786;&#9786;페이징&#9786;&#9786;&#9786;</h1>
		<c:forEach var="vo" items="${list }">
			<p>id:${vo.employeeId } / ${vo.firstName } / ${vo.lastName }</p>
		</c:forEach>
		<jsp:include page="../common/paging.jsp" />
		<p>
		<h1>&#9786;&#9786;&#9786;페이징&#9786;&#9786;&#9786;</h1>
	</div>
</body>
</html>
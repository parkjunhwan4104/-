<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DB.Article"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 목록</h1>
	
	<c:forEach items="${articles}" var="article">
	번호:${article.id} <br>
	제목:${article.title }<br>
	내용:${article.body }<br>
	작성자:${article.nickname }<br>
	작성일:${article.regDate }<br>
	<hr>
	</c:forEach>	
	<br>
<a href="/Board/add.jsp">글쓰기</a>

</body>
</html>
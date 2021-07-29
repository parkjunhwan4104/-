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
	<h1>게시물 추가</h1>
	
	<form action="/Board/ArticleController/add">
		<div>
			<div>
			게시물 제목: <input type="text" name="title">
			</div>
			
			<div>
			게시물 내용: <textarea name="body"></textarea>
			</div>
			<input type="submit"/>
		</div>
	
	</form>
	<br>
	<a href="/Board/ArticleController/List">목록으로</a>

</body>
</html>
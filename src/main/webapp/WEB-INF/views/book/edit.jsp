<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>도서 정보 수정</title>
</head>
<body>
	<h2>도서 정보 수정</h2>
	
	<form action="/edit" method="post">
		<p>
			도서명 : <input type="text" name="title" value="${result.title}"/>
		</p>
		<p>
			카테고리 : <input type="text" name="category" value="${result.category}"/>
		</p>
		<p>
			가격 : <input type="text" name="price" value="${result.price}"/>
		</p>
		<input type="hidden" name="bookId" value="${result.bookId}">
		<button type="submit">수정</button>
	</form> 
</body>
</html>
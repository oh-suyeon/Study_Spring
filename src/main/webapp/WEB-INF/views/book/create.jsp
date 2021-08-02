<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>도서 등록</title>
</head>
<body>
	<h2>${message}</h2>
	
	<form action="/create" method="post">
		<p>
			도서명 : <input type="text" name="title" />
		</p>
		<p>
			카테고리 : <input type="text" name="category" />
		</p>
		<p>
			가격 : <input type="text" name="price" />
		</p>
		<p>
			첨부 이미지 : <input type="file" name="picture" multiple />
		</p>
		<button type="submit">등록</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>등록한 도서 정보</title>
</head>
<body>
	도서 아이디 : ${result.bookId} <br />
	도서 명 : ${result.title} <br />
	카테고리 : ${result.category} <br />
	가격 : ${result.price} <br />
</body>
</html>
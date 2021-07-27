<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>도서 목록</title>
<style type="text/css">
	table, tr, th, td {
		border: 1px solid silver;
	}
	table, th, td{
		border-collapse: collapse;
	}
	table {
		width: 100%;
	}
	form{
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<h2>도서 목록</h2>
	
	<form method="post" action="/list">
		<input type="text" name="keyword" placeholder="검색어를 입력하세요">
		<button type="submit">검색</button>
		
		<button type="button" onclick="location.href='/list'">전체 목록</button>
		<button type="button" onclick="location.href='/create'">도서 등록</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>카테고리</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${result}">
				<tr>
					<td><a href="/detail/${book.bookId}">${book.title}</a></td>
					<td>${book.category}</td>
					<td><fmt:formatNumber type="currency">${book.price}</fmt:formatNumber></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
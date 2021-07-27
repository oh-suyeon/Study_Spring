<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>등록한 도서 정보</title>
<style type="text/css">
	table, tr, th, td {
		border: 1px solid silver;
	}
	table, th, td{
		border-collapse: collapse;
	}
	table {
		width: 100%;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<h2>도서 상세 정보</h2>
	
	<table>
		<thead>
			<tr>
				<th>제목</th>
				<th>카테고리</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${result.title}</td>
				<td>${result.category}</td>
				<td>${result.price}</td>
			</tr>
		</tbody>
	</table>
	<button type="button" onclick="location.href='/edit/${result.bookId}'">수정</button>
	<button type="button" onclick="location.href='/list'">목록으로</button>
</body>
</html>
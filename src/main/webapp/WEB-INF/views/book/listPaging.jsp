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
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="list?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
</head>
<body>
	<h2>도서 목록</h2>
	
	<form action="">
		<input type="text" name="keyword" placeholder="검색어를 입력하세요" value="${keyword}">
		<button type="submit">검색</button>
		
		<button type="button" onclick="location.href='/list'">전체 목록</button>
		<button type="button" onclick="location.href='/create'">도서 등록</button>
	</form>
	
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> 
	
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
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/list?nowPage=${paging.startPage-1}&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&gt;</a>
		</c:if>
	</div>
</body>
</html>
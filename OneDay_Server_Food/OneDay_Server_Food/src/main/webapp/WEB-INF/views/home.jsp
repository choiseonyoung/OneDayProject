<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> ** 다이어트를 도와줘 ** </h1>
	<p>
	<h3>- 가공식품 섭취 리스트 -</h3>
	<c:if test="${empty MFLIST}">데이터 비어있음</c:if>
<table border="1" width=70%>
	<tr bgcolor="pink">
	<th>날짜</th><th>식품명</th><th>섭취량</th><th>총내용량</th><th>에너지</th><th>단백질</th><th>지방</th><th>탄수화물</th><th>총당류</th>
	</tr>
		<c:forEach items="${MFLIST}" var="MF">
		<tr>
		<td>${MF.date}</td>
		<td>${MF.name}</td>
		<td>${MF.take}</td>
		<td>${MF.total}</td>
		<td>${MF.kcal}</td>
		<td>${MF.prot}</td>
		<td>${MF.fat}</td>
		<td>${MF.carb}</td>
		<td>${MF.sugar}</td>
		</tr>
		</c:forEach>
	</table>
	<p>
	<a href="insert">섭취정보 등록</a>
	<p>
	<form action="ask" method="Get">
		<label>날짜</label>
		<input name="date"/>
		<button>조회</button>
	</form>
	
	
</body>
</html>
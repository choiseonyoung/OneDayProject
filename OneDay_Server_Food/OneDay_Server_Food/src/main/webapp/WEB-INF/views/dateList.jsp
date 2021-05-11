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
<c:if test="${empty DATE}">해당 날짜 데이터 없음</c:if>
<table>
	<tr>
	<th>날짜</th><th>식품명</th><th>섭취량</th><th>총내용량</th><th>에너지</th><th>단백질</th><th>지방</th><th>탄수화물</th><th>총당류</th>
	</tr>
		<c:forEach items="${DATE}" var="DT">
		<tr>
		<td>${DT.date}</td>
		<td>${DT.name}</td>
		<td>${DT.take}</td>
		<td>${DT.total}</td>
		<td>${DT.kcal}</td>
		<td>${DT.prot}</td>
		<td>${DT.fat}</td>
		<td>${DT.carb}</td>
		<td>${DT.sugar}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>
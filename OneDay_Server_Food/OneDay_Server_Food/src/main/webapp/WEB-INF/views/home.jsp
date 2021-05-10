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
	<h1>HELLO</h1>
	<p>
	<h2>가공식품 섭취 리스트</h2>
	<table>
	<tr>
		<th>날짜</th><th>식품명</th><th>섭취량</th><th>총내용량</th><th>에너지</th><th>단백질</th><th>지방</th><th>탄수화물</th><th>총당류</th>
	</tr>
		<c:if test="${empty MFLIST}">빈칸</c:if>
		<c:forEach items="${MFLIST}" var="MF">
			<p>${MF.date},
			${MF.name},
			${MF.take},
			${MF.total},
			${MF.kcal},
			${MF.prot},
			${MF.fat},
			${MF.carb},
			${MF.sugar}
		</c:forEach>
	</table>
	<p>
	<a href="insert">섭취정보 등록</a>
	<p>
	<form action="ask">
		<label>날짜</label>
		<input name="date"/>
		<button>조회</button>
	</form>
	
	
</body>
</html>
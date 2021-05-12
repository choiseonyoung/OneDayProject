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
<center>
<p><h3>원하는 식품명을 클릭하세요 &#x1F447;</h3>
<p style="border-bottom: 1px solid #F82564; padding: 0.1em;"></p>
<table border="1" width=100%>
	<tr bgcolor="pink">
	<th>식품코드</th><th>식품명</th><th>출시연도</th><th>제조사코드</th><th>제조사명</th><th>분류코드</th><th>분류명</th><th>1회제공량</th><th>총내용량(g)</th><th>에너지(kcal)</th><th>단백질(g)</th><th>지방</th><th>탄수화물</th><th>총당류</th>
	</tr>
		<c:forEach items="${NAME}" var="NM">
		<tr>
		<td>${NM.fd_fcode}</td>
		<td><a href="name/data?code=${NM.fd_fcode}">${NM.fd_name}</a></td>
		<td>${NM.fd_year}</td>
		<td>${NM.fd_mcode}</td>
		<td>${NM.cp_name}</td>
		<td>${NM.fd_ccode}</td>
		<td>${NM.it_name}</td>
		<td>${NM.fd_size}</td>
		<td>${NM.fd_total}</td>
		<td>${NM.fd_kcal}</td>
		<td>${NM.fd_prot}</td>
		<td>${NM.fd_fat}</td>
		<td>${NM.fd_carb}</td>
		<td>${NM.fd_sugar}</td>
		</tr>
		</c:forEach>
		</table>
	<h4><c:if test="${empty NAME}"><p style="background: linear-gradient(to right, #A7A3FF,#FFA7A3, #671cc4, #5673bd); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">해당 식품 없음</p></c:if></h4>
</body>
</html>
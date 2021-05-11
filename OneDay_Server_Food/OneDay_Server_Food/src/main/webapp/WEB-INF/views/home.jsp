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
<h1><span style="background: linear-gradient(to right, #ffa7a3, #FD7FAB); padding: 0.43em 1em; font-size: 25px; border-radius: 3px; color: #ffffff;"> &#x1F437; 다이어트를 도와줘 &#x1F437; </span></h1>
	<p style="border-bottom: 1px solid #F82564; padding: 0.1em;"></p>
	<h3 style="font-size: 18px; font-weight: bold; color: indianred; text-shadow: 1px 1px 1.2px midnightblue;" >&#x1F43D; 가공식품 섭취 리스트</h3>
	
<table border="1" width=100%>
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
	<h4><c:if test="${empty MFLIST}"><p style="background: linear-gradient(to right, #A7A3FF,#FFA7A3, #671cc4, #5673bd); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">데이터 비어있음</p></c:if></h4>
	<br><br>
	<span style="border-radius: 5em; padding: 0.6em 1em; background: #F9F9F9; box-shadow: 1px 2px 10px rgba(0,0,0,0.2);  margin-left: 5px;"><a href="insert" >섭취정보 등록</a></span>
	<br><br>
	<form action="ask" method="Get">
		<input type="date" value="2021-05-12" name="date"/>
		<button> &#x1F50D; </button>
	</form>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>날짜와 섭취량을 입력하세요</h2>
	<form  method="POST">
	<label>식품코드 :</label>
		<input name="fcode" value="${fcode}">
	<p><label>날짜 : </label>
		<input type="date" value="2021-05-11" name="in_date"/>
	<p><label>섭취량 : </label>
		<input name="in_take"/>
	<p><button>입력</button>
	</form>
</body>
</html>
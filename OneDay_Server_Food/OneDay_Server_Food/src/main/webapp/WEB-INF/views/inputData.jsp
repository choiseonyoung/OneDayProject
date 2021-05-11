<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<br><br>
	<h3><span style="background: #F9F7F6; border-left: 0.5em solid #F73791; padding: 0.5em;">날짜와 섭취량을 입력하세요</span></h3>
	<br><br>
	<form  method="POST">
	<label> &#x1F520;식품코드 </label>
		<input name="fcode" value="${fcode}">
	<p><label> &#x1F4C5; 날짜 </label>
		<input type="date" value="2021-05-12" name="in_date"/>
	<p><label> &#x1F370;섭취량 </label>
		<input name="in_take"/>
	<p><button>입력</button>
	</form>
</body>
</html>
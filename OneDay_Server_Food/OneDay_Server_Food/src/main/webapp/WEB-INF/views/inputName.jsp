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
	<br><h3><span style="background: #F9F7F6; border-left: 0.5em solid #F73791; padding: 0.5em;">식품명을 입력하세요</span></h3>
	<br><br>
	<form action="insert/name">
		<input name="name"/>
		<p><button>입력</button>
	</form>
</body>
</html>
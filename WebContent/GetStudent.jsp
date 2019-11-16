<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="JavaWebWork.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询学生信息</title>
</head>
<body>
	<form action="GetStudent" method="post">
		学号：<input type="text" name="StuID">
		<input type="submit" value="查询">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="JavaWebWork.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生信息</title>
</head>
<body>
	<form action="AddStudent" method="post">
		学号：<input type="text" name="StuID"><br>
		姓名：<input type="text" name="name"><br>
		年龄：<input type="text" name="age"><br>
		班级：<input type="text" name="classname"><br>
		性别：<input type="text" name="sex" "><br>
		出生日期：<input type="text" name="BirthDay" ><br>
		<input type="submit" value="添加">
	</form>
	<table class="mtable2">
				<caption>用户列表</caption>
				<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>班级</th><th>出生日期</th></tr>
				<%
					List students=StudentCRUD.getAllStudent();
					for(int i=0;i<StudentCRUD.getAllStudent().size();i++){
						Student student=(Student)StudentCRUD.getAllStudent().get(i);%>
						<tr>
							<td><%=student.getStuID()%></td>
						    <td><%=student.getSname()%></td>
						    <td><%=student.getSex()%></td>
						    <td><%=student.getAge()%></td>
						    <td><%=student.getClassName()%></td>
						    <td><%=student.getBirthDay()%></td>
						    <!--  <td><a href="UpdateUser.jsp?userid=<%=student.getStuID()%>">修改</a>
						   	 &nbsp;&nbsp;&nbsp;&nbsp;
						    	<a href="DelUser_do.jsp?userid=<%=student.getStuID()%>">删除</a></td>-->
						</tr>
					<%}
				%>
			</table>
</body>
</html>
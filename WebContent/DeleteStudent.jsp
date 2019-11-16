<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="JavaWebWork.*" %>
<%@ page import="java.util.List" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DeleteStudent" method="post">
		<input type="text" name="StuID">
		<input type="submit" value="删除">
	</form>
	<table class="mtable2">
				<caption>用户列表</caption>
				<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>班级</th><th>出生日期</th><th>操作</th></tr>
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
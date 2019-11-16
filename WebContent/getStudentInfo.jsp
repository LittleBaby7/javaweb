<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="JavaWebWork.*" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询出信息</title>
</head>
<body>
	<table class="mtable2">
				<caption>用户列表</caption>
				<tr><th>用户id</th><th>用户名</th><th>性别</th><th>年龄</th><th>班级</th><th>出生日期</th><th>操作</th></tr>
				<%
					Student stu=JavaWebWork.StudentCRUD.get(request.getParameter("StuID"));
					%>
						<tr>
							<td><%=stu.getStuID()%></td>
						    <td><%=stu.getSname()%></td>
						    <td><%=stu.getSex()%></td>
						    <td><%=stu.getAge()%></td>
						    <td><%=stu.getClassName()%></td>
						    <td><%=stu.getBirthDay()%></td>
						    <!--  <td><a href="UpdateUser.jsp?userid=<%=stu.getStuID()%>">修改</a>
						   	 &nbsp;&nbsp;&nbsp;&nbsp;
						    	<a href="DelUser_do.jsp?userid=<%=stu.getStuID()%>">删除</a></td>-->
						</tr>
					<%
				%>
		</table>
</body>
</html>
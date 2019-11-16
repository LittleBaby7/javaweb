<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" errorPage="error.jsp" %>
<%@page import="jdbc.UserBpo"%>
<%@page import="java.util.HashSet"%>
<%
	String userid=request.getParameter("userid");
    String password=request.getParameter("password");
    boolean successflag=UserBpo.validlogin(userid, password);
    if(successflag==true){
    	
    	HashSet sessions=(HashSet)application.getAttribute("sessions");
   	 	if (sessions == null) {
            sessions = new HashSet();
            application.setAttribute("sessions", sessions);
      	}
    	sessions.add(session);
    	
    	session.setAttribute("userid", userid);
    	response.sendRedirect("LoginSuccess.jsp");
    }else{
    	throw new Exception(userid+":账号或密码不正确，登陆失败！");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>校验登陆是否成功</title>
	</head>
	<body>
	</body>
</html>
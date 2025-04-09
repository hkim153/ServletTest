<%@page import="app.servlet.SharedObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("jsp임<br>");
	out.print("이미 있는 session 출력");
	out.print("현재 Session ID: " + session.getId() + "<br>");
	SharedObject sharedObject = (SharedObject)session.getAttribute("HttpSession");
	if(sharedObject != null) {
		out.print("Attribute 정보 : " + sharedObject.getCount() + ", " + sharedObject.getName()+ "<br>");
	}else {
		out.print("Attribute 없음"+ "<br>");
	}
	out.print("Creation Time : " + session.getCreationTime() + "<br>");
	out.print("Last Accessed Time : " + session.getLastAccessedTime()+ "<br>");
	out.print("Max Inactive Interval : " + session.getMaxInactiveInterval()+ "<br>");
	out.print("ServletContext : " + session.getServletContext()+ "<br>");
%>
</body>
</html>
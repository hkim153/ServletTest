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
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		String path = request.getParameter("path");
		String domain = request.getParameter("domain");
		String comment = request.getParameter("comment");
		String maxAge = request.getParameter("maxAge");
		String secure = request.getParameter("secure");
		String version = request.getParameter("version");
		
		Cookie c1 = new Cookie(name, value);
		c1.setPath(path);
		c1.setMaxAge(Integer.parseInt(maxAge));
		c1.setVersion(Integer.parseInt(version));
		response.addCookie(c1);
		response.sendRedirect("../cookieTest");
	%>
</body>
</html>
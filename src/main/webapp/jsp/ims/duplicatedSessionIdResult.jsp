<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 21. 11. 3.
  Time: 오전 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
    %>
    현재 쿠지 정보들:<br>
    <hr>
    <%
        for(Cookie cookie : cookies){
            out.print("name: " + cookie.getName() + "<br>");
            out.print("value: " + cookie.getValue() + "<br>");
            out.print("version: " + cookie.getVersion() + "<br>");
            out.print("path: " + cookie.getPath() + "<br>");
            out.print("age: " + cookie.getMaxAge() + "<br>");

            out.print("<hr>");
        }
    %>
</body>
</html>

<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 2022/05/02
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>web-inf 포함된 요청 확인 dsfa</h2>
    <a href="web-inf/web-inf.jsp">외부의 web-inf안에 있는 jsp 요청하기</a>
</body>
</html>
--%>
<%@ page contentType="text/html" %>
<html>
<body>
<%
    if (!response.getCharacterEncoding().equalsIgnoreCase("iso-8859-1")) {
        throw new ServletException("JSP getCharacterEncoding() spec error; getCharacterEncoding() shall be set as default encoding");
    }
    if (!response.getContentType().equals("text/html")) {
        throw new ServletException("contentType shall not be adjusted");
    }
    out.println("OKAY");
%>
</body>
</html>
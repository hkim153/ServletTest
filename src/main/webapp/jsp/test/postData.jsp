<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 2023/10/04
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../postDataServlet" method="post" >
    textarea: <textarea cols ="30" rows ="10" name="textarea"></textarea> <br/>

    <input type="submit" value="완료">
    <input type="reset" value="다시작성">
</form>
</body>
</html>

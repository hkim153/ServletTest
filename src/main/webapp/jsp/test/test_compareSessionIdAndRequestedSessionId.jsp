<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 2023/04/20
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

현재 sessionid = <%=session.getId()%>
<form action="../../test_compareSessionIdAndRequestedSessionId" method=get>
    <input type="submit" value="Go">
</form>
</body>
</html>

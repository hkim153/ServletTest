<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 2022/04/26
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Multipart Test</h1>
    <form action="../../multipartConfigAnnotationTest" method="post" enctype="multipart/form-data">
        이름 <input type="text" name="name"><br>
        설명 <textarea cols ="30" rows ="10" name="description"></textarea>
        파일 <input type="file" name="file"><br>
        <input type="submit" value="완료">
        <input type="reset" value="다시작성">
    </form>
</body>
</html>

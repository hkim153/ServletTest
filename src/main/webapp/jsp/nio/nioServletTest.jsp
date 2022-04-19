<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>NioServlet Test</h2>
	<form action="../../nioServlet" method=post enctype="multipart/form-data">
		파일: <input type="file" id="file" name="file"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>
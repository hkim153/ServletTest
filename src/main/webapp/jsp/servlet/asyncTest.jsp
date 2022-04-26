<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>AsyncContext Test</h2>
	<form action="../../asyncContextTest?test=1234" method=post>
		is wrapper:
		<input type="radio" name="wrapper" value="true">True
		<input type="radio" name="wrapper" value="false"checked="checked">False<br>
		method:
		<input type="radio" name="method" value="dispatch" >Dispatch
		<input type="radio" name="method" value="start" checked="checked">Start <br>
		isClazz:
		<input type="radio" name="isClazz" value="true" checked="checked">true
		<input type="radio" name="isClazz" value="false">false <br>
		timeout:
		<input type="text" name="timeout" value="0"><br>
		<input type="submit" value="Go">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration Test</h2>
	<form action="../../registrationTest" method=post>
		is wrapper:
		<input type="radio" name="wrapper" value="true">True
		<input type="radio" name="wrapper" value="false"checked="checked">False<br>
		method:
		<input type="radio" name="method" value="dispatch" >Dispatch
		<input type="radio" name="method" value="start" checked="checked">Start <br>
		isClazz:
		<input type="radio" name="isClazz" value="true" checked="checked">true
		<input type="radio" name="isClazz" value="false">false <br>
		<input type="submit" value="Go">
		timeout:
		<input type="text" name="timeout" value="0"><br>
	</form>
</body>
</html>
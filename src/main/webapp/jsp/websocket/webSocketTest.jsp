<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>WebSocket 이란</h2>
	
	<hr>
	<h2>WebSocket Test</h2>
	<ol>
	<li>채팅 프로그
	<form action=webSocketChatting.jsp method="get">
		ID : <input type="text" name="ClientId"> <br/>
		Method : <input type="radio" name="Method" value="Programmatic">Programmatic
				<input type="radio" name="Method" value="Annotated" checked="checked">Annotated <br/>
		isClass : <input type="radio" name="IsClass" value="true">true
				<input type="radio" name="IsClass" value="false" checked="checked">false<br/>
			<input type="submit" value="엔터">
	</form>
	<li>파일 업로드 
	<form action="webSocketFileUpload.jsp" method="get">
		
		<input type="submit" value="엔터">
	</form>
	<li>파일 다운로드 
	<form action="webSocketFileDownload.jsp" method="get">
		
		<input type="submit" value="엔터">
	</form>
	</ol>
</body>
</html>
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
		String method = request.getParameter("method");
		if(!method.equalsIgnoreCase("post")&&!method.equalsIgnoreCase("get")){
			//exception
	%>
	<h2>method는 post 또는 get만 된다.</h2>
	<% 
		}else{
			String cookieName = request.getParameter("cookieName");
			String cookieValue = request.getParameter("cookieValue");
			if(cookieName != "" && cookieValue != " "){
				Cookie cookie = new Cookie(request.getParameter("cookieName"), request.getParameter("cookieValue"));
				cookie.setPath("/");
				response.addCookie(cookie);
			}
	%>
	<h2>Session</h2>
	기존의 session id = <%=session.getId() %> <br>
	<% 		
			session.invalidate();
			session = request.getSession();
			String url = response.encodeURL("../../postParam");
	%>
	새로 생성된 session id = <%=session.getId() %> <br>
	changeSessionId() 로 변경한 session id = <%=request.changeSessionId() %> <br>
	
	<%
		String readObject = request.getParameter("readObject");
		String writeObject = request.getParameter("writeObject");
		String bufferSizeStr = request.getParameter("bufferSize");
		if(bufferSizeStr != ""){
			Integer bufferSize = Integer.parseInt(bufferSizeStr);	
			request.getServletContext().setAttribute("bufferSize", bufferSize);
		}
		String contentLengthStr = request.getParameter("contentLength");
	
		if(contentLengthStr != ""){
			Integer contentLength = Integer.parseInt(contentLengthStr);
			request.getServletContext().setAttribute("contentLength", contentLength);
		}
		request.getServletContext().setAttribute("readObject", readObject);
		request.getServletContext().setAttribute("writeObject", writeObject);
		
		
		
	%>
	<hr>
	<h2>Post Parameter</h2>
	<form action="<%=url %>" method="<%=method %>" >
	
		text: <input type="text" name="text"> <br/>
		checkbox: <input type="checkbox" name="checkbox" value="c1">c1
				  <input type="checkbox" name= "checkbox" value="c2">c2 <br/>
		textarea: <textarea cols ="30" rows ="10" name="textarea"></textarea> <br/>
		
		<input type="submit" value="완료">
		<input type="reset" value="다시작성">
	</form>
	<%
		}
	%>
</body>
</html>
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
	out.print("dispatch pool에서 시작함!<br>");
	out.print("<hr>6. static field<br>");
	out.print("static String ASYNC_CONTEXT_PATH: " + request.getAttribute(AsyncContext.ASYNC_CONTEXT_PATH) +"<br>");
	out.print("static String ASYNC_MAPPING: " + request.getAttribute(AsyncContext.ASYNC_MAPPING)+"<br>");
	out.print("static String ASYNC_PATH_INFO: " + request.getAttribute(AsyncContext.ASYNC_PATH_INFO)+"<br>");
	out.print("static String ASYNC_QUERY_STRING: " + request.getAttribute(AsyncContext.ASYNC_QUERY_STRING)+"<br>");
	out.print("static String ASYNC_REQUEST_URI: " + request.getAttribute(AsyncContext.ASYNC_REQUEST_URI)+"<br>");
	out.print("static String ASYNC_SERVLET_PATH: " + request.getAttribute(AsyncContext.ASYNC_SERVLET_PATH)+"<br>");

	int count = 1;
	for(long i = 1; i<120000000000l; i++) {
		if(i%(long)100000000 == 0){
			out.print((count++) + "<br>");
			out.flush();
		}
	}
%>
</body>
</html>
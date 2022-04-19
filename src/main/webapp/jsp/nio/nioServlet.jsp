<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>NIO Servlet이란?</h2>
	NIO Servlet이란 blocking 없이 데이터를 읽을 수 있거나 쓸 수 있는 Servlet이다.<br>
	Servlet3.1 이 후에 ReadListener와 WriteListener interface들이 추가되어 있는데, 각각 ServletInputStream과 ServletOutputStream에<br>
	등록하면 NIO를 사용할 수 있다.<br>
	NIO Servlet은 Async processing이거나 Http upgrade processing일 경우에만 가능하다.
	<br>
	여기서 ServletInputStream과 ServletOutputStream과 밀접한 관련이 있기 때문에 같이 보기로 한다. <br>
	<hr> 
	
	<h2>동작 방식</h2>
	먼저 ServletInputStream과 ServletOutputStream에 각 리스너들을 등록하지 않으면 NIO로 돌아가지 않는다.<br>
	ServletInputStream과 ServletOutputStream의 isReady() 메서드로 blocking 없이 read나 write할 수 있는지 알 수 있다. 
	<hr>
	
	<h2>관련 객체와 Method</h2>
		<ul>
			<li><b>ServletInputStream:</b>
				<ol>
					<li>abstract boolean isFinished()</li>
					<li>abstract boolean isReady()</li>
					<li>int readLine(byte[] b, int off, int len)</li>
					<li>abstract void setReadListener(ReadListener listener)</li>
				</ol>
			<li><b>ServletOutputStream:</b>
				<ol>
					<li>abstract boolean isReady()</li>
					<li>void print((primitive type || String))</li>
					<li>void println((Void || primitive type || String))</li>
					<li>abstract void setWriteListener(WriteListener listener)</li>
				</ol>
			<li><b>ReadListener:</b>
				<ol>
					<li>void onAllDataRead()</li>
					<li>void onDataAvailable()</li>
					<li>void onError(Throwable t)</li>
				</ol>
			<li><b>WriteListener:</b>
				<ol>
					<li>void onError(Throwable t)</li>
					<li>void onWritePossible()</li>
				</ol>		
		</ul>
	<hr>
	
	<jsp:include page="nioServletTest.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Async Servlet이란</h2>
		Async Servlet이란 비동기로 Servlet을 실행 할 수 있는 Servlet이다.<br>
		먼저, Async Servlet이란 것을 명시하기 위해서 web.xml에 &ltservlet&gt 하위에 &ltasync-supported&gt를 true라고 설정해야만 한다.<br>
		<br>
		Async Servlet은 filter와 servlet 둘 다 비동기를 처리할 수 있는 기능을 제공하며, 처음에는 ServletRequest.startAsync() 또는 <br>
		ServletRequest.startAsync(ServletRequest, ServletResponse)로 AsyncContext를 가져오면서 시작하게 된다.<br>
		<br>
		Async Servlet도 AsyncListener객체인 리스너를 통해 이벤트를 실행시킬 수 있는데, 다른 web listener와 다르게 web.xml와 @annotation으로<br>
		등록할 수 없고 오직 AsyncContext에서 addListener method로 등록할 수 있다.<br>
		<br>
		비동기 작업은 AsyncContext의 start() 메서드나 dispatch() 메서드로 시작하게 되며, start() 메서드로 시작할 경우에는 비동기 작업이 끝났다는 메서드인<br>
		AsyncContext의 complete()메서드를 호출해야한다.<br>
		만약, 비동기 처리가 끝나기 전에 timeout이 발생했을 경우에는 다음과 같은 과정을 진행한다.
		<ol>
			<li>ServletRequest에 등록된 모든 AsyncListener의 onTimeout을 발생시킨다.
			<li>아직 complete()이나 dispatch()메소드가 호출되지 않았으면, HttpServletResponse.SC_INTERNAL_SERVER_ERROR를 응답한다.
			<li>에러 페이지가 없거나, 에러 페이지에서 complete()이나 dispatch()메소드를 호출하지 않으면, complete()메소드를 호출해 준다.
		</ol>
		
	<hr>
	<h2>관련 객체와 Method</h2>
		<ul>
			<li><b>ServletRequet</b>: 
				<ol>
					<li>AsyncContext getAsyncContext()
					<li>boolean isAsyncStarted()
					<li>boolean isAsyncSupported()
					<li>AsyncContext startAsync()
					<li>AsyncContext startAsync(ServletRequest, ServletResponse)
				</ol>
			<li><b>AsyncContext</b>:
				<ol>
					<li>static String ASYNC_CONTEXT_PATH
					<li>static String ASYNC_MAPPING
					<li>static String ASYNC_PATH_INFO
					<li>static String ASYNC_QUERY_STRING
					<li>static String ASYNC_REQUEST_URI
					<li>static String ASYNC_SERVLET_PATH
					<li>void addListener(AsyncListener)
					<li>void addListener(AsyncListener, ServletRequest, ServletResponse)
					<li>&lt;T extends AsyncListener&gt; createListener(Class&lt;T&gt; clazz)
					<li>ServletRequest getRequest()
					<li>ServletResponse getResponse()
					<li>boolean hasOriginalRequestAndResponse()
					<li>void setTimeout(long timeout(ms))
					<li>long getTimeout()
					<li>void start(Runnable run)
					<li>void complete()
					<li>void dispatch()
					<li>void dispatch(ServletContext context, String path)
					<li>void dispatch(String path)
				</ol>
			<li><b>AsyncListener</b>:
				<ol>
					<li>void onComplete(AsyncEvent event)
					<li>void onError(AsyncEvent event)
					<li>void onStartAsync(AsyncEvent event)
					<li>void onTimeout(AsyncEvent event)
				</ol>
			<li><b>AsyncEvent</b>:
				<ol>
					<li>AsyncContext getAsyncContext()
					<li>ServletRequest getSuppliedRequest()
					<li>ServletResponse getSuppliedResponse()
					<li>Throwable getThrowable()
				</ol>
		</ul>
	
	<hr>
	<jsp:include page="asyncTest.jsp"/>
</body>
</html>
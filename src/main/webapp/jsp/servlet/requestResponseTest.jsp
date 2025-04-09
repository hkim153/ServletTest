<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request and Response Method</h2>
	<ul>
		<li>Server와 Client 정보 관련 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>	
						<li>String getServerName(): port이전의 ':'이전에 있는 host server name 또는 ip 주소
						<li>int getServerPort(): ':'이후에 있는 port 번호
						
						<li>String getLocalName(): 
						<li>String getLocalAddr()
						<li>int getLocalPort()	
						
						<li>String getRemoteAddr()
						<li>String getRemoteHost()
						<li>int getRemotePort()
						
						<li>Enumeration&lt;Locale&gt; getLocales()
						<li>Locale getLocale()
					</ol>
			</ul>
		<li>Request 관련 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>
						<li>String getScheme()
						<li>String getProtocol()
						<li>String getCharacterEncoding()
						<li>int getContentLength()
						<li>long getContentLengthLong()
						<li>String getContentType()
						<li>DispatcherType getDispatcherType()
						<li>ServletContext getServletContext()
					</ol>
				<li>HttpServletRequest: <br>
					<ol>
						<li>String getMethod()
						<li>String getContextPath()
						<li>String getServletPath()
						<li>String getPathInfo()
						<li>String getPathTranslated()
						<li>String getRequestURI()
						<li>StringBuffer getRequestURL()
					</ol>
			</ul>
		<li>Cookie 관련 method: <br>
			<ul>
				<li>HttpServletRequest: <br>
					<ol>
						<li>Cookie[] getCookies()
					</ol>
				<li>HttpServletResponse: <br>
					<ol>
						<li>void addCookie(Cookie cookie)
					</ol>
			</ul>
		<li>Session 관련 method: <br>
			<ul>
				<li>HttpServletRequest: <br>
					<ol>
						<li>String changeSessionId()
						<li>String getRequestedSessionId()
						<li>HttpSession getSession()
						<li>HttpSession getSession(boolean create)
						<li>boolean isRequestedSessionIdFromCookie()
						<li>boolean isRequestedSessionIdFromURL()
						<li>boolean isRequestedSessionIdValid()
					</ol>
				<li>HttpServletResponse: <br>
					<ol>
						<li>String encodeURL(String url)
					</ol>
			</ul>
		<li>읽고 쓰는 관련 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>
						<li>ServletInputStream getInputStream()
						<li>String getParameter(String name)
						<li>Map&lt;String ,String[]&gt; getParameterMap()
						<li>Enumeration&lt;String&gt; getParameterNames()
						<li>String[] getParameterValues(String name)
						<li>BufferedReader getReader()
						<li>void setCharacterEncoding(String env)
					</ol>
				<li>HttpServletRequest: <br>
					<ol>
						<li>String getQueryString()
					</ol>
				<li>ServletResponse: <br>
					<ol>
						<li>void flushBuffer()
						<li>int getBufferSize()
						<li>String getCharacterEncoding()
						<li>String getContentType()
						<li>ServletOutputStream getOutputStream()
						<li>PrintWriter getWriter()
						<li>boolean isCommitted()
						<li>void reset()
						<li>void resetBuffer()
						<li>void setBufferSize(int size)
						<li>void setCharacterEncoding(String charset)
						<li>void setContentLength(int len)
						<li>void setContentLengthLong(long len)
						<li>void setContentType(String type)
					</ol>
			</ul>
		<li>AsyncContext 관련 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>
						<li>AsyncContext getAsyncContext()
						<li>boolean isAsyncStarted()
						<li>boolean isAsyncSupported()
						<li>AsyncContext startAsync()
						<li>AsyncContext startAsync(ServletRequest servletRequest,
							ServletResponse servletResponse)
					</ol>
			</ul>
		<li>요청 재지정 관련 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>
						<li>RequestDispatcher getRequestDispatcher(String path)
						<li>Object getAttribute(String name)
						<li>Enumeration&lt;String&gt; getAttributeNames()
						<li>void removeAttribute(String name)
						<li>void setAttribute(String name, Object o)
					</ol>
				<li>HttpServletResponse: <br>
					<ol>
						<li>String encodeRedirectURL(String url)
						<li>void sendRedirect(String location)
					</ol>
			</ul>
		<li>헤더 관련 method: <br>
			<ul>
				<li>HttpServletRequest: <br>
					<ol>
						<li>long getDateHeader(String name)
						<li>String getHeader(String name)
						<li>Enumeration&lt;String&gt; getHeaderNames()
						<li>Enumeration&lt;String&gt; getHeaders(String name)
						<li>int getIntHeader(String name)
					</ol>
				<li>HttpServletResponse: <br>
					<ol>
						<li>void addDateHeader(String name, long date)
						<li>void addHeader(String name, String value)
						<li>void addIntHeader(String name, int value)
						<li>boolean containsHeader(String name)
						<li>String getHeader(String name)
						<li>Collection&lt;String&gt; getHeaderNames()
						<li>Collection&lt;String&gt; getHeaders(String name)
						<li>void setDateHeader(String name, long date)
						<li>void setHeader(String name, String value)
						<li>void setIntHeader(String name, int value)
					</ol>
			</ul>
		<li>그외 method: <br>
			<ul>
				<li>ServletRequest: <br>
					<ol>
						<li>boolean isSecure()
					</ol>
				<li>HttpServletRequest: <br>
					<ol>
						<li>String getRemoteUser()
						<li>boolean authenticate(HttpServletResponse response)
						<li>String getAuthType()
						<li>Part getPart(String name)
						<li>Collection&lt;Part&gt; getParts()
						<li>Principal getUserPrincipal()
						<li>boolean isUserInRole(String role)
						<li>void login(String username, String password)
						<li>void logout()
						<li>&lt;T extends HttpUpgradeHandler&gt; T upgrade(Class&lt;T&gt; handlerClass)
						<li>HttpServletMapping getHttpServletMapping()
						<li>PushBuilder newPushBuilder()
						<li>Map&lt;String,String&gt; getTrailerFileds()
						<li>boolean isTrailerFieldsReady()
					</ol>
				<li>ServletResponse: <br>
					<ol>
						<li>Locale getLocale()
						<li>void setLocale(Locale loc)
					</ol>
				<li>HttpServletResponse: <br>
					<ol>
						<li>int getStatus()
						<li>void sendError(int sc)
						<li>void sendError(int sc, String msg)
						<li>void setStatus(int sc)
						<li>void setTrailerFields(Supplier&lt;Map&lt;String,String&gt;&gt; supplier)
						<li>Supplier&lt;Map&lt;String,String&gt;&gt; getTrailerFields()
					</ol>
			</ul>
	</ul>
	
	<hr>
	<h2>Test</h2>
</body>
</html>
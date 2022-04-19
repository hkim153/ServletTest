<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h2>HttpServlet 상속도</h2>
	<img src="../../img/httpServlet.png" alt="http servlet">
 <hr/>
 <h2>Method</h2>
	<ul>
		<li><b>Servlet</b>: <br/>
			 <ol>
 				<li>void init(ServletConfig) 
 				<li>void service(ServletRequest, ServletResponse)
 				<li>void destroy()
 				<li>ServletConfig getServletConfig()
 				<li>String getServletInfo() <br>
 				해당 메소드 오버라이드 해서 쓴다.
 			</ol>
		</li>
		<li><b>ServletConfig</b>: <br/>
			 <ol>
 				<li>String getInitParameter(String name)
 				<li>Enumeration String getInitParameterNames()
 				<li>ServletContext getServletContext()
 				<li>String getServletName() <br>
 					&lt;servlet-name&gt;에 정의되어 있는 것
 			</ol>
		</li>
		<li><b>GenericServlet</b>: <br/>
			 <ol>
 				<li>void init()
 				<li>void log(String msg)
 				<li>void log(String msg, Throwable)
 			</ol>
		</li>
		<li><b>HttpServlet</b>: <br/>
			 <ol>
 				<li>void doGet(HttpServletRequest, HttpServletResponse)
 				<li>void doPost(HttpServletRequest, HttpServletResponse)
 				<li>void service(HttpServletRequest, HttpServletResponse)
 				<li>그외 http method
 				<li>long getLastModified(HttpServletRequest)
 			</ol>
		</li>
	</ul>
 <hr>
 <h2>서블릿 실행과정</h2>
 <img src="../../img/servletFlow.png" alt="servlet flow">
 <h2>Test</h2>
 <a href="../../httpServletTest">서블릿 호출하기</a>
 
 
</body>
</html>
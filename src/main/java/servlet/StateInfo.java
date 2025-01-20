package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StateInfo extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		
		String stateObject = req.getParameter("stateObject");
		if(stateObject == null){
			out.print("하나를 선택해 주세요! <br/>");
			out.print("<a href=html/stateInfo.html>뒤로가기</a>");
		}else if(stateObject.equals("ServletContext")){
			SharedObject sharedObject = new SharedObject();
			sharedObject.setCount(1);
			sharedObject.setName("ServletContext에 저장한 객체");
			ServletContext sc = req.getServletContext();
			sc.setAttribute("ServletContext", sharedObject);
			
			out.print("<ol>\n" + 
					"		<li>Context Param</li>\n" + 
					"		<li>application info</li>\n" + 
					"		<li>Attribute</li>\n" + 
					"	</ol>\n" + 
					"	<hr>\n" + 
					"	<h3>Shared Object 객체 생성 후 ServletContext에 객체 저장</h3>\n" + 
					"	ServletContext sc = request.getServletContext(); <br/>\n" + 
					"		sc.setAttribute(\"ServletContext\", sharedObject); <br/><hr>\n" + 
					"	<a href=\"servletContextTest\">ServletContext Test Start...</a>");
		}else if(stateObject.equals("Cookie")){
			out.print("<h2>Cookie 란?</h2>\n" + 
					"	서버가 클라이언트에 저장하는 정보, 저장할 데이터의 타입은 String이고 데이터 크기에 제한이 있다.\n" + 
					"	name=value의 형태이고 필요에 따라 쿠키의 유지 시간, 유효 디렉토리, 유효 도메인 등 지정 가능\n" + 
					"	<hr>\n" + 
					"	<h2>Cookie Method</h2>\n" + 
					"	<ol>\n" + 
					"		<li>Constructor: <b>Cookie(String name, String value)  </b></li>\n" + 
					"		<li>getter와 setter\n" + 
					"			<ul>\n" + 
					"				<li>Comment: 쿠키 설명</li>\n" + 
					"				<li>Domain: 쿠키가 전달되는 유효 서버 </li>\n" + 
					"				<li>MaxAge: 유지 시간 in seconds</li>\n" + 
					"				<li>Name</li>\n" + 
					"				<li>Value</li>\n" + 
					"				<li>Path: 쿠키가 전달되는 유효 경로 지정, 지정을 해야 해당 path에 쿠키가 보인다. 무조건 지정하라고 API에 나와 있다. </li>\n" + 
					"				<li>Secure: HTTPS나 SSL일 경우에만 쿠키가 보내짐</li>\n" + 
					"				<li>Version</li>\n" + 
					"				<li>HttpOnly</li>\n" + 
					"			</ul>\n" + 
					"		</li>\n" + 
					"	</ol>\n" + 
					"	<hr>\n" + 
					"	<h2>쿠키 전송과 추출</h2>\n" + 
					"	<ol>\n" + 
					"		<li>쿠키 전송: HttpServletResponse객체의 <b>void addCookie(Cookie cookie)</b> 메소드를 이용해서 클라이언트에 보낸다.</li>\n" + 
					"		<li>쿠키 추출: HttpServletRequest객체의 <b>Cookies[] getCookies()</b> 메소드를 이용해서 가져온다.</li>\n" + 
					"	</ol>\n" + 
					"	<hr>\n" + 
					"	<h2>TEST</h2>\n" + 
					"	<form action=\"jsp/cookieTestStart.jsp\" method=\"post\">\n" + 
					"		name:  <input type=\"text\" name=\"name\"><br>\n" + 
					"		value: <input type=\"text\" name=\"value\"><br>\n" + 
					"		Path: <input type=\"text\" name=\"path\"><br>\n" + 
					"		Domain: <input type=\"text\" name=\"domain\"><br>\n" + 
					"		Comment: <input type=\"text\" name=\"comment\"><br>\n" + 
					"		MaxAge: <input type=\"text\" name=\"maxAge\"><br>\n" + 
					"		Secure: <input type=\"text\" name=\"comment\"><br>\n" + 
					"		Version: <input type=\"text\" name=\"version\"><br>\n" + 
					"		HttpOnly:<br>\n" + 
					"		<input type=\"submit\" value=\"start\">\n" + 
					"	</form>");
		}else if(stateObject.equals("Session")){
			out.print("<h2>Session이란?</h2>\n" + 
					"	클라이언트가 서버에 정보를 요청할 때 생성되는 상태정보<br/>\n" + 
					"	생성된 Session id 는 쿠키 기술로 클라이언트에 저장(JSessionId)<br/>\n" + 
					"	클라이언트마다 상태정보를 일정 시간 동안 개별적으로 유지하여 사용하는 기술을 세션 트래킹이라고 함 <br/>\n" + 
					"	\n" + 
					"	<hr>\n" + 
					"	<h2>HttpSession 생성</h2>\n" + 
					"	HttpServletRequest의 메소드로 생성\n" + 
					"	<ol>\n" + 
					"		<li><b>HttpSession getSession()</b> : <br/>클라이언트가 가지고 있는 Session ID와 동일한 세션 객체를 찾아서 반환 없으면 새로 생성하여 반환</li>\n" + 
					"		<li><b>HttpSession getSession(boolean create)</b> : <br/>getSession()와 같지만 새로 생성할 때 create값이 true일 때 생성하고 false이면 null 반환</li>\n" + 
					"	</ol>\n" + 
					"	<hr>\n" + 
					"	<h2>HttpSession 메소드</h2>\n" + 
					"	<ol>\n" + 
					"		<li><b>Object getAttribute(String name)</b> : <br/></li>\n" + 
					"		<li><b>Enumberation< String > getAttributeNames()</b> : <br/></li>\n" + 
					"		<li><b>void removeAttribute(String name)</b> : <br/></li>\n" + 
					"		<li><b>void setAttribute(String name, Object value)</b> : <br/></li>\n" + 
					"		<li><b>long getCreationTime()</b> : <br/></li>\n" + 
					"		<li><b>String getId()</b> : <br/>Session id 반환</li>\n" + 
					"		<li><b>long getLastAccessedTime()</b> : <br/></li>\n" + 
					"		<li><b>void setMaxInactiveInterval(int interval)</b> : <br/>\n" + 
					"		HttpSession 객체의 유지 시간을 설정 in seconds\n" + 
					"		</li>\n" + 
					"		<li><b>int getMaxInactiveInterval()</b> : <br/></li>\n" + 
					"		<li><b>ServletContext getServletContext()</b> : <br/></li>\n" + 
					"		<li><b>void invalidate()</b> : <br/>현재 session 삭제</li>\n" + 
					"		<li><b>boolean isNew()</b> : <br/>\n" + 
					"		서버 측에서 새로운 HttpSession을 생성했으면 true 기존 세션이 유지되고 있으면 false</li>\n" + 
					"	</ol>\n" + 
					"	<hr>\n" + 
					"	<h2>HttpSession Test</h2>\n" + 
					"	<a href=\"httpSessionCreate\">HttpSession Test Start...</a>");
		}else if(stateObject.equals("HttpServletRequest")){
			out.print("<h2>HttpServletRequest의 상태 정보 유지 기술</h2>\n" + 
					"	HttpServletRequest는 하나의 요청에서 생성되고 소멸되는 객체지만, 하나의 요청이 여러 페이지로 이루어 질 때\n" + 
					"	여러 페이지 간에 정보를 공유하는 역할을 한다.<br/>\n" + 
					"	이 때, 요청 재지정 된 페이지로 넘어 갈 때 HttpServletRequest와 HttpServletResponse 객체를 넘겨주기 때문에,\n" + 
					"	요청 재지정 하기 전에 HttpServletRequest에 상태 정보를 저장한 후에 넘긴다.\n" + 
					"	<img src=\"resource/img/requestDispatcherFlow.png\" alt=\"requestDispatcher Flow\">\n" +
					"	<hr>\n" + 
					"	<h2>요청 재지정 기능을 제공하는 객체</h2>\n" + 
					"	2개의 객체가 있다.\n" + 
					"	<ol>\n" + 
					"		<li><b>HttpServletResponse</b> : 현재 서버가 아닌 다른 서버의 자원으로도 이동 가능, HttpServletReqeust HttpServletResponse 재생성 <br/>\n" + 
					"			<img src=\"resource/img/sendRedirect.png\" alt=\"sendRedirect.png\"><br/>\n" +
					"			<ul>\n" + 
					"				<li>void sendRedirect(String location) : location 설정된 자원으로 요청을 재지정한다</li>\n" + 
					"				<li>String encodeRedirectURL(String url) : url에 설정된 URL 문자열에 '쿠키를 사용할 수 없을 때 그리고 다른 서버가 아닐 때' session id정보를 추가하여 반환한다. sendRedirect의 parameter로 사용되어 요청을 재지정한다</li>\n" + 
					"			</ul>\n" + 
					"		</li>\n" + 
					"		<li><b>RequestDispatcher</b> : 현재 자원과 동일한 웹 애플리케이션 내에서만 이동 가능, HttpServletReqeust HttpServletResponse 재사용 <br/>\n" + 
					"			<img src=\"resource/img/requestDispatcher.png\" alt=\"requestDispatcher.png\"><br/>\n" +
					"			<ul>\n" + 
					"				<li>void include(ServletRequest request, ServletResponse response) : 다른 자원의 처리 결과를 현재 페이지에 포함한다.</li>\n" + 
					"				<li>void forward(ServletRequest request, ServletResponse response) : 요청을 다른 자원으로 넘긴다.\n" + 
					"			</ul>\n" + 
					"			<b>RequestDispatcher 객체 생성</b><br/>\n" + 
					"			<ul>\n" + 
					"				<li>ServletContext 객체에서 제공하는 메서드 <br/>\n" + 
					"					<ul>\n" + 
					"						<li>RequestDispatcher getNamedDispatcher(String name) : 자원의 이름으로 요청을 재지정 할 RequestDispatcher 반환 \n" + 
					"						<li>RequestDispatcher getRequestDispatcher(String path) : 자원의 위치(절대 경로만 가능 무조건 \"/\"로 시작)로 요청을 재지정 할 RequestDispatcher 반환 \n" + 
					"					</ul>\n" + 
					"				</li>\n" + 
					"				<li>ServletRequest 객체에서 제공하는 메서드\n" + 
					"					<ul>\n" + 
					"						<li>RequestDispatcher getRequestDispatcher(String path) : 자원의 위치(절대 + 상대 경로 가능)로 요청을 재지정 할 RequestDispatcher 반환 \n" + 
					"					</ul>\n" + 
					"				</li>\n" + 
					"			</ul>\n" + 
					"		</li>\n" + 
					"	</ol>	\n" + 
					"	\n" + 
					"	<b>주의할 점!!!</b>\n" + 
					"	sendRedirect와 forward는 response가 commited 되기 전에 불려야 한다!\n" + 
					"	\n" + 
					"	<hr>\n" + 
					"	<h2>HttpServletRequest의 상태 정보 저장</h2>\n" + 
					"	<ul>\n" + 
					"		<li>Object getAttribute(String name)</li>\n" + 
					"		<li>Enumeration  String  getAttributeNames()</li>\n" + 
					"		<li>void removeAttribute(String name)</li>\n" + 
					"		<li>void setAttribute(Stirng name, Object value)</li>\n" + 
					"	</ul>\n" + 
					"\n" + 
					"	<hr>\n" + 
					"	<h2>HttpServletResponse Test</h2>\n" + 
					"	<form action=\"sendRedirectTest\" method=\"post\">\n" + 
					"		메서드 : \n" + 
					"		<input type=\"radio\" name=\"method\" value=\"sendRedirect\">sendRedirect\n" + 
					"		<input type=\"radio\" name=\"method\" value=\"encodeRedirectURL\">encodeRedirectURL <br/>\n" + 
					"		사이트 :\n" + 
					"		<input type=\"radio\" name=\"site\" value=\"naver\">네이버\n" + 
					"		<input type=\"radio\" name=\"site\" value=\"attribute\">encodeRedirectURL 확인하기 위한 서버 내 자원<br/>\n" + 
					"		<pre>       <input type=\"submit\" value=\"이동\" style=\"width:250px\"></pre>\n" + 
					"	</form>\n" + 
					"	\n" + 
					"	<hr>\n" + 
					"	<h2>RequestDispatcher Test</h2>\n" + 
					"	<form action=\"requestDispatcherTest\" method=\"post\">\n" + 
					"		RequestDispatcher 가져 올 객체 : \n" + 
					"		<input type=\"radio\" name=\"object\" value=\"servletContext\">ServletContext\n" + 
					"		<input type=\"radio\" name=\"object\" value=\"servletRequest\">ServletRequest <br/>\n" + 
					"		가져 올 방식 : \n" + 
					"		<input type=\"radio\" name=\"getMethod\" value=\"name\">name\n" + 
					"		<input type=\"radio\" name=\"getMethod\" value=\"path\">path <br/>\n" + 
					"		name 또는 path (/requestDispatcherTestResult) : \n" + 
					"		<input type=\"text\" name=\"path\"><br/>\n" + 
					"		방식 : \n" + 
					"		<input type=\"radio\" name=\"method\" value=\"include\">include\n" + 
					"		<input type=\"radio\" name=\"method\" value=\"forward\">forward<br/>\n" + 
					"		<pre>       <input type=\"submit\" value=\"이동\" style=\"width:250px\"></pre>\n" + 
					"	</form>");
		}
	}

}

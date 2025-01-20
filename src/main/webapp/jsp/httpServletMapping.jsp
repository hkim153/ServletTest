<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>HttpServletMapping이란</h2>
	HttpServletMapping이란 HttpServletRequest의 HttpServlet이 호출된 맵핑 정보를 알려주는 객체이다</br>
	web.xml에서 &ltservlet-mapping&gt에서 &lturl-pattern&gt를 여러개 설정할 수 있는데</br>
	현재 servlet page를 호출한 url에서 어떤 맵핑으로 인해 HttpServlet이 호출 되었는지에 대한 정보를 얻을 수 있다.</br></br>
	
	예를 들어,</br>
	아래의 그림과 같이 web.xml에 Servlet이 정의되어 있고, </br>
	<img src="../resource/img/httpServletMapping1.png" alt="httpServletMapping in web.xml"></br></br>
	
	해당 HttpServlet을 호출하기 위해서 다양한 url로 호출했다면, 다음과 같은 결과를 얻을 수 있다.</br></br>
	<img src="../resource/img/httpServletMapping2.png" alt="httpServletMapping Result"></br></br>
	<hr>
	
	<h2>MappingMatch</h2>
	MappingMatch는 jakarta에서 정의한 Enum 객체로서,호출된 url과 servlet사이의 맵핑 타입을 설명해준다.</br>
	<ol>
		<li>CONTEXT_ROOT: 앱의 context root와 url이 매치될 때
		<li>DEFAULT: url이 '/'로 Servlet이랑 매치될 때
		<li>EXACT: 호출 된 url이 url-pattern과 일치할 때
		<li>EXTENSION: url-pattern이 "*.extension" 처럼 extension 맞아서 매치될 때
		<li>PATH: url이 url-pattern의 path중 일부분일 때 
	</ol>
	CONTEXT_ROOT: 
	
	<hr>
	
	<h2>관련 객체와 Method</h2>
	<ol>
		<li>HttpServletRequest
			<ul>
				<li><b>default HttpServletMapping getHttpServletMapping()</b>: 현재 HttpServletRequest의 HttpServlet이 호출된 HttpServletMapping을 반환한다.</li>
			</ul>
		</li>
		<li>
			<ul>
				<li><b>MappingMatch getMappingMatch()</b>: MappingMatch를 반환한다</li>
				<li><b>String getMatchValue()</b>: 호출한 url이 왜 해당 HttpServlet으로 호출했는지에 대한 근거 값을 반환한다.</br>
					CONTEXT_ROOT와 DEFAULT는 empty string을 반환하고,</br>
					EXACT는 앞에 slash를 제거한 url를 반환하고,</br>
					EXTENSION과 PATH는 '*'에 들어간 value를 반환한다. 
				</li>
				<li><b>String getPattern()</b>: url이 매칭된 &lturl-pattern&gt를 반환한다. 대신 CONTEXT_ROOT일 경우에는 empty string으로, EXTENSION일 경우에는 앞에 slash를 제거하고 출력한다. </li>
				<li><b>String getServletName()</b>: &ltservlet-name&gt에서 정의한 Servlet 이름을 반환한다 </li>
			</ul>
		</li>
	</ol>
	<hr>
	
	<h2>HttpServletMapping Test</h2>
	기본 test 시작은 /httpServletMappingTest로 호출되어 있다.</br>
	web.xml에 정의되어 있는 url-pattern으로 여러가지 test해 본다.</br>
	/path/*</br>
	*.extension</br>
	
	<a href="../httpServletMappingTest">Test Start</a>
</body>
</html>
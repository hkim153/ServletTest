<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration이란</h2>
	<img src="../../resource/img/registration.png" alt="Registration Hierarchy"><br>
	Registration 객체는 web.xml에 정의되어 컨테이너에 등록된 Servlet과 Filter정보를 가져올 수 있는 객체이다.<br>
	ServletContext에서 getServletRegistration(String servletName) 또는 getFilterRegistration(String filterName)으로<br>
	각각의 Registration을 가져와서 web.xml에서 추가할 수 있는 정보들을 해당 객체로 통해 할 수 있게 된다.(ex.addMapping(String urlPatterns))<br>
	<br>
	ServletContext은 Servlet과 Filter를 web.xml 또는 Annotation으로 등록하는 방식이 아닌 동적으로 등록할 수 있는 addServlet 또는 addFilter 메소드가 있는데<br>
	해당 메소드들의 반환값은 Registration.Dynamic으로 추가적으로 동적으로 정보들을 추가할 수 있는 객체이다.<br>
	
	<hr>
	<h2>관련 객체와 Method</h2>
	<ul>
		<li><b>ServletContext:</b>
			<ol>
				<li>FilterRegistraion.Dynamic addFilter(String filterName, Class&lt? extends Filter&gt filterClass)</li>
				<li>FilterRegistraion.Dynamic addFilter(String filterName, Filter filter)</li>
				<li>FilterRegistraion.Dynamic addFilter(String filterName, String className)</li>
				<li>ServletRegistration.Dynamic addJspFile(String servletName, String jspFile)</li>
				<li>ServletRegistration.Dynamic addServlet(String servletName, Class&lt? extends Servlet&gt servletClass)</li>
				<li>ServletRegistration.Dynamic addServlet(String servletName, Servlet servelt)</li>
				<li>ServletRegistration.Dynamic addServlet(String servletName, String className)</li>
				<li>&ltT extends Filter&gt createFilter(Class&ltT&gt clazz)</li>
				<li>&ltT extends Servlet&gt createServlet(Class&ltT&gt clazz)</li>
				<li>FilterRegistration getFilterRegistration(String filterName)</li>
				<li>Map&ltString, ? extends FilterRegistration&gt getFilterRegistrations()</li>
				<li>ServletRegistraion getServletRegistration(String servletName)</li>
				<li>Map&ltString, ? extends ServletRegistration&gt getServletRegistrations()
			</ol>
		</li>
		<li><b>Registration:</b>
			<ol>
				<li>String getClassName()</li>
				<li>String getInitParameter(String name)</li>
				<li>Map&ltString, String&gt getInitParameters()</li>
				<li>String getName()</li>
				<li>boolean setInitParameter(String name, String value)
				<li>Set&ltString&gt setInitParameters(Map&ltString, String&gt initParameters)
			</ol>
		<li><b>Registration.Dynamic:</b>
			<ol>
				<li>void setAsyncSupported(boolean isAsyncSupported)
			</ol>
		<li><b>FilterRegistration:</b>
			<ol>
				<li>void addMappingForServletNames(EnumSet&ltDispatcherType&gt dispatcherTypes, boolean isMatchAfter, String... servletNames)</li>
				<li>void addMappingForUrlPatterns(EnumSet&ltDispatcherType&gt dispatcherTypes, boolean isMatchAfter, String... urlPatterns)</li>
				<li>Collection&ltString&gt getServletNameMappings()</li>
				<li>Collection&ltString&gt getUrlPatternMappings()</li>
			</ol>
		<li><b>FilterRegistraion.Dynamic:</b>
		<li><b>ServletRegistration:</b>
			<ol>
				<li>Set&ltString&gt addMapping(String... urlPattenrs)</li>
				<li>Collection&ltString&gt getMappings()</li>
				<li>String getRunAsRole()</li>
			</ol>
		<li><b>ServletRegistration.Dynamic:</b>
			<ol>
				<li>void setLoadOnStartup(int loadOnStartup)</li>
				<li>void setMultipartConfig(MultipartConfigElement multipartConfig)</li>
				<li>void setRunAsRole(String roleName)</li>
				<li>Set&ltString&gt setServletSecurity(ServletSecurityElement constraint)</li>
			</ol>
	</ul>
	<hr>
	<jsp:include page="registrationTest.jsp"/>
</body>
</html>
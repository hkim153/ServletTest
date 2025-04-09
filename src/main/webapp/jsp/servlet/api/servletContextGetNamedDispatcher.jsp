<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 9/11/24
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletContext: RequestDispatcher getNamedDispatcher(String name)</title>
</head>
<body>

<h1><a href="../../../html/servlet/servletPackageApi.html">jakarta.servlet</a></h1>
<h1><a href="servletContext.jsp">ServletContext</a></h1>
<h1>public RequestDispatcher getNamedDispatcher(String name)</h1>
<hr>

<h1>Doc</h1>
<p>
    Returns a {@link RequestDispatcher} object that acts
    as a wrapper for the named servlet.
</p>
<p>
    Servlets (and JSP pages also) may be given names via server
    administration or via a web application deployment descriptor.<br>
    A servlet instance can determine its name using
    {@link ServletConfig#getServletName}.
</p>
<p>
    This method returns <code>null</code> if the
    <code>ServletContext</code>
    cannot return a <code>RequestDispatcher</code> for any reason.
    <br>
    @param name a <code>String</code> specifying the name
    of a servlet to wrap
    <br>
    @return a <code>RequestDispatcher</code> object
    that acts as a wrapper for the named servlet,
    or <code>null</code> if the <code>ServletContext</code>
    cannot return a <code>RequestDispatcher</code>
    <br>
    @see RequestDispatcher <br>
    @see ServletContext#getContext <br>
    @see ServletConfig#getServletName
</p>

<h1>Test</h1>
<ul>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetNamedDispatcherTest?name=ForwardedServlet">name에 해당하는 리소스가 있는 경우</a></dt>
            <dd>기본 동작으로 name에 해당하는 resource에 forward를 시도한다.</dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetNamedDispatcherTest?name=unknown">name에 해당하는 리소스가 없는 경우</a></dt>
            <dd>name에 해당하는 resource가 없는 경우에는 null을 return한다.</dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetNamedDispatcherTest">name이 null일 경우</a></dt>
            <dd>name이 null일 경우에는 null을 return한다.</dd>
        </dl>
    </li>
</ul>

</body>
</html>

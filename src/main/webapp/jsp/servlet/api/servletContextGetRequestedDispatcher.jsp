<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 9/11/24
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletContext: RequestDispatcher getRequestDispatcher(String path)</title>
</head>
<body>

<h1><a href="../../../html/servlet/servletPackageApi.html">jakarta.servlet</a></h1>
<h1><a href="servletContext.jsp">ServletContext</a></h1>
<h1>public RequestDispatcher getRequestDispatcher(String path)</h1>
<hr>

<h1>Doc</h1>
<p>
    Returns a {@link RequestDispatcher} object that acts
    as a wrapper for the resource located at the given path.<br>
    A <code>RequestDispatcher</code> object can be used to forward
    a request to the resource or to include the resource in a response.<br>
    The resource can be dynamic or static.<br>
</p>
<p>
    The pathname must begin with a <code>/</code> and is interpreted as
    relative to the current context root.<br> Use <code>getContext</code>
    to obtain a <code>RequestDispatcher</code> for resources in foreign
    contexts.<br>
</p>
<p>
    This method returns <code>null</code> if the
    <code>ServletContext</code> cannot return a
    <code>RequestDispatcher</code>.
    <br>
    @param path a <code>String</code> specifying the pathname
    to the resource
    <br>
    @return a <code>RequestDispatcher</code> object
    that acts as a wrapper for the resource
    at the specified path, or <code>null</code> if
    the <code>ServletContext</code> cannot return
    a <code>RequestDispatcher</code>
    <br>
    @see RequestDispatcher <br>
    @see ServletContext#getContext <br>
</p>
<hr>

<h1>Test</h1>
<ul>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetRequestDispatcherTest?path=forwardedServlet&hasSlash=true">path에 해당하는
                리소스가 있고, 앞에 slash를 붙일 경우</a></dt>
            <dd><p>기본 동작으로 "/" + path에 해당하는 resource에 forward를 시도한다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetRequestDispatcherTest?path=forwardedServlet&hasSlash=false">path에 해당하는
                리소스가 있고, 앞에 slash를 안 붙일 경우</a></dt>
            <dd><p>path 앞에 slash가 없는 경우를 테스트한다. Tomcat은 500응답을, JEUS는 slash를 붙여주어서 찾는다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetRequestDispatcherTest?path=unknown&hasSlash=true">path에 해당하는 리소스가 없을
                경우</a>
            </dt>
            <dd><p>path에 해당하는 리소스가 없는 경우에는 404 응답을 내보낸다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletContextGetRequestDispatcherTest">path가 null일 경우</a></dt>
            <dd><p>path가 null인 경우에는 null을 return한다.</p></dd>
        </dl>
    </li>
</ul>

</body>
</html>

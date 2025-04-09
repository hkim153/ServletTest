<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 9/12/24
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletRequest: RequestDispatcher getRequestDispatcher(String path)</title>
</head>
<body>

<h1><a href="../../../html/servlet/servletPackageApi.html">jakarta.servlet</a></h1>
<h1><a href="servletRequest.jsp">ServletRequest</a></h1>
<h1>public RequestDispatcher getRequestDispatcher(String path)</h1>
<hr>

<h1>Doc</h1>
<p>
    Returns a {@link RequestDispatcher} object that acts as a wrapper for
    the resource located at the given path.<br>
    A <code>RequestDispatcher</code> object can be used to forward
    a request to the resource or to include the resource in a response.
    The resource can be dynamic or static.
</p>
<p>
    The pathname specified may be relative, although it cannot extend
    outside the current servlet context.<br> If the path begins with
    a "/" it is interpreted as relative to the current context root.
    This method returns <code>null</code> if the servlet container
    cannot return a <code>RequestDispatcher</code>.
</p>
<p>
    The difference between this method and {@link
    ServletContext#getRequestDispatcher} is that this method can take a
    relative path.
</p>
<p>
    @param path a <code>String</code> specifying the pathname
    to the resource. If it is relative, it must be
    relative against the current servlet.
    <br>
    @return a <code>RequestDispatcher</code> object that acts as a
    wrapper for the resource at the specified path,
    or <code>null</code> if the servlet container cannot
    return a <code>RequestDispatcher</code>
    <br>
    @see RequestDispatcher<br>
    @see ServletContext#getRequestDispatcher
</p>
<hr>

<h1>Test</h1>
<ul>
    <li>
        <dl>
            <dt><a href="../../../servletRequestGetRequestDispatcherTest?path=forwardedServlet&hasSlash=true">path에 해당하는
                리소스가 있고, 앞에 slash를 붙일 경우, absolute path로 테스트</a></dt>
            <dd><p>기본 동작으로 "/" + path에 해당하는 resource에 forward를 시도한다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletRequestGetRequestDispatcherTest?path=forwardedServlet&hasSlash=false">path에 해당하는
                리소스가 있고, 앞에 slash를 안 붙일 경우, relative path로 테스트</a></dt>
            <dd><p>path 앞에 slash가 없는 경우를 테스트한다. Tomcat은 500응답을, JEUS는 slash를 붙여주어서 찾는다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletRequestGetRequestDispatcherTest?path=unknown&hasSlash=true">path에 해당하는 리소스가 없을
                경우</a>
            </dt>
            <dd><p>path에 해당하는 리소스가 없는 경우에는 404 응답을 내보낸다.</p></dd>
        </dl>
    </li>
    <li>
        <dl>
            <dt><a href="../../../servletRequestGetRequestDispatcherTest">path가 null일 경우</a></dt>
            <dd><p>path가 null인 경우에는 null을 return한다.</p></dd>
        </dl>
    </li>
</ul>

</body>
</html>

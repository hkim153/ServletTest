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
    <title>Title</title>
</head>
<body>

<h1><a href="">jakarta.servlet.ServletContext</a></h1>
<h2>public RequestDispatcher getRequestDispatcher(String path)</h2>

<p>
Returns a {@link RequestDispatcher} object that acts
as a wrapper for the resource located at the given path.
A <code>RequestDispatcher</code> object can be used to forward
a request to the resource or to include the resource in a response.
The resource can be dynamic or static.
</p>
<p>The pathname must begin with a <code>/</code> and is interpreted as
    relative to the current context root. Use <code>getContext</code>
    to obtain a <code>RequestDispatcher</code> for resources in foreign
    contexts.
</p>

<p>This method returns <code>null</code> if the
    <code>ServletContext</code> cannot return a
    <code>RequestDispatcher</code>.

    @param path a <code>String</code> specifying the pathname
    to the resource

    @return a <code>RequestDispatcher</code> object
    that acts as a wrapper for the resource
    at the specified path, or <code>null</code> if
    the <code>ServletContext</code> cannot return
    a <code>RequestDispatcher</code>

    @see RequestDispatcher
    @see ServletContext#getContext
</p>

<h1>Test</h1>
<ul>
    <li><a href=""></a></li>
</ul>

</body>
</html>

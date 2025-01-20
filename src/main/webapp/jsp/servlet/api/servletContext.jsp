<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 9/11/24
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletContext</title>
</head>
<body>

<h1>Package <a href="../../../html/servlet/servletPackageApi.html">jakarta.servlet</a></h1>
<h1>ServletContext</h1>
<hr>

<h1>Doc</h1>
<p>
    Defines a set of methods that a servlet uses to communicate with its
    servlet container, for example, to get the MIME type of a file,
    dispatch requests, or write to a log file.
</p>
<p>
    There is one context per "web application" per Java Virtual Machine. (A
    "web application" is a collection of servlets and content installed under a
    specific subset of the server's URL namespace such as <code>/catalog</code>
    and possibly installed via a <code>.war</code> file.)
</p>
<p>
    In the case of a web
    application marked "distributed" in its deployment descriptor, there will
    be one context instance for each virtual machine. In this situation, the
    context cannot be used as a location to share global information (because
    the information won't be truly global). Use an external resource like
    a database instead.
</p>
<p>
    The <code>ServletContext</code> object is contained within
    the {@link ServletConfig} object, which the Web server provides the
    servlet when the servlet is initialized.

    @author Various

    @see Servlet#getServletConfig
    @see ServletConfig#getServletContext
</p>
<h2>Field Summary</h2>
<p>
    The name of the <tt>ServletContext</tt> attribute which stores
    the private temporary directory (of type <tt>java.io.File</tt>)
    provided by the servlet container for the <tt>ServletContext</tt>

    public static final String TEMPDIR = "jakarta.servlet.context.tempdir";
</p>
<p>
    The name of the <code>ServletContext</code> attribute whose value
    (of type <code>java.util.List&lt;java.lang.String&gt;</code>) contains
    the list of names of JAR files in <code>WEB-INF/lib</code> ordered by
    their web fragment names (with possible exclusions if
    <code>&lt;absolute-ordering&gt;</code> without any
    <code>&lt;others/&gt;</code> is being used), or null if no
    absolute or relative ordering has been specified

    public static final String ORDERED_LIBS = "jakarta.servlet.context.orderedLibs";
</p>

<h2>Method Summary</h2>
<ul>
    <li><a href="servletContextGetRequestedDispatcher.jsp">public RequestDispatcher getRequestDispatcher(String path)</a></li>
    <li><a href="servletContextGetNamedDispatcher.jsp">public RequestDispatcher getNamedDispatcher(String name)</a></li>
</ul>
<hr>

<h1>Test</h1>

</body>
</html>

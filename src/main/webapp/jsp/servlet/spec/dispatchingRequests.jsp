<%--
  Created by IntelliJ IDEA.
  User: hyunsoo
  Date: 9/11/24
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>9. Dispatching Requests</title>
</head>
<body>
Relevant API
<ul>
    <li><a href="../api/requestDispatcher.jsp">jakarta.servlet.RequestDispatcher</a></li>
    <li><a href="../api/servletContextGetRequestedDispatcher.jsp">jakarta.servlet.ServletContext public
        RequestDispatcher getRequestDispatcher(String path)</a></li>
</ul>

<a href="https://jakarta.ee/specifications/servlet/5.0/jakarta-servlet-spec-5.0#dispatching-requests">link</a>

<h2>9. Dispatching Requests</h2>

<p>When building a web application, it is often
    useful to forward processing of a request to another servlet, or to
    include the output of another servlet in the response. The
    <code>RequestDispatcher</code> interface provides a mechanism to accomplish this.</p>
<p>When asynchronous processing is enabled on
    the request, the <code>AsyncContext</code> allows a user to dispatch the request
    back to the servlet container.</p>

<h3>9.1. Obtaining a RequestDispatcher</h3>
<p>An object implementing the <code>RequestDispatcher</code>
    interface may be obtained from the <code>ServletContext</code> via the following
    methods:</p>

<ul>
    <li>
        <p><code>getRequestDispatcher</code></p>
    </li>
    <li>
        <p><code>getNamedDispatcher</code></p>
    </li>
</ul>

<p>The <code>getRequestDispatcher</code> method takes a
    <code>String</code> argument describing a path within the scope of the
    <code>ServletContext</code>. This path must be relative to the root of the
    <code>ServletContext</code> and begin with a <code>"/"</code>, or be empty. The method uses
    the path to look up a servlet, using the servlet path matching rules in
    <a href="">Chapter 12, <em>Mapping Requests to Servlets</em></a>, wraps
    it with a <code>RequestDispatcher</code> object, and returns the resulting object.
    If no servlet can be resolved based on the given path, a
    <code>RequestDispatcher</code> is provided that returns the content for that path.</p>

<p>The <code>getNamedDispatcher</code> method takes a
    <code>String</code> argument indicating the name of a servlet known to the
    <code>ServletContext</code>. If a servlet is found, it is wrapped with a
    <code>RequestDispatcher</code> object and the object is returned. If no servlet is
    associated with the given name, the method must return <code>null</code>.</p>

<p>To allow <code>RequestDispatcher</code> objects to be
    obtained using relative paths that are relative to the path of the
    current request (not relative to the root of the <code>ServletContext</code>), the
    <code>getRequestDispatcher</code> method is provided in the <code>ServletRequest</code>
    interface.</p>

<p>The behavior of this method is similar to the
    method of the same name in the <code>ServletContext</code>. The servlet container
    uses information in the request object to transform the given relative
    path against the current servlet to a complete path. For example, in a
    context rooted at <code>"/"</code> and a request to
    <code>/garden/tools.html</code>, a request dispatcher obtained via
    <code>ServletRequest.getRequestDispatcher("header.html")</code> will behave exactly like a call to
    <code>ServletContext.getRequestDispatcher("/garden/header.html")</code>.</p>

<h4>9.1.1. Query Strings in Request Dispatcher Paths</h4>
<p>The <code>ServletContext</code> and <code>ServletRequest</code>
    methods that create <code>RequestDispatcher</code> objects using path information
    allow the optional attachment of query string information to the path.
    For example, an Application Developer may obtain a <code>RequestDispatcher</code> by using the
    following code:</p>
<pre class="CodeRay highlight"><code data-lang="java"><span class="predefined-type">String</span> path = <span
        class="string"><span class="delimiter">&quot;</span><span class="content">/raisins.jsp?orderno=5</span><span
        class="delimiter">&quot;</span></span>;
RequestDispatcher rd = context.getRequestDispatcher(path);
rd.include(request, response);</code></pre>

<p>Parameters specified in the query string used
    to create the <code>RequestDispatcher</code> take precedence over other parameters
    of the same name passed to the included servlet. The parameters
    associated with a <code>RequestDispatcher</code> are scoped to apply only for the
    duration of the <code>include</code> or <code>forward</code> call.</p>

<h3>9.2. Using a Request Dispatcher</h3>
<p>To use a request dispatcher, a servlet calls
    either the <code>include</code> method or <code>forward</code> method of the
    <code>RequestDispatcher</code> interface. The parameters to these methods can be
    either the <code>request</code> and <code>response</code> arguments that were passed in via
    the <code>service</code> method of the <code>jakarta.servlet.Servlet</code> interface, or
    instances of subclasses of the request and response wrapper classes that
    were introduced for version 2.3 of the specification. In the latter
    case, the wrapper instances must wrap the request or response objects
    that the container passed into the <code>service</code> method.</p>

<p>The Container Provider should ensure that the
    dispatch of the request to a target servlet occurs in the same thread of
    the same JVM as the original request.</p>

<h3>9.3. The Include Method</h3>
<p>The <code>include</code> method of the
    <code>RequestDispatcher</code> interface may be called at any time. The target
    servlet of the <code>include</code> method has access to all aspects of the request
    object, but its use of the response object is more limited.</p>
<p>It can only write information to the
    <code>ServletOutputStream</code> or <code>Writer</code> of the response object and commit a
    response by writing content past the end of the response buffer, or by
    explicitly calling the <code>flushBuffer</code> method of the <code>ServletResponse</code>
    interface. It cannot set headers or call any method that affects the
    headers of the response, with the exception of the
    <code>HttpServletRequest.getSession()</code> and
    <code>HttpServletRequest.getSession(boolean)</code> methods. Any attempt to set the
    headers must be ignored, and any call to
    <code>HttpServletRequest.getSession()</code> or
    <code>HttpServletRequest.getSession(boolean)</code> that would require adding a
    Cookie response header must throw an <code>IllegalStateException</code> if the
    response has been committed.</p>
<p>If the default servlet is the target of a
    RequestDispatch.include() and the requested resource does not exist,
    then the default servlet MUST throw <code>FileNotFoundException</code>. If the
    exception isn&#8217;t caught and handled, and the response hasn’t been
    committed, the status code MUST be set to 500.</p>
<h4>9.3.1. Included Request Parameters</h4>
<p>Except for servlets obtained by using the
    <code>getNamedDispatcher</code> method, a servlet that has been invoked by another
    servlet using the <code>include</code> method of <code>RequestDispatcher</code> has access to
    the path by which it was invoked.</p>
<p>The following request attributes must be set:</p>
<pre class="CodeRay highlight"><code>jakarta.servlet.include.request_uri
jakarta.servlet.include.context_path
jakarta.servlet.include.servlet_path
jakarta.servlet.include.mapping
jakarta.servlet.include.path_info
jakarta.servlet.include.query_string</code></pre>
<p>These attributes are accessible from the
    included servlet via the <code>getAttribute</code> method on the request object and
    their values must be equal to the request URI, context path, servlet
    path, path info, and query string of the included servlet, respectively.
    If the request is subsequently included, these attributes are replaced
    for that include.</p>
<p>If the included servlet was obtained by using
    the <code>getNamedDispatcher</code> method, these attributes must not be set.</p>

<h3>9.4. The Forward Method</h3>
<p>The <code>forward</code> method of the
    <code>RequestDispatcher</code> interface may be called by the calling servlet only
    when no output has been committed to the client. If output data exists
    in the response buffer that has not been committed, the content must be
    cleared before the target servlet’s <code>service</code> method is called. If the
    response has been committed, an <code>IllegalStateException</code> must be thrown.</p>
<p>The path elements of the request object
    exposed to the target servlet must reflect the path used to obtain the
    <code>RequestDispatcher</code>.</p>
<p>The only exception to this is if the
    <code>RequestDispatcher</code> was obtained via the <code>getNamedDispatcher</code> method. In
    this case, the path elements of the request object must reflect those of
    the original request.</p>
<p>Before the <code>forward</code> method of the
    <code>RequestDispatcher</code> interface returns without exception, the response
    content must be sent and committed, and closed by the servlet container,
    unless the request was put into the asynchronous mode. If an error
    occurs in the target of the <code>RequestDispatcher.forward()</code> the exception
    may be propagated back through all the calling filters and servlets and
    eventually back to the container</p>
<h4>9.4.1. Query String</h4>
<p>The request dispatching mechanism is
    responsible for aggregating query string parameters when forwarding or
    including requests.</p>
<h4>9.4.2. Forwarded Request Parameters</h4>
<p>Except for servlets obtained by using the
    <code>getNamedDispatcher</code> method, a servlet that has been invoked by another
    servlet using the <code>forward</code> method of <code>RequestDispatcher</code> has access to
    the path of the original request.</p>
<p>The following request attributes must be set:</p>
<pre class="CodeRay highlight"><code>jakarta.servlet.forward.mapping
jakarta.servlet.forward.request_uri
jakarta.servlet.forward.context_path
jakarta.servlet.forward.servlet_path
jakarta.servlet.forward.path_info
jakarta.servlet.forward.query_string</code></pre>
<p>The values of these attributes must be equal
    to the return values of the <code>HttpServletRequest</code> methods <code>getRequestURI</code>
    , <code>getContextPath</code>, <code>getServletPath</code>, <code>getPathInfo</code>,
    <code>getQueryString</code>
    respectively, invoked on the request object passed to the first servlet
    object in the call chain that received the request from the client.</p>
<p>These attributes are accessible from the
    forwarded servlet via the <code>getAttribute</code> method on the request object.
    Note that these attributes must always reflect the information in the
    original request even under the situation that multiple forwards and
    subsequent includes are called.</p>
<p>If the forwarded servlet was obtained by using
    the <code>getNamedDispatcher</code> method, these attributes must not be set.</p>

<h3>9.5. Error Handling</h3>
<p>If the servlet that is the target of a request
    dispatcher throws a runtime exception or a checked exception of type
    <code>ServletException</code> or <code>IOException</code>, it should be propagated to the
    calling servlet. All other exceptions should be wrapped as
    <code>ServletExceptions</code> and the root cause of the exception set to the
    original exception, as it should not be propagated.</p>
<h3>9.6. Obtaining an AsyncContext</h3>
<p>An object implementing the <code>AsyncContext</code>
    interface may be obtained from the <code>ServletRequest</code> via one of
    <code>startAsync</code> methods. Once you have an <code>AsyncContext</code>, you can use it
    to either complete the processing of the request via the <code>complete()</code>
    method or use one of the <code>dispatch</code> methods described below.</p>

<h3>9.7. The Dispatch Method</h3>
<p>The following methods can be used to dispatch
    requests from the <code>AsyncContext</code>:</p>
<dl>
    <dt><code>dispatch(path)</code></dt>
    <dd>
        <p>The <code>dispatch</code> method takes a <code>String</code>
            argument describing a path within the scope of the <code>ServletContext</code>.
            This path must be relative to the root of the <code>ServletContext</code> and begin
            with a <code>"/"</code>.</p>
    </dd>
    <dt><code>dispatch(servletContext, path)</code></dt>
    <dd>
        <p>The <code>dispatch</code> method takes a <code>String</code>
            argument describing a path within the scope of the <code>ServletContext</code>
            specified. This path must be relative to the root of the
            <code>ServletContext</code> specified and begin with a <code>"/"</code>.</p>
    </dd>
    <dt><code>dispatch()</code></dt>
    <dd>
        <p>The <code>dispatch</code> method takes no argument. It
            uses the original URI as the path. If the <code>AsyncContext</code> was initialized
            via the <code>startAsync(ServletRequest, ServletResponse)</code> and the request
            passed is an instance of <code>HttpServletRequest</code>, then the dispatch is to
            the URI returned by <code>HttpServletRequest.getRequestURI()</code>. Otherwise the
            dispatch is to the URI of the request when it was last dispatched by the
            container</p>
    </dd>
</dl>
<p>One of the <code>dispatch</code> methods of the
    <code>AsyncContext</code> interface may be called by the application waiting for
    the asynchronous event to happen. If <code>complete()</code> has been called on the
    <code>AsyncContext</code>, an <code>IllegalStateException</code> must be thrown. All the
    variations of the dispatch methods returns immediately and do not commit
    the response.</p>
<p>The path elements of the request object
    exposed to the target servlet must reflect the path specified in the
    <code>AsyncContext.dispatch</code>.</p>
<h4>9.7.1. Query String</h4>
<p>The request dispatching mechanism is
    responsible for aggregating query string parameters when dispatching
    requests.</p>
<h4>9.7.2. Dispatched Request Parameters</h4>
<p>A servlet that has been invoked by using the
    <code>dispatch</code> method of <code>AsyncContext</code> has access to the path of the
    original request.</p>
<p>The following request attributes must be set:</p>
<pre class="CodeRay highlight"><code>jakarta.servlet.async.mapping
jakarta.servlet.async.request_uri
jakarta.servlet.async.context_path
jakarta.servlet.async.servlet_path
jakarta.servlet.async.path_info
jakarta.servlet.async.query_string</code></pre>

<p>The values of these attributes must be equal
    to the return values of the <code>HttpServletRequest</code> methods <code>getRequestURI</code>
    , <code>getContextPath</code>, <code>getServletPath</code>, <code>getPathInfo</code>, <code>getQueryString</code>
    respectively, invoked on the request object passed to the first servlet
    object in the call chain that received the request from the client.</p>
<p>These attributes are accessible from the
    dispatched servlet via the <code>getAttribute</code> method on the request object.
    Note that these attributes must always reflect the information in the
    original request even under the situation that multiple dispatches are
    called.</p>
</body>
</html>

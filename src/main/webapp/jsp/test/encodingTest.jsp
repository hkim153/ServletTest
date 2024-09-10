<%@ page contentType="text/html" %>
<html>
<body>
<%
    if (!response.getCharacterEncoding().equalsIgnoreCase("iso-8859-1")) {
        throw new ServletException("JSP getCharacterEncoding() spec error; getCharacterEncoding() shall be set as default encoding");
    }
    if (!response.getContentType().equals("text/html")) {
        throw new ServletException("contentType shall not be adjusted");
    }
    out.println("OKAY");
%>
</body>
</html>
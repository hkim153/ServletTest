package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PostParam extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doTask(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doTask(req, res);
	}
	public void doTask(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		res.setCharacterEncoding("utf-8");
		String writeObject = (String)req.getServletContext().getAttribute("writeObject");
		Object bufferSizeOb = req.getServletContext().getAttribute("bufferSize");
		if(bufferSizeOb != null) {
			int bufferSize = (int)bufferSizeOb;
			res.setBufferSize(bufferSize);
		}
		Object contentLengthOb = req.getServletContext().getAttribute("contentLength");
		if(contentLengthOb != null) {
			int contentLength = (int)contentLengthOb;
			res.setContentLength(contentLength);
		}
		
		Object outObject = null;
		if(writeObject.equals("ServletOutputStream")) {
			outObject = res.getOutputStream();
			ServletOutputStream out = (ServletOutputStream)outObject;
			out.print("<html><body>");
			res.reset();
			out.print("<html><body>");
			res.resetBuffer();
			out.print("<html><body>");
			out.print("before flush: res.isCommited()= " + res.isCommitted() + "<br>");
			res.flushBuffer();
			out.print("after flush: res.isCommited()= " + res.isCommitted() + "<br>");
			out.print("res.getBufferSize() : " + res.getBufferSize() + "<br>");
			out.print("res.getCharacterEncoding() : " + res.getCharacterEncoding() + "<br>");
			out.print("res.getContentType() : " + res.getContentType() + "<br>");
			
			
		}else if(writeObject.equals("PrintWriter")) {
			outObject = res.getWriter();
			PrintWriter out = (PrintWriter)outObject;
			
			out.print("<html><body>");
			res.resetBuffer();
			out.print("<html><body>");
			out.print("before flush: res.isCommited()= " + res.isCommitted() + "<br>");
			res.flushBuffer();
			out.print("after flush: res.isCommited()= " + res.isCommitted() + "<br>");
			out.print("res.getBufferSize() : " + res.getBufferSize() + "<br>");
			out.print("res.getCharacterEncoding() : " + res.getCharacterEncoding() + "<br>");
			out.print("res.getContentType() : " + res.getContentType() + "<br>");
			
			
			printServerAndClientInfo(out,req);
			printRequestInfo(out,req);
			printCookie(out, req);
			printSessionFromWhere(out, req);
			printPostParam(out, req);

			out.print("</body></html>");
			out.close();
		}
	}
	private void printPostParam(PrintWriter out, HttpServletRequest req) throws ServletException, IOException {
		out.print("<h2>읽은 데이터 정보</h2>");
		
		String readObject = (String)req.getServletContext().getAttribute("readObject");
		out.print("읽을 객체는: " + readObject + "<br>");
		if(readObject.equals("ServletInputStream")) {
			if(req.getMethod().equalsIgnoreCase("post")) {
				out.print("method: post<br>");
				out.print("<ul><li>ServletRequest: <br><ul>");
				out.print("<li>req.getInpuStream() : <br>");
				ServletInputStream input = req.getInputStream();
				int len = req.getContentLength();
				byte [] buf = new byte[len];
				input.readLine(buf, 0, len);
				String s = new String(buf);
				if(s != null)
					out.print("body 내용: " + s);
			}else {
				out.print("method: get<br>");
				out.print("<ul><li>HttpServletRequest: <br><ul>");
				out.print("<li>req.getQueryString() : " + req.getQueryString());
			}
			out.print("</ul></ul>");
			out.print("<hr>");
		}else if(readObject.equals("BufferedReader")) {
			if(req.getMethod().equalsIgnoreCase("post")) {
				out.print("method: post<br>");
				out.print("<ul><li>ServletRequest: <br><ul>");
				out.print("<li>req.getReader() : <br>");
				BufferedReader reader = req.getReader();
				int len = req.getContentLength();
				char [] cbuf = new char[len];
				reader.read(cbuf, 0, len);
				String s = new String(cbuf);
				if(s != null)
					out.print("body 내용: " + s);
			}else {
				out.print("method: get<br>");
				out.print("<ul><li>HttpServletRequest: <br><ul>");
				out.print("<li>req.getQueryString() : " + req.getQueryString());
			}
			out.print("</ul></ul>");
			out.print("<hr>");
		}else if(readObject.equals("Parameter")) {
			out.print("<ul><li>ServletRequest: <br><ul>");
			out.print("<li>req.getParameter(String name) : <br>");
			String text = req.getParameter("text");
			out.print("text= " + text + "<br>");
			String textarea = req.getParameter("textarea");
			out.print("textarea: " + textarea);
			out.print("<li>req.getParameterValues(String name) : <br>");
			String [] checkbox = req.getParameterValues("checkbox");
			if(checkbox != null) {
				for(String checkvalue: checkbox) {
					out.print("checkbox= " + checkvalue + "<br>");
				}
			}
			out.print("</ul></ul>");
			out.print("<hr>");
			
		}else if(readObject.equals("ParameterMap")) {
			out.print("<ul><li>ServletRequest: <br><ul>");
			out.print("<li>req.getParameterMap() : <br>");
			Map<String, String[]> parameterMap = req.getParameterMap();
			Iterator<String> iter = parameterMap.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				String [] values = parameterMap.get(key);
				for(String value : values) {
					out.print(key + "= " + value + "<br>");
				}
			}
			out.print("</ul></ul>");
			out.print("<hr>");
		}else if(readObject.equals("ParameterNames")) {
			out.print("<ul><li>ServletRequest: <br><ul>");
			out.print("<li>req.getParameterNames() : <br>");
			Enumeration<String> enm = req.getParameterNames();
			while(enm.hasMoreElements()) {
				String elem = enm.nextElement();
				String [] values = req.getParameterValues(elem);
				for(String value : values) {
					out.print(elem + "= " + value + "<br>");
				}
			}
			out.print("</ul></ul>");
			out.print("<hr>");
		}
	}
	private void printServerAndClientInfo(PrintWriter out, HttpServletRequest req) {
		out.print("<h2> Server와 Client 정보</h2>");
		
		out.print("<ul><li>ServletRequest: <br><ul>");
		out.print("<li>req.getServerName() : " + req.getServerName());
		out.print("<li>req.getServerPort() : " + req.getServerPort());
		
		out.print("<li>req.getLocalName() : " + req.getLocalName());
		out.print("<li>req.getLocalAddr() : " + req.getLocalAddr());
		out.print("<li>req.getLocalPort() : " + req.getLocalPort());
		
		out.print("<li>req.getRemoteAddr() : " + req.getRemoteAddr());
		out.print("<li>req.getRemoteHost() : " + req.getRemoteHost());
		out.print("<li>req.getRemotePort() : " + req.getRemotePort());
		
		out.print("<li>Enumeration&lt;Locale&gt; getLocales() : ");
		Enumeration<Locale> em = req.getLocales();
		while(em.hasMoreElements()) {
			out.print(em.nextElement() + ", ");
		}
		out.print("<li>req.getLocale() : " + req.getLocale());
		
		out.print("</ul></ul>");
		out.print("<hr>");
	}
	
	private void printRequestInfo(PrintWriter out, HttpServletRequest req) {
		out.print("<h2>Request 정보</h2>");
		
		out.print("<ul><li>ServletRequest: <br><ul>");
		
		out.print("<li>req.getScheme() : " + req.getScheme());
		out.print("<li>req.getProtocol() : " + req.getProtocol());
		out.print("<li>req.getCharacterEncoding() : " + req.getCharacterEncoding());
		out.print("<li>req.getContentLength() : " + req.getContentLength());
		out.print("<li>req.getContentLengthLong() : " + req.getContentLengthLong());
		out.print("<li>req.getContentType() : " + req.getContentType());
		out.print("<li>req.getDisPatcherType() : " + req.getDispatcherType());
		out.print("<li>req.getServletContext() : " + req.getServletContext());
		out.print("</ul><li>HttpServletRequest: <br><ul>");
		out.print("<li>req.getMethod() : " + req.getMethod());
		out.print("<li>req.getContextPath() : " + req.getContextPath());
		out.print("<li>req.getServletPath() : " + req.getServletPath());
		out.print("<li>req.getPathInfo() : " + req.getPathInfo());
		out.print("<li>req.getPathTranslated() : " + req.getPathTranslated());
		out.print("<li>req.getRequestURI() : " + req.getRequestURI());
		out.print("<li>req.getRequestURL() : " + req.getRequestURL());
		
		out.print("</ul></ul>");
		out.print("<hr>");
	}
	
	private void printCookie(PrintWriter out,HttpServletRequest req) {
		out.print("<h2>Cookie 정보</h2>");
		
		out.print("<ul><li>HttpServletRequest: <br><ul>");
		
		out.print("<li>Cookie[] getCookies() :  <br><ol>");
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie != null)
					out.print("<li>name: " + cookie.getName() + ", value: " + cookie.getValue());
			}
		}
		out.print("</ol>");
		
		out.print("</ul></ul>");
		out.print("<hr>");
	}
	
	private void printSessionFromWhere(PrintWriter out, HttpServletRequest req) {
		out.print("<h2>Session 정보</h2>");
		
		out.print("<ul><li>HttpServletRequest: <br><ul>");
		
		out.print("<li>boolean isRequestedSessionIdFromCookie() : " + req.isRequestedSessionIdFromCookie());
		out.print("<li>boolean isRequestedSessionIdFromURL() : " + req.isRequestedSessionIdFromURL());
		out.print("<li>boolean isRequestedSessionIdValid() : " + req.isRequestedSessionIdValid());
		out.print("<li>req.getSession(false) : " + req.getSession(false));

		out.print("</ul></ul>");
		out.print("<hr>");
	}
}

package servlet.async;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AsyncContextTest extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		boolean isWrapper = "true".equalsIgnoreCase(req.getParameter("wrapper"));
		String method = req.getParameter("method");
		boolean isClazz = "true".equalsIgnoreCase(req.getParameter("isClazz"));
		int timeout = Integer.parseInt(req.getParameter("timeout"));
		
		out.print("<html><body>");
		out.print("<h2>Async Context 흐름</h2>");
		out.print("<hr>1. 시작 전: <br>");
		out.print("req.isAsyncSupported(): " + req.isAsyncSupported() + "<br>");
		out.print("req.isAsyncStarted(): " + req.isAsyncStarted() + "<br>");
		try {
			out.print("req.getAsyncContext(): " + req.getAsyncContext() +"<br>");
		}catch(Exception e) {
			out.print("req.getAsyncContext(): Exception 발생 <br>");
			out.print(e.getStackTrace() + "<br>");
		}
		out.print("<hr>2. AsyncContext ac = req.startAsync() 또는 req.startAsync(ServletRequest, ServlerResponse) 호출 후: <br>");
		
		AsyncContext ac = null;
		AsyncRequestWrapper asyncRequestWrapper = null;
		AsyncResponseWrapper asyncResponseWrapper = null;
		if(isWrapper) {
			asyncRequestWrapper = new AsyncRequestWrapper(req);
			asyncResponseWrapper = new AsyncResponseWrapper(res);
			//wrapper로 할 작업처리 추가하자 
			ac = req.startAsync(asyncRequestWrapper, asyncResponseWrapper);
			out.print("wrapper로 호출함: ac = req.startAsync(asyncRequestWrapper, asyncResponseWrapper) <br>");
		}else {
			ac = req.startAsync();
			out.print("original로 호출함: ac = req.startAsync() <br>");
		}
		out.print("<br>req.isAsyncSupported(): " + req.isAsyncSupported() + "<br>");
		out.print("req.isAsyncStarted(): " + req.isAsyncStarted() + "<br>");
		out.print("req.getAsyncContext(): " + req.getAsyncContext() + "<br>");
		out.print("ac.hasOriginalRequestAndResponse(): " + ac.hasOriginalRequestAndResponse() + "<br>");
		out.print("<hr>3. AsyncListener 추가 <br>");
		if(isClazz) {
			out.print("Class객체로 생성 후 리스너 추가: <br><br>");
			out.print("Class<AsyncListenerTest> clazz = AsyncListenerTest.class<br>");
			out.print("AsyncListenerTest al = ac.createListener(clazz)<br>");
			Class<AsyncListenerTest> clazz = AsyncListenerTest.class;
			AsyncListenerTest al = ac.createListener(clazz);
			if(isWrapper && asyncRequestWrapper != null && asyncResponseWrapper != null) {
				ac.addListener(al, asyncRequestWrapper, asyncResponseWrapper);
				out.print("ac.addListener(al, asyncRequestWrapper, asyncResponseWrapper)<br>");
			}else {
				ac.addListener(al);
				out.print("ac.addListener(al)<br>");
			}
		}else {
			out.print("리스너 객체 생성 후 리스너 추가: <br><br>");
			out.print("AsyncListenerTest al = new AsyncListenerTest()<br>");
			AsyncListenerTest al = new AsyncListenerTest();
			if(isWrapper && asyncRequestWrapper != null && asyncResponseWrapper != null) {
				ac.addListener(al, asyncRequestWrapper, asyncResponseWrapper);
				out.print("ac.addListener(al, asyncRequestWrapper, asyncResponseWrapper)<br>");
			}else {
				ac.addListener(al);
				out.print("ac.addListener(al)<br>");
			}
		}
		out.print("<hr>4. AsyncContext Timeout<br>");
		out.print("현재 timeout: <br>");
		out.print("ac.getTimeout(): " + ac.getTimeout() + "<br>");
		out.print("set 할 timeout: ac.setTimeout("+timeout+")<br>");
		ac.setTimeout(timeout);
		if(method.equalsIgnoreCase("dispatch")) {
			out.print("<hr>5. AsyncContext dispatch<br>");
			out.print("ac.dispatch(\"/jsp/async/asyncDispatch.jsp\")");
			out.flush();
			ac.dispatch("/jsp/async/asyncDispatch.jsp");
		}else if(method.equalsIgnoreCase("start")) {
			out.print("<hr>5. AsyncContext start<br>");
			AsyncTask at = new AsyncTask(ac);
			out.print("ac.start(new AsyncTask(ac))<br>");
			out.flush();
			ac.start(at);
		}else {
			out.print("wrong method!!!");
			out.flush();
		}
		try {
			out.print("2초 대기!<br>");
			for(int i = 1; i<=2; i++) {
				Thread.sleep(1000);
			}
		}catch(Exception e) {}
		out.print("Servlet 종료!<br>");
	}
}

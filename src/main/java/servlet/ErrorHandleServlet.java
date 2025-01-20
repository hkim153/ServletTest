package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorHandleServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		Integer code = (Integer) req.getAttribute("jakarta.servlet.error.status_code");
		Object type = req.getAttribute("jakarta.servlet.error.exception_type");
		String message = (String)req.getAttribute("jakarta.servlet.error.message");
		Throwable exception = (Throwable)req.getAttribute("jakarta.servlet.error.exception");
		String uri = (String)req.getAttribute("jakarta.servlet.error.request_uri");
		
		out.print("this is doGet Method<br/>");
		out.print("<h2>Error Code : " + code + "</h2>");
		out.print("<h2>Error Type : " + type + "</h2>");
		out.print("<h2>Error Message : " + message + "</h2>");
		out.print("<h2>Error Exception : " + exception + "</h2>");
		out.print("<h2>Error Uri : " + uri + "</h2>");
		
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		Integer code = (Integer) req.getAttribute("jakarta.servlet.error.status_code");
		Object type = req.getAttribute("jakarta.servlet.error.exception_type");
		String message = (String)req.getAttribute("jakarta.servlet.error.message");
		Throwable exception = (Throwable)req.getAttribute("jakarta.servlet.error.exception");
		String uri = (String)req.getAttribute("jakarta.servlet.error.request_uri");
		
		out.print("this is doPost Method<br/>");
		out.print("<h2>Error Code : " + code + "</h2>");
		out.print("<h2>Error Type : " + type + "</h2>");
		out.print("<h2>Error Message : " + message + "</h2>");
		out.print("<h2>Error Exception : " + exception + "</h2>");
		out.print("<h2>Error Uri : " + uri + "</h2>");
		
		out.close();
	}
}

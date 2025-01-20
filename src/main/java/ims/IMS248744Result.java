package ims;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import servlet.SharedObject;

public class IMS248744Result extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			out.print("session이 생성되지 않");
		}else {
			out.print("이미 있는 session 출력");
			out.print("현재 Session ID: " + session.getId() + "<br>");
			SharedObject sharedObject = (SharedObject)session.getAttribute("HttpSession");
			if(sharedObject != null) {
				out.print("Attribute 정보 : " + sharedObject.getCount() + ", " + sharedObject.getName()+ "<br>");
			}else {
				out.print("Attribute 없음"+ "<br>");
			}
			out.print("Creation Time : " + session.getCreationTime() + "<br>");
			out.print("Last Accessed Time : " + session.getLastAccessedTime()+ "<br>");
			out.print("Max Inactive Interval : " + session.getMaxInactiveInterval()+ "<br>");
			out.print("ServletContext : " + session.getServletContext()+ "<br>");
		}
		
		out.close();
	}
}

package app.test;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import app.servlet.SharedObject;

@WebServlet(value="/test_getSessionAndForward")
public class Test_GetSessionAndForward extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		HttpSession session = req.getSession(true);
		session.setMaxInactiveInterval(60*5);
		SharedObject sharedObject = new SharedObject();
		sharedObject.setCount(1);
		sharedObject.setName("HttpSession에 저장한 객체");
		session.setAttribute("HttpSession", sharedObject);
		
		String method = req.getParameter("m");
		RequestDispatcher rd = null;
		String path = "test_getSessionAndForwardResult";
		if(method != null) {
			if(method.equals("servlet")) {
				path = "test_getSessionAndForwardResult";
			}else if(method.equals("jsp")) {
				path = "/jsp/test/test_getSessionAndForwardResult.jsp";
			}
		}
		//res.sendRedirect("IMS248744Result");
		rd = req.getRequestDispatcher(path);
		rd.forward(req, res);
	}
}

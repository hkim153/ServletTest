package app.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

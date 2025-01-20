package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorCauseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.print("<h2>에러 발생시키기 </h2>");
		try {
			for(int i = 1; i<4; i++) {
				out.print(i + "<br/>");
				out.flush();
				Thread.sleep(1000);
			}
		}catch(Exception e) {}
		String str = null;
		out.print(str.length());
		out.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}

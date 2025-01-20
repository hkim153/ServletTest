package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpServletTest extends HttpServlet {
	String name = "servletConfigTest";

	@Override
	public String getServletInfo() {
		return "해당 메소드 오버라이드 해야함";
	}
	@Override
	public void init() {
		log("HttpServletTest init method");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<h2>Method</h2>");
		out.print("<ul><li><b>Servlet</b>: <br/><ol><li>getServletConfig() : " + getServletConfig());
		out.print("<li>getServletInfo() :" + getServletInfo());
		out.print("</ol></li><li><b>ServletConfig</b> : <br/><ol>");
		out.print("<li>getInitParameter(\"initParam\") : " + getInitParameter("initParam"));
		out.print("<li>getServletContext() : " + getServletContext());
		out.print("<li>getServletName() : " + getServletName());
		out.print("</ol></li><li><b>HttpServlet</b> : <br/><ol>");
		out.print("<li>getLastModified(HttpServletRequest) : " + getLastModified(req));
		out.print("</ol></li></ul>");
		out.print("init(ServletConfig)를 Overriding 하면 안된다<br> 그럴경우 ServletConfig와 ServletContext를 필드에 저장 안해서 문제 발생한다");
		out.print("<br>대신 init()을 Overriding 한다.아니면 init(ServletConfig)안에 super.init(config) 호출해야한다");

		out.print("</body></html>");
		out.close();
	}

	@Override
	public void destroy() {
		log("HttpServletTest destroy method");
	}
}

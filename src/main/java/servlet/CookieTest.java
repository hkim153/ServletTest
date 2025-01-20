package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");

		Cookie[] cookies = req.getCookies();
		out.print("<h2>추출된 cookie 정보</h2>");
		out.print("<ol>");
		for(Cookie cookie : cookies) {
			if(cookie != null) {
				out.print("<li><ul>");
				out.print("<li>cookie.getComment() : " + cookie.getComment());
				out.print("<li>cookie.getDomain() : " + cookie.getDomain());
				out.print("<li>cookie.getMaxAge() : " + cookie.getMaxAge());
				out.print("<li>cookie.getName() : " + cookie.getName());
				out.print("<li>cookie.getValue() : " + cookie.getValue());
				out.print("<li>cookie.getPath() : " + cookie.getPath());
				out.print("<li>cookie.getSecure() : " + cookie.getSecure());
				out.print("<li>cookie.getVersion() : " + cookie.getVersion());
				out.print("<li>cookie.isHttpOnly() : " + cookie.isHttpOnly());
				out.print("</ul>");
			}
		}
		out.print("</ol><hr>");
		out.print("<h2>내용</h2>");
		out.print("getCookie의 결과는 name과 value만 가지고, Cookie 생성 후 addCookie한 쿠키에서만 name과 value와 함께 다른 정보도 유효하다.<br> 이는 client(browser)에서 필요한 정보인 것 같다");
		out.print("</body></html>");
		out.close();
	}

}

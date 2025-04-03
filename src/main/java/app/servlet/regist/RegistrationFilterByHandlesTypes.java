package app.servlet.regist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegistrationFilterByHandlesTypes implements Filter, RegistrationFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("this is registration filter annotated by HandlesTypes<br>");
		chain.doFilter(request, response);
	}
	
}

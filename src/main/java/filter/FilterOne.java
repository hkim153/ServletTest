package filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FilterOne implements Filter{
	FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		System.out.println("filterOne init!");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.print(filterConfig.getInitParameter("filterOneParam") + "<br/>");
		out.print("this is FilterOne before doFilter called<br/>");
		chain.doFilter(req, res);
		out.print("this is FilterOne after doFilter called<br/>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("filterOne destroy!");
	}
}

package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/welcomeFileServlet")
public class WelcomeFileTestFilter implements Filter
{
    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().println("WelcomefileTestFilter");
        chain.doFilter(request, response);
        String testString = "OutputStreamTestAfterForward";
        PrintWriter writer = response.getWriter();
        writer.write(testString);
        //response.setContentLength(testString.length());
    }
}

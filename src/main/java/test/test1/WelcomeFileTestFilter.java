package test.test1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

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

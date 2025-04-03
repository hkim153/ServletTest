package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.CommandProcess;

public class ContextParamTest implements CommandProcess
{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext context = request.getServletContext();
        String paramValue = context.getInitParameter("contextConfigLocation");
        out.print(paramValue);

        return null;
    }
}

package app.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CommandProcess;

public class ForwardStart implements CommandProcess
{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = request.getRequestDispatcher("/forward1.ims");
        response.addHeader("forwardStart", request.getDispatcherType().name());
        rd.forward(request, response);
        return null;
    }
}

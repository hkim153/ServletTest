package app.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.test.Test_CommandProcess;

public class Test_CommandProcess_ForwardStart implements Test_CommandProcess
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

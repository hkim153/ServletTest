package app.test.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.test.Test_CommandProcess;

public class Test_CommandProcess_Forwarded1 implements Test_CommandProcess
{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/forward2.ims");
        response.addHeader("forward1", request.getDispatcherType().name());
        rd.forward(request, response);

        return null;
    }
}

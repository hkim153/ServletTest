package app.test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.test.Test_CommandProcess;

public class Test_CommandProcess_Forwarded2 implements Test_CommandProcess
{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("forward2", request.getDispatcherType().name());

        return null;
    }
}

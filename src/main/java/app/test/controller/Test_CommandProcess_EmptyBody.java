package app.test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.test.Test_CommandProcess;

public class Test_CommandProcess_EmptyBody implements Test_CommandProcess
{
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        ServletInputStream inputStream = request.getInputStream();

        byte [] temp = new byte[1000];

        inputStream.read(temp);
        outputStream.write(temp);

        return null;
    }
}

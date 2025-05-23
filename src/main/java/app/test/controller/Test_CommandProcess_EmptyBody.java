package app.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

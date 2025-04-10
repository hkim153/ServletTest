package app.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test_checkHeaderAfterSendErrorInService")
public class Test_CheckHeaderAfterSendErrorInService extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("img/jpeg");
        resp.addHeader("My Header", "My Value");

        resp.sendError(530);
    }
}

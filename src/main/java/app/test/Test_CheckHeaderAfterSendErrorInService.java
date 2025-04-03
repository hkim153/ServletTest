package app.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkHeaderAfterSendErrorInService")
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

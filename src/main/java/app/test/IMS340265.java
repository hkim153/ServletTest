package app.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ims340265")
public class IMS340265 extends HttpServlet
{
    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletOutputStream out = resp.getOutputStream();
        out.print("test page");
    }
}
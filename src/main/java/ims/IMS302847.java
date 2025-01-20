package ims;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/ims302847")
public class IMS302847 extends HttpServlet
{
    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("QueryString: " + req.getQueryString());
        out.println("getParameter with QueryString(key=test): " + req.getParameter("test"));

        out.close();
    }
}

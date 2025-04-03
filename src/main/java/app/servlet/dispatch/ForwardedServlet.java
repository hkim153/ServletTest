package app.servlet.dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.servlet.GetPostServlet;

@WebServlet(name="ForwardedServlet", value="/forwardedServlet")
public class ForwardedServlet extends GetPostServlet
{
    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Forwarded Succeed!");
    }
}

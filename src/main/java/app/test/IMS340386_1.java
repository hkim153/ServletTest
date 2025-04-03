package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ims340386_1", asyncSupported = true)
public class IMS340386_1 extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(0);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        resp.setContentLength(14);
        out.write("I'm done!!!!!!");
        out.flush();
    }
}

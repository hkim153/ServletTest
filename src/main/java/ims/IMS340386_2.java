package ims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/ims340386_2")
public class IMS340386_2 extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try
        {
            Thread.currentThread().sleep(10000);
        }
        catch(InterruptedException e)
        {
            out.print("InterruptedException occurred");
        }

        System.out.println("I'm Done!!!!!!!!!/n/n/n/n/n/n");

        out.write("I'm Done!!!!!!!!!/");
    }
}

package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postDataServlet")
public class PostDataServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        processData(req, resp);
    }

    @Override
    public  void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        processData(req, resp);
    }

    public void processData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String textarea = req.getParameter("textarea");
        out.print(textarea.toCharArray());
        out.print("한글로");
    }
}

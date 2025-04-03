package app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GetPostServlet extends HttpServlet
{
    protected abstract void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }
}

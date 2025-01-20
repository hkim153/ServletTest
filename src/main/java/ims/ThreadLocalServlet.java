package ims;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThreadLocalServlet extends HttpServlet
{
    private static final ThreadLocal<Data> threadLocal = new ThreadLocal<>();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        saveThreadLocal(req, resp);
    }

    @Override
    public  void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        saveThreadLocal(req, resp);
    }

    public void saveThreadLocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("현재 thread: " + Thread.currentThread().getName());
        out.println("현재 threadLocal? ");
        if(threadLocal.get() == null)
        {
            out.println("threadLocal 비워 있음");

            threadLocal.set(new Data("name"));
        }
        else
        {
            out.println("threadLocal: " + threadLocal.get().getData());
        }
    }

    private static class Data
    {
        private String data;

        private Data(String data)
        {
            this.data = data;
        }

        String getData()
        {
            return data;
        }
    }
}

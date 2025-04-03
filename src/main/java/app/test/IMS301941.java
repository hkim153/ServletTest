package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IMS301941 extends HttpServlet
{
    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        if(session == null)
        {
            out.println("들어온 session이 null임");
            return;
        }
        else
        {
            out.println("들어온 session id: " + session.getId());
            out.println("requestedSessionId: " + req.getRequestedSessionId());
        }
        out.println("session invalidate and create new Session");
        session.invalidate();

        session = req.getSession(true);

        out.println("새로만든 session id: " + session.getId());
        out.println("requestedSessionId: " + req.getRequestedSessionId());

        out.close();
    }
}

package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/test_compareSessionIdAndRequestedSessionId")
public class Test_CompareSessionIdAndRequestedSessionId extends HttpServlet
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
            out.println("들어온 session id: " + session.getId() + "<br>");
            out.println("requestedSessionId: " + req.getRequestedSessionId() + "<br>");
        }
        out.println("session invalidate and create new Session" + "<br>");
        session.invalidate();

        session = req.getSession(true);

        out.println("새로만든 session id: " + session.getId() + "<br>");
        out.println("requestedSessionId: " + req.getRequestedSessionId() + "<br>");

        out.close();
    }
}

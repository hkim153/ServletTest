package app.servlet.dispatch;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import app.servlet.GetPostServlet;

/**
 * parameter {path, hasSlash}
 */
@WebServlet(value="/servletRequestGetRequestDispatcherTest")
public class ServletRequestGetRequestDispatcherTest extends GetPostServlet
{
    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = req.getParameter("path");

        if(path != null)
        {
            boolean slash = Boolean.parseBoolean(req.getParameter("hasSlash"));
            if(slash)
            {
                path = "/" + path;
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);

        if(requestDispatcher == null)
        {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "cannot initiate request dispatcher");
            return;
        }

        requestDispatcher.forward(req, resp);
    }
}

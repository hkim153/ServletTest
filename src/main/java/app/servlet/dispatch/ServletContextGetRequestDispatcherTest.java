package app.servlet.dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.servlet.GetPostServlet;

/**
 * parameter {path, hasSlash}
 */
@WebServlet(value="/servletContextGetRequestDispatcherTest")
public class ServletContextGetRequestDispatcherTest extends GetPostServlet
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

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);

        if(requestDispatcher == null)
        {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "cannot initiate request dispatcher");
            return;
        }

        requestDispatcher.forward(req, resp);
    }
}

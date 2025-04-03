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
 * parameter {name}
 */
@WebServlet(value="/servletContextGetNamedDispatcherTest")
public class ServletContextGetNamedDispatcherTest extends GetPostServlet
{
    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String name = req.getParameter("name");

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getNamedDispatcher(name);

        if(requestDispatcher == null)
        {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "cannot initiate request dispatcher");
            return;
        }

        requestDispatcher.forward(req, resp);
    }
}

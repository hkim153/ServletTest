package servlet.dispatch;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import servlet.GetPostServlet;

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

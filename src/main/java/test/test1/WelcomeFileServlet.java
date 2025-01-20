package test.test1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/welcomeFileServlet")
public class WelcomeFileServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String method = request.getParameter("forward");
        if (method != null && method.equals("true")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ForwardedServlet");
            requestDispatcher.forward(request, response);
        } else {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("WelcomeFileServlet");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

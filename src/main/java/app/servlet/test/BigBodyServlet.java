package app.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BigBodyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");

        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("asdfasdfasdf");
        out.print("</body></html>");
    }
}

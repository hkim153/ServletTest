package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/TimeoutServlet")
public class TimeoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int number = 0;
        String timeout = req.getParameter("timeout");
        int time = Integer.parseInt(timeout);
        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        while(number++<time) {
            try {
                Thread.sleep(1000);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        out.println("<h2> done! " +  "</h2>");
        out.close();
    }

}

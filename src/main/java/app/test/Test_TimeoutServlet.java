package app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test_timeoutServlet")
public class Test_TimeoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String message;
        String messageParam = req.getParameter("msg");
        if(messageParam != null)
        {
            message = messageParam;
        }
        else
        {
            message = "testMessage";
        }
        int timeoutInMillie;
        String timeoutParam = req.getParameter("timeout");
        if(timeoutParam != null)
        {
            timeoutInMillie = Integer.parseInt(timeoutParam);
        }
        else
        {
            timeoutInMillie = 1000;
        }
        int num;
        String numParam = req.getParameter("num");
        if(numParam != null)
        {
            num = Integer.parseInt(numParam);
        }
        else
        {
            num = 10;
        }
        boolean isAutoFlush;
        String autoFlush = req.getParameter("autoFlush");
        if(autoFlush != null)
        {
            isAutoFlush = Boolean.parseBoolean(autoFlush);
        }
        else
        {
            isAutoFlush = true;
        }

        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<html><body><h2> 처리결과</h2>");
        int count = 1;
        while(count <= num) {
            out.print("Count " + count + ": " + message + "<br>");
            if(isAutoFlush)
                out.flush();
            System.out.println("Count " + count + ": " + message + "<br>");
            try {
                Thread.sleep(timeoutInMillie);
            }catch(Exception e) {
                System.out.println(e);
            }
            count++;
        }
        out.println("<h2> done </h2>");
        out.println("</body></html>");
        out.close();
    }
}

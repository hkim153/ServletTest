package app.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BigBodyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");

        int length = 100;
        int times = 2;
        if(req.getParameter("length") != null)
            length = Integer.parseInt(req.getParameter("length"));
        if(req.getParameter("times") != null)
            times = Integer.parseInt(req.getParameter("times"));

        PrintWriter out = res.getWriter();

        for(int i = 0; i < times; i++) {
            String data = generateRandomString(length);
            out.print(data);
        }
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }
}

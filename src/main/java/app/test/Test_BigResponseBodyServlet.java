package app.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/test_bigResponseBodyServlet")
public class Test_BigResponseBodyServlet extends HttpServlet {
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
            out.println(data);
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

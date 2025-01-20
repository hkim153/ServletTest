package servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servletResponseResetTest")
public class ServletResponseResetTest extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        System.out.println(res.getContentType());
        System.out.println(res.getLocale().toString());
        System.out.println(res.getCharacterEncoding());

        res.setLocale(Locale.KOREA);
        res.setContentType("text/html");
        //res.setCharacterEncoding("utf-16");

        System.out.println(res.getContentType());
        System.out.println(res.getLocale().toString());
        System.out.println(res.getCharacterEncoding());

        res.reset();

        System.out.println(res.getContentType());
        System.out.println(res.getLocale().toString());
        System.out.println(res.getCharacterEncoding());

        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-16");
        res.setLocale(Locale.KOREA);

        PrintWriter out = res.getWriter();

        out.println(res.getContentType());
        out.println(res.getLocale().toString());
        out.println(res.getCharacterEncoding());
    }
}

package model.ims;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.CommandProcess;

public class TestSession implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h2>IMS 정보<h2><br>");
        out.print("<ol>");
        out.print("<li>ims number: 271570, ");
        out.print("<li>information: response에서 set-cookie가 두번 나가는 이유");
        out.print("</ol>");
        out.print("<hr>");
        HttpSession session = request.getSession(false);
        if(session == null){
            out.print("처음에는 session이 없다.<br>");
        }else{
            out.print("이미 session이 존재함 session을 일단 지운다.<br>");
            session.invalidate();
        }

        out.print("<br>");
        session = request.getSession(true);
        out.print("session 다시 생성함<br>");
        out.print("현재 세션 ID: " + session.getId() + "<br>");

        out.print("<br>");
        out.print("삭제하고 리턴 !!<br>");
        session.invalidate();

        return null;
    }
}

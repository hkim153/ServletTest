package model.ims;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CommandProcess;

public class ForwardStart implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        RequestDispatcher rd = request.getRequestDispatcher("/forward1.ims");
        response.addHeader("forwardStart", request.getDispatcherType().name());
        rd.forward(request, response);
        return null;
    }
}

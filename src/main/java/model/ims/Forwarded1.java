package model.ims;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CommandProcess;

public class Forwarded1 implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/forward2.ims");
        response.addHeader("forward1", request.getDispatcherType().name());
        rd.forward(request, response);

        return null;
    }
}

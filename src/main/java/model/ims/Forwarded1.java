package model.ims;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

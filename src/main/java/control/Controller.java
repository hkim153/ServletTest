package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.CommandProcess;

public abstract class Controller extends HttpServlet {

    private Map<String, Object> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String props = config.getInitParameter("config");

        Properties pr = new Properties();
        String configFilePath = config.getServletContext().getRealPath(props);
        try(FileInputStream f = new FileInputStream(configFilePath)){
            pr.load(f);
        }catch (IOException e){
            throw new ServletException(e);
        }

        Iterator iter = pr.keySet().iterator();
        while(iter.hasNext()){
            String command = (String) iter.next();
            String className = pr.getProperty(command);
            try{
                Class commandClass = Class.forName(className);
                Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
                commandMap.put(command, commandInstance);
            }catch (Exception e){
                throw new ServletException(e);
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = null;
        try{
            String command = request.getRequestURI();
            command = command.substring(request.getContextPath().length());

            CommandProcess com = (CommandProcess) commandMap.get(command);
            if(com == null){
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            view = com.requestPro(request, response);
        } catch (Throwable throwable){
            throw new ServletException(throwable);
        }

        if(view != null){
            RequestDispatcher rd = request.getRequestDispatcher(view);
            rd.forward(request, response);
        }
    }

}

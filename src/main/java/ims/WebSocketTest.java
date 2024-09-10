package ims;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/websocketTest")
public class WebSocketTest extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        try
        {
        final ClientEchoEndpoint clientEchoEndpoint = new ClientEchoEndpoint(new URI("ws://localhost:8088/ServletTest/echo"));

        clientEchoEndpoint.sendMessage("hello server!!!!!");

        Thread.sleep(5000);
        }catch(InterruptedException | URISyntaxException e){}
    }
}

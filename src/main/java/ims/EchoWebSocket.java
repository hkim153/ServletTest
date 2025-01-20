package ims;

import java.io.IOException;
import java.util.Arrays;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoWebSocket {

    @OnMessage
    public void onMessage(Session session, String msg)
            throws IOException
    {
        try{
            session.getBasicRemote().sendText(msg);
        }catch(IOException e)
        {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}


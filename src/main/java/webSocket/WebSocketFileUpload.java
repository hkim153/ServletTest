/*
package webSocket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/webSocketFileUpload")
public class WebSocketFileUpload {

	static File file = null;
	static String fileName = null;
	int fCount = 0;
	BufferedOutputStream bos;
	String path = "/home/hyunsoo/Desktop/";

	@OnMessage
    public void message(Session session, String msg) {
        
        if(!msg.equals("end")) {
            fileName=msg.substring(msg.indexOf(':')+1);
            System.out.println(fileName);
            file = new File(path+fileName);
            try {
            	bos = new BufferedOutputStream(new FileOutputStream(file));
            } catch (FileNotFoundException e) {     
                e.printStackTrace();
            }
        }else {
            try {
            	bos.flush();
            	bos.close();                
            } catch (IOException e) {       
                e.printStackTrace();
            }
        }
    }
	
	@OnMessage
	public void processUpload(ByteBuffer msg, boolean last, Session session) {
		System.out.println("Binary Data: " + fCount + ", Capacity: " + msg.capacity());
		fCount++;
		while (msg.hasRemaining()) {
			try {
				bos.write(msg.get());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@OnOpen
	public void open(Session session) {
		System.out.println("WebSocket File Server Open......");
	}

	@OnError
	public void error(Session session, Throwable t) {
		System.out.println("error.......");
	}

	@OnClose
	public void closedConnection(Session session) {
		System.out.println("연결종료........");
	}

}*/

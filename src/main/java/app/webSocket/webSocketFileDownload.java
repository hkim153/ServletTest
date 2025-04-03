/*
package webSocket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/webSocketFileDownload")
public class webSocketFileDownload {

	String path = "/home/hyunsoo/Desktop/";

	@OnMessage
	public void onMessage(Session session, String msg) throws IOException {
		String fileName = msg.substring(msg.indexOf(":") + 1);
		System.out.println("request file : " + fileName);
		int count = 1;
		File file = new File(path + fileName);
		
		
		byte[] fileBytes = new byte[(int)file.length()];
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(fileBytes);
		ByteBuffer buf = ByteBuffer.wrap(fileBytes);
		session.getBasicRemote().sendBinary(buf);
		//127kb = 130048
		*/
/*int kb = 130048;
		byte[] fileBytes = new byte[kb];

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		while(bis.read(fileBytes)!=-1) {
			System.out.println("hyunsoo current count : "+ count);
			ByteBuffer buf = ByteBuffer.wrap(fileBytes);
			session.getBasicRemote().sendBinary(buf);
			count++;
		}
		*//*

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

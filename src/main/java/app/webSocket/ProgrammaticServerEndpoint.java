/*
package webSocket;

import java.io.IOException;

import jakarta.websocket.CloseReason;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.RemoteEndpoint;
import jakarta.websocket.Session;

public class ProgrammaticServerEndpoint extends Endpoint{

	@Override
	public void onOpen(final Session session, EndpointConfig config) {
		session.addMessageHandler(new MessageHandler.Whole<String>() {

			@Override
			public void onMessage(String message) {
				try {
					for(Session sess : session.getOpenSessions()) {
						if(sess.isOpen()) {
							RemoteEndpoint.Basic remoteEndpoint = sess.getBasicRemote();
							remoteEndpoint.sendText(message);
							//remoteEndpoint.sendBinary(data);
							//remoteEndpoint.sendPing(applicationData);
							//remoteEndpoint.sendPong(applicationData);
							//session.getAsyncRemote().sendText(message);
						}
					}
				}catch(IOException e) {}
			}
			
			
		});
	}
	@Override
	public void onError(Session session, Throwable thr) {
		thr.printStackTrace();
	}
	@Override
	public void onClose(Session session, CloseReason closeReason) {
		
	}
}
*/

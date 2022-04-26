/*
package webSocket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

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

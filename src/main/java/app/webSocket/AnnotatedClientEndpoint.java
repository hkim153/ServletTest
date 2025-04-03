
/* package webSocket;
 * 
 * import java.io.IOException; import java.net.URI; import
 * java.net.URISyntaxException; import java.util.HashMap;
 * 
 * import javax.websocket.ClientEndpoint; import
 * javax.websocket.ContainerProvider; import
 * javax.websocket.DeploymentException; import javax.websocket.EncodeException;
 * import javax.websocket.OnClose; import javax.websocket.OnError; import
 * javax.websocket.OnMessage; import javax.websocket.OnOpen; import
 * javax.websocket.Session; import javax.websocket.WebSocketContainer;
 * 
 * @ClientEndpoint public class AnnotatedClientEndpoint { private Session
 * userSession = null; private static HashMap<AnnotatedClientEndpoint, String>
 * users = new HashMap<>();
 * 
 * public AnnotatedClientEndpoint() {}
 * 
 * public static boolean hasId(String id) { if(users.containsValue(id)) return
 * true; return false; }
 * 
 * @OnOpen public void onOpen(boolean isClass, String id){ users.put(this, id);
 * URI uri = null; try { uri = new
 * URI("ws://localhost:8080/ServletTest/annotatedServerEndpoint/" + id); } catch
 * (URISyntaxException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } WebSocketContainer container =
 * ContainerProvider.getWebSocketContainer(); if(isClass) { try { userSession =
 * container.connectToServer(AnnotatedClientEndpoint.class, uri); } catch
 * (DeploymentException | IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }else { try { userSession =
 * container.connectToServer(this, uri); } catch (DeploymentException |
 * IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
 * System.out.println("opening client webSocket"); }
 * 
 * @OnClose public void onClose() { users.remove(this); try {
 * this.userSession.close(); } catch (IOException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } }
 * 
 * @OnMessage public String onMessage(String message) { return message; } public
 * void sendMessage(String msg) { Message message = new Message();
 * message.setContent(msg); try {
 * this.userSession.getBasicRemote().sendObject(message); } catch (IOException |
 * EncodeException e) { // TODO Auto-generated catch block e.printStackTrace();
 * } }
 * 
 * @OnError public void onError(Session session, Throwable error) {
 * error.printStackTrace(); } }
 */

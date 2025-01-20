package servlet.nio;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class NioAsyncTask implements Runnable {

AsyncContext ac = null;
	
	public NioAsyncTask(AsyncContext ac){
		this.ac = ac;
	}
	public void run() {
		ServletRequest req = ac.getRequest();
		ServletResponse res = ac.getResponse();
		try {
			req.setCharacterEncoding("utf-8");
			ServletInputStream is = req.getInputStream();
			ReadListenerImpl readListener = new ReadListenerImpl();
			is.setReadListener(readListener);
			
			ServletOutputStream os = res.getOutputStream();
			WriteListenerImpl writeListener = new WriteListenerImpl();
			os.setWriteListener(writeListener);
			
			byte[] b = new byte [50];
			while(true) {
				if(is.isReady()) {
					is.read(b);
					if(os.isReady()) {
						os.write(b);
						os.flush();
					}
					if(is.isFinished()) {
						break;
					}
				}
			}
			ac.complete();
		}catch(Exception e) {}
		
	}
}
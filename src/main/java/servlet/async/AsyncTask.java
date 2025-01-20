package servlet.async;

import java.io.PrintWriter;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AsyncTask implements Runnable{
	AsyncContext ac = null;
	
	AsyncTask(AsyncContext ac){
		this.ac = ac;
	}
	public void run() {
		ServletRequest req = ac.getRequest();
		ServletResponse res = ac.getResponse();
		try {
			PrintWriter out = res.getWriter();
			out.print("run()에서 시작함!<br>");
			for(int i = 1; i<=120; i++) {
				out.print(i+ "<br>");
				out.flush();
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
			}
			out.print("ac.complete() 호출");
			ac.complete();
		}catch(Exception e) {}
		
	}
}
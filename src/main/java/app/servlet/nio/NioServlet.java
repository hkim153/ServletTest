package app.servlet.nio;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NioServlet extends HttpServlet{

	@Override 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		AsyncContext ac = req.startAsync();
		NioAsyncTask task = new NioAsyncTask(ac);
		
		ac.start(task);
		
	}
}

package servlet.nio;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NioServlet extends HttpServlet{

	@Override 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		AsyncContext ac = req.startAsync();
		NioAsyncTask task = new NioAsyncTask(ac);
		
		ac.start(task);
		
	}
}

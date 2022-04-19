package servlet.async;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//이럴 경우를 위해 HttpServletRequest를 구현해서 모든 메소드를 구현할 필요 없이 그냥 HttpServletRequestWrapper를 상속받으면 되는구낭~!!
public class AsyncRequestWrapper extends HttpServletRequestWrapper {
	
	
	public AsyncRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

}

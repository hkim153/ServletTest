package servlet.async;

import java.io.IOException;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;

public class AsyncListenerTest implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent asyncEvent) throws IOException {
		System.out.println("AsyncServlet.onComplete");
		System.out.println("asyncEvent = [" + asyncEvent + "]");
		System.out.println(asyncEvent.getAsyncContext());
		System.out.println(asyncEvent.getSuppliedRequest());
		System.out.println(asyncEvent.getSuppliedResponse());
		System.out.println(asyncEvent.getThrowable());
	}

	@Override
	public void onTimeout(AsyncEvent asyncEvent) throws IOException {
		System.out.println("AsyncServlet.onTimeout");
		System.out.println("asyncEvent = [" + asyncEvent + "]");
		System.out.println(asyncEvent.getAsyncContext());
		System.out.println(asyncEvent.getSuppliedRequest());
		System.out.println(asyncEvent.getSuppliedResponse());
		System.out.println(asyncEvent.getThrowable());
	}

	@Override
	public void onError(AsyncEvent asyncEvent) throws IOException {
		System.out.println("AsyncServlet.onError");
		System.out.println("asyncEvent = [" + asyncEvent + "]");
		System.out.println(asyncEvent.getAsyncContext());
		System.out.println(asyncEvent.getSuppliedRequest());
		System.out.println(asyncEvent.getSuppliedResponse());
		System.out.println(asyncEvent.getThrowable());
	}

	@Override
	public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
		System.out.println("AsyncServlet.onStartAsync");
		System.out.println("asyncEvent = [" + asyncEvent + "]");
		System.out.println(asyncEvent.getAsyncContext());
		System.out.println(asyncEvent.getSuppliedRequest());
		System.out.println(asyncEvent.getSuppliedResponse());
		System.out.println(asyncEvent.getThrowable());
	}
}

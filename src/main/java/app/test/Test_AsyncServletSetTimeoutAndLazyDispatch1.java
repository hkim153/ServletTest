package app.test;

import java.io.IOException;
import java.util.concurrent.Executors;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/test_asyncServletSetTimeoutAndLazyDispatch1", asyncSupported = true)
public class Test_AsyncServletSetTimeoutAndLazyDispatch1 extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int asyncTimeout = 0;
        int sleepTimeout = Integer.MAX_VALUE;

        String asyncTimeoutParam = req.getParameter("asyncTimeout");
        if (asyncTimeoutParam != null)
            asyncTimeout = Integer.parseInt(asyncTimeoutParam);

        String sleepTimeoutParam = req.getParameter("sleepTimeout");
        if (sleepTimeoutParam != null)
            sleepTimeout = Integer.parseInt(sleepTimeoutParam);

        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(asyncTimeout);

        TestRunnable testRunnable = new TestRunnable(sleepTimeout, asyncContext);
        Executors.newSingleThreadExecutor().execute(testRunnable);
    }

    private static class TestRunnable implements Runnable
    {
        private final int sleepTimeout ;
        private final AsyncContext asyncContext;

        public TestRunnable(int sleepTimeout, AsyncContext asyncContext)
        {
            this.sleepTimeout = sleepTimeout;
            this.asyncContext = asyncContext;
        }
        @Override
        public void run()
        {
            System.out.println("Wait for the timeout");

            try
            {
                Thread.currentThread().sleep(sleepTimeout);
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted");
                throw new RuntimeException(e);
            }

            System.out.println("Done wait and dispatch the request");
            asyncContext.dispatch("/test_asyncServletSetTimeoutAndLazyDispatch2");
        }
    }
}


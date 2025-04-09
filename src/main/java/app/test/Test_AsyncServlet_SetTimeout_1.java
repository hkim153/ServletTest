package app.test;

import java.io.IOException;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/test_asyncServlet_setTimeout_1", asyncSupported = true)
public class Test_AsyncServlet_SetTimeout_1 extends HttpServlet
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
            asyncContext.dispatch("/test_asyncServlet_setTimeout_2");
        }
    }
}


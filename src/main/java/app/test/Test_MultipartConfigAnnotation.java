package app.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(description = "Test_MultipartConfigAnnotation",
        displayName = "Test_MultipartConfigAnnotation",
        name="test_multipartConfigAnnotation",
        value="/test_multipartConfigAnnotation",
        initParams = {@WebInitParam(name = "fileSize", value = "7333") })
@MultipartConfig(location= "/Users/hyunsoo/Desktop/test/", fileSizeThreshold = 100)
public class Test_MultipartConfigAnnotation extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");

        res.setContentType("text/html;charset=utf-8");
        printPartContents(res.getWriter(), req.getParts());
    }

    private void printPartContents(PrintWriter out, Collection<Part> parts) throws IOException{
        for(Part part : parts){
            out.print("<hr><br>");
            out.print("Part Name: " + part.getName() + "<br>");
            out.print("file name: " + part.getSubmittedFileName() + "<br>");
            out.print("content-type: " + part.getContentType() + "<br>");
            out.print("size: " + part.getSize() + "<br>");
            out.print("Headers: <br>" );
            Collection<String> collection = part.getHeaderNames();
            part.write(part.getName());
            Iterator<String> it = collection.iterator();
            while(it.hasNext()){
                String name = it.next();
                Collection<String> values = part.getHeaders(name);
                Iterator<String> it2 = values.iterator();
                while(it2.hasNext()){
                    String value = it2.next();
                    out.print(name + ": " + value + "<br>");
                }
            }
            out.print("Contents: <br>");
            InputStream in = part.getInputStream();
            int c = 0;
            while((c = in.read()) != -1){
                out.print(new String(new byte[]{(byte)c}, "UTF-8"));
            }
        }
    }
}

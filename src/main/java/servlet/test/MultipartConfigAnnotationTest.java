package servlet.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(description = "MultipartConfigAnnotationTest",
        displayName = "MultipartConfigAnnotationTest",
        name="multipartConfigAnnotationTest",
        value="/multipartConfigAnnotationTest",
        initParams = {@WebInitParam(name = "fileSize", value = "7333") })
@MultipartConfig(location= "/Users/hyunsoo/Desktop/test/", fileSizeThreshold = 100)
public class MultipartConfigAnnotationTest extends HttpServlet {

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

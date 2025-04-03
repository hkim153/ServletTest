package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.MappingMatch;

public class HttpServletMappingTest extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		HttpServletMapping httpServletMapping = req.getHttpServletMapping();
		
		out.print("getMatchValue(): " + httpServletMapping.getMatchValue() +"</br>");
		out.print("getPattern(): " + httpServletMapping.getPattern() +"</br>");
		out.print("getServletName(): " + httpServletMapping.getServletName() +"</br>");
		
		MappingMatch mappingMatch = httpServletMapping.getMappingMatch();
		
		
		out.close();
	}

}

<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
파일 업로드 결과 : 
<%
request.setCharacterEncoding("UTF-8");

String cotentType = request.getContentType();
Enumeration e = request.getHeaderNames();
    //헤더 정보 
    while(e.hasMoreElements()) {
        String key = (String)e.nextElement();
        String value = request.getHeader(key);
        out.println(key+":"+value+"<br>");
    }

     DataInputStream fos    = new DataInputStream(request.getInputStream());
    
    //서버의 디스크에 파일 저장
	/*
    FileOutputStream fs
    = new FileOutputStream("/home/hyunsoo/Desktop/test.txt");
    int data;
    while((data=fos.read()) != -1) {
        fs.write(data);
        fs.flush();
    }
    fs.close(); 
    */

    String path = "/Users/hyunsoo/Desktop/test.txt";
    out.print("업로드할 경로: " + path);

    InputStream in = request.getInputStream();
    File file = new File(path);
    FileOutputStream fs
    = new FileOutputStream(file);
    int d;
    while((d=in.read()) != -1){
        	fs.write(d);
			out.write(d);
        	fs.flush();
    }
    fs.close();

 out.flush();

%>
</body>
</html>
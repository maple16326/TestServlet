<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <p style=" font-family: Verdana, Arial;margin-left:35px;color:black;font-weight:bold">
    <%
        //List fiboList = (List)request.getAttribute("fibolist");
        //out.println("The Fibonacci Sequence is:"+fiboList);  
        
        String M = session.getAttribute("FibonacciSequence").toString(); //从session里把a拿出来，并赋值给M 
        out.println(M);
    %>
    </p>
</body>
</html>
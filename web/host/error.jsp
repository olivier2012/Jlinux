<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Error Page</title>
</head>
<body>
        <%@include file="host_header.html" %> 
<center>
    <h1>Exception is: <%= exception %>   </h1>
     <h1>Your Login Was Unsuccessful - Please Try Again</h1>
     To login again <a href="../register.jsp">click here</a>.
</center>
    <%@include file="host_footer.html" %> 
</body>
</html>
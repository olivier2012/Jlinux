<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Error Page</title>
</head>
<body>
        <%@include file="header.html" %> 
<center>
<!--    <h1>Exception is: <%= exception %>   </h1>-->
     <h1>Registration Successful</h1>
     
     <h2> Thanks for Registering with us :</h2>
     
     <h2>To login with new User_name and Password <a href=login.jsp>Click here</a></h2>
</center>
    <%@include file="footer.html" %> 
</body>
</html>
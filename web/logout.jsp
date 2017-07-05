<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
     <link rel="stylesheet" type="text/css" href="css/main.css">
     <title>logout Page</title>
</head>
<body>
    <%@include file="header.html" %> 
    <%@ page errorPage="error.jsp" %>  
     <%     
         session.removeAttribute("User_name");
         session.removeAttribute("Passwd");
         session.invalidate();
     %>
<center>
     <h1>You have successfully logged out</h1>
     To login again <a href="login.jsp">click here</a>.
</center>
<%@include file="footer.html" %> 
</body>
</html>
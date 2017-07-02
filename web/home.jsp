<%@page import="jl.service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Hiber.DB.hw.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" /> 
     <link rel="stylesheet" type="text/css" href="css/_style.css"/>
     <title>Result Page</title>
</head>
<body>
<center>
     <div id="container">
         <h1>Result Page</h1>
             <b>This is Sample Result Page</b><br/>
             <%=new Date()%></br>
             <%
                 User user = (User) session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getFname() + " " + user.getLname()%></b>     
             <br/>
             <a href="logout.jsp">Logout</a>
 
         <table>
             <thead>
                 <tr>
                     <th>User Name</th>
                     <th>First Name</th>
                     <th>Middle Name</th>
                     <th>Last Name</th>
                     <th>Email</th>                
                 </tr>
             </thead>
             <tbody>
                 <%
                     LoginService loginService = new LoginService();
                     List<User> list = loginService.getListOfUsers();
                     for (User u : list) {
                 %>
                 <tr>
                     <td><%=u.getUser_name()%></td>
                     <td><%=u.getFname()%></td>
                     <td><%=u.getMname()%></td>
                     <td><%=u.getLname()%></td>
                     <td><%=u.getEmail()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
</body>
</html>
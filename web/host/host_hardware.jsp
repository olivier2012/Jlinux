<%@page import="jl.service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Hiber.DB.hw.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" /> 
     <title>Hardware Page</title>
</head>
  <%@include file="host_header.html" %> 
<center>
     <div id="container">
         <h1>Hardware Page</h1>
             <b>Hardware Result Page</b><br/>
             <%=new Date()%></br>
             <%
                 User user = (User) session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getFname() + " " + user.getLname()%></b>     
             <br/>
             <a href="../logout.jsp">Logout</a>
              <%
                CPU cpu = (CPU) session.getAttribute("cpu");
             %> 
               
         <table>
             <thead>
                 <tr>
                     <th>Host_name</th>
                     <th>APICID</th>
                     <th>CPU_Cores</th>
                     <th>CPU Family</th>
                     <th>Flags</th>   
                     <th>Model Name</th>  
                     <th>Physical_ID</th>  
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
  <%@include file="host_footer.html" %> 
</html>
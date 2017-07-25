<%@page import="Hiber.DB.hw.Jlinux_CPU"%>
<%@page import="java.util.Map"%>
<%@ page errorPage="error.jsp" %>  
<%@page import="jl.service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Hiber.DB.hw.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/main.css" rel="stylesheet" type="text/css" /> 
     <title>Hardware Page</title>
</head>
  <%@include file="host_header.html" %> 
<center>
     <div id="container">
         <h1>User List Page</h1>
             <%=new Date()%></br>
            <%
                Jlinux_User user = (Jlinux_User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>  
            <%
             User_data user_data = new User_data();
             List<Jlinux_User> list = user_data.findAll();
             %> 
         <table> 
             <thead>
                 <tr>   
                        <th>User   ID </th>
                        <th>User   Name  </th>
                        <th>First    Name  </th>
                        <th>Middle   Name </th>
                        <th>Last   Name </th>
                        <th> Email    -  </th>   
                        <th>Password  - </th> 
                        <th>Usertype - </th> 
                 </tr>
             </thead>
             <tbody>
              <%
                   
                        for (Jlinux_User u : list) {
                    %>
                    <tr>
                        <td><%=u.getUserId() %></td>
                        <td><%=u.getUser_name()%></td>
                        <td><%=u.getFname()%></td>
                        <td><%=u.getMname()%></td>
                        <td><%=u.getLname()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getPasswd()%></td>
                        <td><%=u.getUsertype()%></td>
                    </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
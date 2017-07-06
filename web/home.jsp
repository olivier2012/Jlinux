<%@ page errorPage="error.jsp" %>  
<%@page import="jl.service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Hiber.DB.hw.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/main.css" rel="stylesheet" type="text/css" /> 
        <title>Result Page</title>
    </head>
    <%@include file="header.html" %> 
    <center>
        <div id="container">
            <h1>Admin Page</h1>
            <b>You from Host name : <%= request.getRemoteHost() + "   IP Address : " + request.getRemoteAddr() + "------ Port: " + request.getRemotePort()%></b>   
            <br/>
            <%=new Date()%></br>
            <%
                Jlinux_User user = (Jlinux_User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>     
            <br/>
            <a href="logout.jsp">Logout</a>

            <table>
                <thead>
                    <tr>
                        <th>User Name -  </th>
                        <th>First Name -  </th>
                        <th>Middle Name - </th>
                        <th>Last Name  - </th>
                        <th> Email    -  </th>   
                        <th>Password  - </th> 
                        <th>Usertype - </th> 
                    </tr>
                </thead>
                <tbody>
                    <%
                        LoginService loginService = new LoginService();
                        Jlinux_User u = loginService.getUserByUserId_s(user.getUser_name());
//                        for (Jlinux_User u : list) {
                    %>
                    <tr>
                        <td><%=u.getUser_name()%></td>
                        <td><%=u.getFname()%></td>
                        <td><%=u.getMname()%></td>
                        <td><%=u.getLname()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getPasswd()%></td>
                        <td><%=u.getUsertype()%></td>
                    </tr>
                    <% //}%>
                <tbody>
            </table>    
            <br/>
        </div>
       <a class="btn btn-info" href="../logout.jsp">Logout</a> <a class="btn btn-info" href="add_monitor_host.jsp">Add the New host</a> <a class="btn btn-info" href="../logout.jsp">Update the host information </a>          
                
    </center>
    <%@include file="footer.html" %> 
</html>
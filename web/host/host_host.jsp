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
         <h1>Hardware Page</h1>
             <b>Hardware Result Page</b><br/>
             <%=new Date()%></br>
             <%
                 Map<String,String> user = session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getFname() + " " + user.getLname()%></b>     
             <br/>
             <a href="../logout.jsp">Logout</a>
               
         <table> 
             <thead>
                 <tr>
                     <th>Host_name</th>
                     <th>Access_time</th>
                     <th>Kernel_name</th>
                     <th>LinuxOs_ID</th>
                     <th>Active</th>   
                     <th>User_name</th>  
                     <th>UserID</th>  
                 </tr>
             </thead>
             <tbody>
                 <%  String Host_name = "192.168.2.106 ";
                     List<Host> list = Network_data.selectByHost_name(Host_name);
                     for (Network n : list) {
                 %>
                 <tr>
                     <td><%=n.getHost_name()%></td>
                     <td><%=n.getNet_name()%></td>
                     <td><%=n.getIpv4()%></td>
                     <td><%=n.getIpv6()%></td>
                     <td><%=n.getAccess_time()%></td>
                     <td><%=n.getMTU()%></td>
                     <td><%=n.getLink_encap()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
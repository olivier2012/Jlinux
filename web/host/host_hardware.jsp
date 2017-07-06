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
          <b>You from Host name : <%= request.getRemoteHost() + "   IP Address : " + request.getRemoteAddr()+ "------ Port: "+ request.getRemotePort()%></b>   
           <br/>
             <%=new Date()%></br>
             <%
                 Jlinux_User user = (Jlinux_User) session.getAttribute("user");
             %>     
             <b>Welcome <%= user.getFname() + " " + user.getLname()+ "------ UserID: "+ user.getUserId()%></b>     
             <br/>
             <a class="btn btn-info" href="../logout.jsp">Logout</a> <a class="btn btn-info" href="add_monitor_host.jsp">Add the New host</a> <a class="btn btn-info" href="../logout.jsp">Update the host information </a>
               
         <table> 
             <thead>
                 <tr>
                     <th>Host_name</th>
                     <th>Net_name</th>
                     <th>IPv4</th>
                     <th>IPv6</th>
                     <th>Access_time</th>   
                     <th>MTU</th>  
                     <th>Link_Encap</th>  
                 </tr>
             </thead>
             <tbody>
                 <%  String Host_name = user.getHost_name();
                     List<Jlinux_Network> list = Network_data.selectByHost_name(Host_name);
                     for (Jlinux_Network n : list) {
                 %>
                 <tr>
                     <td><%=n.getH_Host_name()%></td>
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
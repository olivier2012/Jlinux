<%@page import="Hiber.DB.hw.Jlinux_Host"%>
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
             <a class="btn btn-info" href="logout.jsp">Logout</a> <a class="btn btn-info" href="add_monitor_host.jsp">Add the New host</a> <a class="btn btn-info" href="../logout.jsp">Update the host information </a>
             <br/>
             <%
               List<Jlinux_Host> list = (List<Jlinux_Host>) session.getAttribute("list_jhost");
               if (list==null){
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                   list = Host_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
             
         <table> 
             <thead>
                 <tr>
                     <td>User Id  </td>
                     <td>Host Id</td>
                     <td>H_Host_name</td>
                     <td>H_User_name</td>
                     <td>H_Passwd</td>
                     <td>Host_UUID</td>
                     <td>Active</td>
                     <td>Created_time</td>
                     <td>H_Host_port</td>
                 </tr>
             </thead>
             <tbody>
                 <%  
                     for (Jlinux_Host n : list) {
                 %>
                 <tr>
                     <td><%=n.getUserId() %></td>
                     <td><%=n.getHostId() %></td>
                     <td><%=n.getH_Host_name()%></td>
                     <td><%=n.getH_User_name() %></td>
                     <td><%=n.getH_Passwd() %></td>
                     <td><%=n.getHost_UUID() %></td>
                     <td><%=n.getActive() %></td>
                     <td><%=n.getCreated_time() %></td>
                     <td><%=n.getH_Host_port() %></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
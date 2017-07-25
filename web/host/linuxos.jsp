
<%@page import="Hiber.DB.Sys.*"%>
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
         <h1>Linux OS  Page</h1>
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
               List<Jlinux_LinuxOs> list = (List<Jlinux_LinuxOs>) session.getAttribute("list_linuxos");
               if (list==null){
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                   list = LinuxOs_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
             
         <table> 
             <thead>
                 <tr>
                     <td>Kernel_name</td>
                     <td>Node_name</td>
                     <td>Kernel_version</td>
                     <td>Hardware_platform</td>
                     <td>Architecture</td>
                     <td>Operate_system</td>
                     <td>Kernel_version</td>
                 </tr>
             </thead>
             <tbody>
                 <%  
                     for (Jlinux_LinuxOs n : list) {
                 %>
                 <tr>
                     <td><%=n.getKernel_name()    %></td>
                     <td><%=n.getNode_name() %></td>
                     <td><%=n.getKernel_name() %></td>
                     <td><%=n.getHardware_platform() %></td>
                     <td><%=n.getArchitecture() %></td>
                     <td><%=n.getOperate_system() %></td>
                     <td><%=n.getKernel_version() %></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
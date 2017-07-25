<%@page import="java.util.ArrayList"%>
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
         <h1>Linux Node status : </h1>
          <b>You from Host name : <%= request.getRemoteHost() + "   IP Address : " + request.getRemoteAddr()+ "------ Port: "+ request.getRemotePort()%></b>   
           <br/>
             <%=new Date()%></br>
             <%
                 Jlinux_User user = (Jlinux_User) session.getAttribute("user");
                  List<Jlinux_Host> list = new ArrayList()  ; 
             %>     
             <b>Welcome <%= user.getFname() + " " + user.getLname()+ "------ UserID: "+ user.getUserId()%></b>     
             <br/>
             <a class="btn btn-info" href="logout.jsp">Logout</a> <a class="btn btn-info" href="add_monitor_host.jsp">Add the New host</a> <a class="btn btn-info" href="../logout.jsp">Update the host information </a>
             <br/>
             <%
              
                     list  = (List<Jlinux_Host>) session.getAttribute("list_jhost");
               if (list==null){
               try{
                   list = Host_data.selectByUserid(user);
                  }catch(Exception e) {
                     request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                  }
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
//                   list = Host_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
                          <!--<hr>-->
 <svg id="i-ellipsis-horizontal" viewBox="0 0 32 32" width="32" height="32" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
    <circle cx="7" cy="16" r="2" />
    <circle cx="16" cy="16" r="2" />
    <circle cx="25" cy="16" r="2" />
</svg>

             <div class = "svg-container" id="desktop">
     <svg id="i-desktop" viewBox="0 0 32 32" width="32" height="32" fill="red" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
    <path d="M10 29 C10 29 10 24 16 24 22 24 22 29 22 29 L10 29 Z M2 6 L2 23 30 23 30 6 2 6 Z" />
                 </svg>
                 
             <!--</div>--> 
             <!--<hr/>-->
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
                     <td><%=n.getUser().getUserId() %></td>
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
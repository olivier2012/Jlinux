<%@page import="Hiber.DB.hw.Jlinux_HDisk"%>
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
         <h1>Hardware Hard Disk Page</h1>
             <%=new Date()%></br>
            <%
                Jlinux_User user = (Jlinux_User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>  
                         <%
            List<Jlinux_HDisk> list = (List<Jlinux_HDisk>) session.getAttribute("list_cpu");
               if (list==null){
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                   list = HDisk_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
         <table> 
             <thead>
                 <tr>
                     <th>Hddisk_name</th>
                     <th>Majmin</th>
                     <th>Mounted_on</th>
                     <th>Partition_type</th>
                     <th>Size</th>   
                     <th>RO</th>  
                     <th>RM</th>  
                 </tr>
             </thead>
             <tbody>
              <%
                   
                        for (Jlinux_HDisk n : list) {
                    %>
                 <tr>
                     <td><%=n.getHddisk_name() %></td>
                     <td><%=n.getMajmin()%></td>
                     <td><%=n.getMounted_on()%></td>
                     <td><%=n.getPartition_type()%></td>
                     <td><%=n.gethdSize()%></td>
                     <td><%=n.getRO()%></td>
                     <td><%=n.getRM()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
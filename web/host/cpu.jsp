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
         <h1>Hardware CPU Page</h1>
             <%=new Date()%></br>
            <%
                Jlinux_User user = (Jlinux_User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>  
                         <%
            List<Jlinux_CPU> list = (List<Jlinux_CPU>) session.getAttribute("list_cpu");
               if (list==null){
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                   list = CPU_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
         <table> 
             <thead>
                 <tr>
                     <th>USER   ID   </th>
                     <th>Model_name</th>
                     <th>Model</th>
                     <th>Cpu_family</th>
                     <th>Vendor_id</th>
                     <th>Processor</th>   
                     <th>Stepping</th>  
                     <th>Cpu_mhz</th>  
                 </tr>
             </thead>
             <tbody>
              <%
                   
                        for (Jlinux_CPU n : list) {
                    %>
                 <tr>
                     <td><%=n.getJ_UserId() %></td>
                     <td><%=n.getModel_name() %></td>
                     <td><%=n.getModel()%></td>
                     <td><%=n.getCpu_family()%></td>
                     <td><%=n.getVendor_id()%></td>
                     <td><%=n.getProcessor()%></td>
                     <td><%=n.getStepping()%></td>
                     <td><%=n.getCpu_mhz()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
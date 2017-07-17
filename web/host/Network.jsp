<%@page import="Hiber.DB.hw.Jlinux_Network"%>
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
            List<Jlinux_Network> list = (List<Jlinux_Network>) session.getAttribute("list_cpu");
               if (list==null){
//                   request.getRequestDispatcher("add_monitor_host.jsp").forward(request, response);
                   list = Network_data.selectByH_Host_name("192.168.2.106");
               }
             %> 
         <table> 
             <thead>
                 <tr>
                     <th>Net_cardId</th>
                     <th>Ipv4</th>
                     <th>Ipv6</th>
                     <th>Tx</th>
                     <th>Rx</th>   
                     <th>Link_encap</th>  
                     <th>MTU</th>  
                 </tr>
             </thead>
             <tbody>
              <%
                   
                        for (Jlinux_Network n : list) {
                    %>
                 <tr>
                     <td><%=n.getNet_cardId() %></td>
                     <td><%=n.getIpv4()%></td>
                     <td><%=n.getIpv6()%></td>
                     <td><%=n.getTx()%></td>
                     <td><%=n.getRx()%></td>
                     <td><%=n.getLink_encap()%></td>
                     <td><%=n.getMTU()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
  <%@include file="host_footer.html" %> 
</html>
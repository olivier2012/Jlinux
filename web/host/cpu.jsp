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
  <%
           Object User_name = session.getAttribute("User_name"); 
          if(User_name==null || User_name.toString()==null ||User_name.toString()==""){
            response.sendRedirect("../login.jsp");
          }else{
              Object isLoggedIn = session.getAttribute("isLoggedIn");
              /* 有两处 冗余代码，不知道为什么 在 netbeans 中一直是 “is not a known variable in the current context netbeans” */
              if (isLoggedIn != null)
              {String isLoggedIn1 = isLoggedIn.toString();}
              Object Passwd = session.getAttribute("Passwd");
           
            try{
                 /* 有两处 冗余代码，不知道为什么 在 netbeans 中一直是 “is not a known variable in the current context netbeans” */
               Object  bbresult = session.getAttribute("isLoggedIn");
               }
            catch(Exception e){
               System.out.println("error=" + e.toString());  
            }
            Jlinux_User b_user = (Jlinux_User) session.getAttribute("user");
            /*customer have login , then second time click the Login menu , they will go home page directly*/
           
                out.print("b_user name : "+b_user.getUser_name());
                out.print("     b_passwd  : "+b_user.getPasswd());
                String bb_pass =  b_user.getPasswd();
//            if ( User_name.toString() == b_user.getUser_name() && Passwd.toString() == b_user.getPasswd()) {
            if ( Integer.parseInt(isLoggedIn.toString())==1) {
                response.sendRedirect("../home.jsp");
            } 
            }
                   %>
<center>
     <div id="container">
         <h1>Hardware CPU Page</h1>
             <%=new Date()%></br>
            <%
                Jlinux_User user = (Jlinux_User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>      
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
              <%
                    
                        Jlinux_CPU cpu = CPU_data.Selectbyhostid(user.getUser_name());
//                        for (Jlinux_User u : list) {
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
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
         <%
           Object User_name = session.getAttribute("User_name"); 
          if(User_name==null || User_name.toString()==null ||User_name.toString()==""){}else{
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
            String userResult = "0";
                   %>
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
                   response.sendRedirect("add_monitor_host.jsp");
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
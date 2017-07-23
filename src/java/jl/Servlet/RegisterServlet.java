package jl.Servlet;

import Hiber.DB.hw.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jl.service.RegisterService;
 
 
 
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     String firstName = request.getParameter("Fname");
     String middleName = request.getParameter("Mname");
     String lastName = request.getParameter("Lname");
     String email = request.getParameter("email");
     String User_name = request.getParameter("User_name");
     String Passwd = request.getParameter("Passwd");
     String c_Host_IP = request.getRemoteAddr();
     String usertype ="register_client";
     Date cdate = new Date();
     boolean email_confirm = false;
     Jlinux_User user = null;
     try{
     if(email==null||email.isEmpty()||User_name==null||User_name.isEmpty()){
            String MESSAGE = null;
            request.setAttribute(MESSAGE, "email or User_name is empty, please check ");
            request.getRequestDispatcher("error.jsp").forward(request, response);
         return ;
     }
     else{
       user = new Jlinux_User(c_Host_IP,User_name,firstName,middleName,lastName,Passwd,usertype, cdate,cdate,email,email_confirm);
     }  
         RegisterService registerService = new RegisterService();
         boolean result = registerService.register(user);      
         if(result){
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("session_result", result);
            request.getRequestDispatcher("register_successful.jsp").forward(request, response);
         }else{
            request.getSession().setAttribute("session_result", result);
            response.sendRedirect("register_failed.jsp");
         }

}catch(Exception e){
    e.printStackTrace();
}}
 
    @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException{doPost(request,response);}
}
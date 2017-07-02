package jl.Servlet;

import Hiber.DB.hw.User;
import jl.service.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

 
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
     String User_name = request.getParameter("User_name");   
     String Passwd = request.getParameter("Passwd");
     LoginService loginService = new LoginService();
     boolean result = loginService.authenticateUser(User_name, Passwd);
     User user = loginService.getUserByUserId(Passwd);
     if(result == true){
         request.getSession().setAttribute("user", user);      
         response.sendRedirect("home.jsp");
     }
     else{
         response.sendRedirect("error.jsp");
     }
}
 
}
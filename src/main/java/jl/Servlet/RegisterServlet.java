package jl.Servlet;

import Hiber.DB.hw.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jl.service.RegisterService;
 
 
 
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     String firstName = request.getParameter("Fname");
     String middleName = request.getParameter("Mname");
     String lastName = request.getParameter("Lname");
     String email = request.getParameter("Email");
     String User_name = request.getParameter("User_name");
     String Passwd = request.getParameter("Passwd");
     User user = new User(firstName,middleName,lastName, email,User_name, Passwd);
             
     try { 
         RegisterService registerService = new RegisterService();
         boolean result = registerService.register(user);      
         out.println("<html>");
         out.println("<head>");      
         out.println("<title>Registration Successful</title>");    
         out.println("</head>");
         out.println("<body>");
         out.println("<center>");
         if(result){
             out.println("<h1>Thanks for Registering with us :</h1>");
             out.println("To login with new User_name and Password <a href=login.jsp>Click here</a>");
         }else{
             out.println("<h1>Registration Failed</h1>");
             out.println("To try again<a href=register.jsp>Click here</a>");
         }
         out.println("</center>");
         out.println("</body>");
         out.println("</html>");
     } finally {       
         out.close();
     }
}
 
}
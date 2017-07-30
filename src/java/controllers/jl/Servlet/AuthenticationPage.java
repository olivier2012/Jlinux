package controllers.jl.Servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationPage extends HttpServlet {

    final static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(AuthenticationPage.class.getName());

    public static final String Linux_IP_Address = "Linux_Host_IP";
    public static final String Linux_Username = "User_name";
    public static final String MESSAGE = "message";
    public static String Pass = "Password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        HttpSession session = req.getSession(false);   	//this method returns session only if it is already created
        ArrayList<String> UserOp2 = new ArrayList<String>();
        UserOp2.add(req.getContextPath() + req.getServletPath() + "?" + req.getPathInfo() + req.getQueryString());
//        session.setAttribute("UserOp2", UserOp2);
//        RequestDispatcher rd = req.getRequestDispatcher("navigator.html");
//        rd.include(req, resp);
        if (session != null && session.getAttribute(Linux_IP_Address) != null) { //if session created and has first name
            pw.println("<b style='color : green'>You already logged in, Mr./Mrs.\""
                    + session.getAttribute(Linux_IP_Address) + "  "
                    + session.getAttribute(Linux_Username)
                    + "\" </b> You may go to <a href='Login'><i>Login page</i></a>");
            return;		//for authenticated user show only welcome message 
        }

        //show form for authentication if a user is not identified yet
        pw.println("<style> label {float: left; width : 200px} </style>");
        pw.println("<h2 style='color:navy'>Login  Linux  System  Information </h2>");
        if (req.getAttribute(MESSAGE) != null) {  	      //print message if it's set on another page
            pw.println("<b style='color:red'>" + req.getAttribute(MESSAGE) + "</b>");
        }

        pw.println("<form action='Login' method='post'>");
        pw.println("<label>IP address : </label><input type='text' placehold='127.0.0.1' required name='" + Linux_IP_Address + "'><br/>");
        pw.println("<label>User name : </label><input type='text' name='" + Linux_Username + "'><br/>");
        pw.println("<label>Password : </label><input type='password'  placehold='input the password' required name='" + Pass + "'><br/>");
        pw.println("<label>Got Information</label><input type='submit' value='Submit'>");
        pw.println("</form>");
        pw.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

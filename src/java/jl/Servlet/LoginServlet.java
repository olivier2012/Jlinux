package jl.Servlet;

import Hiber.DB.hw.*;
import Hiber.HibUtil;
import jl.service.LoginService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jl.function.Network_function;
import jl.function.host_function;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginServlet extends HttpServlet {
    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(LoginServlet.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try  to get the http session   and  hibernate session   */
        HttpSession s_session = request.getSession();
        SessionFactory sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        try{
            String User_name = request.getParameter("User_name");
            String Passwd = request.getParameter("Passwd");
                s_session.setAttribute("Passwd", Passwd);
                s_session.setAttribute("User_name", User_name);
                LoginService loginService = new LoginService();
                String isLoggedIn = "0";
                boolean result = loginService.authenticateUser(User_name, Passwd, dbsession);
                if (result == true) {
                Jlinux_User user = loginService.getUserByUserId(User_name, dbsession);
                List<Jlinux_Host> list_jhost = host_function.getHostByUser_ID(user, dbsession);
                dbsession.close();
                    isLoggedIn="1";
                    s_session.setAttribute("user", user);
                    s_session.setAttribute("isLoggedIn", isLoggedIn);
                    /*all of  user information will be keep in the session attribute , other servlet just call them and judge .*/
                    if (!list_jhost.isEmpty()) {
                        s_session.setAttribute("list_jhost", list_jhost);
                    }
                    request.getRequestDispatcher("home.jsp").forward(request, response);
//                    response.sendRedirect("home.jsp");
                } else {
                    request.setAttribute("isLoggedIn",isLoggedIn);
                    request.getRequestDispatcher("RegisterServlet").forward(request, response);
//                    response.sendRedirect("RegisterServlet");
                }
        }catch(Exception e){
            String MESSAGE = "";
            request.setAttribute(MESSAGE, e.toString());
         request.getRequestDispatcher("register.jsp").forward(request, response);
//           response.sendRedirect("http://localhost:8088/jLinux_jl/RegisterServlet");
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

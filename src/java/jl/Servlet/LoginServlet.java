package jl.Servlet;

import Hiber.DB.hw.User;
import Hiber.HibUtil;
import jl.service.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try  to get the http session   and  hibernate session   */
        HttpSession s_session = request.getSession();
        SessionFactory  sFactory = HibUtil.getSessionFactory(); 
        Session dbsession = sFactory.openSession();
        /* 判断 http session 是不是第一次登录 ，如果是的话*/
        if (s_session == null) {
            if(dbsession ==null){
               sFactory = HibUtil.getSessionFactory(); 
               dbsession = (Session) sFactory.openStatelessSession();
            } 
            String MESSAGE = null;
            request.setAttribute(MESSAGE, "Start with this page, please");
            request.getRequestDispatcher("/RegisterServlet").forward(request, response);
            return;
        } else {
            if (s_session.isNew()) {
//                 sFactory = HibUtil.getSessionFactory(); 
                 dbsession = sFactory.openSession();
//                 dbsession = sFactory.getCurrentSession();
            }else{
//                 dbsession = sFactory.getCurrentSession();
            }       
                String User_name = request.getParameter("User_name");
                String Passwd = request.getParameter("Passwd");
                s_session.setAttribute("Passwd", Passwd);
                s_session.setAttribute("User_name", Passwd);
                LoginService loginService = new LoginService();
                boolean result = loginService.authenticateUser(User_name, Passwd, dbsession);
                User user = loginService.getUserByUserId(Passwd, dbsession);
                dbsession.close();
                if (result == true) {
                    /*all of  user information will be keep in the session attribute , other servlet just call them and judge .*/
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("session_result", result);
                    response.sendRedirect("home.jsp");
                } else {
                    request.getSession().setAttribute("session_result", result);
                    response.sendRedirect("error.jsp");
                }
        }
    }
    
      public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {doPost(request,response);}
}

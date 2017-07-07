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
        /* 判断 http session 是不是第一次登录 ，如果是的话*/
        if (s_session == null) {
            if (dbsession == null) {
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
            } else {
//                 dbsession = sFactory.getCurrentSession();
            }
            String User_name = request.getParameter("User_name");
            String Passwd = request.getParameter("Passwd");
//            boolean b_result = Boolean.parseBoolean(request.getParameter("result"));
//            Jlinux_User b_user = (Jlinux_User) request.getAttribute("user");
//            /*customer have login , then second time click the Login menu , they will go home page directly*/
//            if (b_result && User_name == b_user.getUser_name() && Passwd == b_user.getPasswd()) {
//                response.sendRedirect("home.jsp");
//            } else {
                s_session.setAttribute("Passwd", Passwd);
                s_session.setAttribute("User_name", User_name);
                LoginService loginService = new LoginService();
                boolean result = loginService.authenticateUser(User_name, Passwd, dbsession);
                Jlinux_User user = loginService.getUserByUserId(Passwd, dbsession);
                List<Jlinux_Host> list_jhost = host_function.getHostByUser_ID(user.getUserId(), dbsession);
                dbsession.close();
                if (result == true) {
                    /*all of  user information will be keep in the session attribute , other servlet just call them and judge .*/
                    if (!list_jhost.isEmpty()) {
                        s_session.setAttribute("list_jhost", list_jhost);
                    }
                    s_session.setAttribute("user", user);
                    s_session.setAttribute("session_result", 1);
                    response.sendRedirect("home.jsp");
                } else {
                    s_session.setAttribute("session_result", 0);
                    response.sendRedirect("error.jsp");
                }
     //       }
        }}catch(Exception e){
        log.info(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

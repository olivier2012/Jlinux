package controllers.jl.Servlet.hardware;

import model.Hiber.DB.hw.*;
import controllers.jl.service.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hiber.DB.hw.Jlinux_User;
import model.Hiber.HibUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HardwareServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try  to get the http session   and  hibernate session   */
        HttpSession s_session = request.getSession();
        SessionFactory  sFactory = HibUtil.getSessionFactory(); 
        Session dbsession = sFactory.openSession();
        try{
        String User_name = (String) s_session.getAttribute("User_name");
        String Passwd = (String) s_session.getAttribute("Passwd");
        /* 判断 http session 是不是第一次登录 ，如果是的话*/
        if (s_session == null&&dbsession ==null) {
            String MESSAGE = null;
            request.setAttribute(MESSAGE, "Start with this page, please");
            request.getRequestDispatcher("/home.html").forward(request, response);
            return;
        } else {
            if (s_session.isNew()) {
                if(User_name==null||User_name.isEmpty()||Passwd==null||Passwd.isEmpty())
                {
            String MESSAGE = null;
            request.setAttribute(MESSAGE, "Start with this page, please");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
                }
            }else{
                LoginService loginService = new LoginService();
                boolean result = loginService.authenticateUser(User_name, Passwd, dbsession);
                Jlinux_User user = loginService.getUserByUserId(Passwd, dbsession);
                dbsession.close();
                if (result == true) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("host\\host_hardware.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
          }
        }
    }catch(Exception e){
            response.sendRedirect("error.jsp");
         }
        
        
    }
    
    @Override
      public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doPost(request,response);
        }
}

package jl.Servlet;

import Hiber.DB.hw.*;
import Hiber.HibUtil;
import jl.service.LoginService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jl.service.add_monitor_host_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/*http://localhost:8088/jLinux_jl/amh_servlet?H_Host_name=192.168.2.106&H_User_name=demo&H_Passwd=demo  test address */
/*http://localhost:8088/jLinux_jl/amh_servlet?H_Host_name=172.16.17.57&H_User_name=demo&H_Passwd=demo  test address */  

public class add_monitor_host_servlet extends HttpServlet {
    public static String H_Host_name = "Linux_Host_IP";
    public static  String H_User_name = "User_name";
    public static  String H_Passwd = "message";
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try  to get the http session   and  hibernate session   */
        HttpSession s_session = request.getSession();
        SessionFactory  sFactory = HibUtil.getSessionFactory(); 
        Session dbsession = sFactory.openSession();
        H_Host_name = request.getParameter("H_Host_name");
        H_User_name = request.getParameter("H_User_name");
        H_Passwd = request.getParameter("H_Passwd");
        s_session.setAttribute("H_Host_name", H_Host_name);
        s_session.setAttribute("H_User_name", H_User_name);
        s_session.setAttribute("H_Passwd", H_Passwd);
       /* try{
        String User_name = (String) s_session.getAttribute("User_name");
        String Passwd = (String) s_session.getAttribute("Passwd");
        /* 判断 http session 是不是第一次登录 ，如果是的话*/
    /*    if (s_session == null&&dbsession ==null) {
            String MESSAGE = null;
            request.setAttribute(MESSAGE, "Start with this page, please");
            request.getRequestDispatcher("/index.html").forward(request, response);
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
            }else{  */
                /*call every service for collect host information : cpu, host, linuxos,hddisk,accessory,network,monitor*/
                add_monitor_host_service amhs = new add_monitor_host_service(); 
                boolean amhs_result = amhs.checkallofhw(H_Host_name,H_User_name,H_Passwd);

                if (amhs_result == true) {
                   // response.sendRedirect("host/show_host_details.jsp");
                } else {
                  //  response.sendRedirect("error.jsp");
                }
   /*       }
        }
   }catch(Exception e){
            response.sendRedirect("error.jsp");
         }*/
    }
    
    @Override
      public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doPost(request,response);
        }
}

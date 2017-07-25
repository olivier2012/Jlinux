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
import jl.service.add_monitor_host_service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/*http://localhost:8088/jLinux_jl/amh_servlet?H_Host_name=192.168.2.106&H_User_name=demo&H_Passwd=demo  test address */
/*http://localhost:8088/jLinux_jl/amh_servlet?H_Host_name=172.16.17.57&H_User_name=demo&H_Passwd=demo  test address */  

public class add_monitor_host_servlet extends HttpServlet {
    public static String H_Host_name = "Linux_Host_IP";
    public static  String H_User_name = "User_name";
    public static  String H_Passwd = "message";
    public static  Jlinux_User web_login_user ; 
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*try  to get the http session   and  hibernate session   */
        
        HttpSession s_session = request.getSession();
        SessionFactory  sFactory = HibUtil.getSessionFactory(); 
        Session dbsession = sFactory.openSession();
        H_Host_name = request.getParameter("H_Host_name");
        H_User_name = request.getParameter("H_User_name");
        H_Passwd = request.getParameter("H_Passwd");
        web_login_user = (Jlinux_User) s_session.getAttribute("user");
        
        
        s_session.setAttribute("H_Host_name", H_Host_name);
        s_session.setAttribute("H_User_name", H_User_name);
        s_session.setAttribute("H_Passwd", H_Passwd);
                add_monitor_host_service amhs = new add_monitor_host_service(); 
                Jlinux_Host jhost = amhs.checkallofhw(H_Host_name,H_User_name,H_Passwd,web_login_user);

                if (jhost.getClass().getName().isEmpty()) {
                   response.sendRedirect("error.jsp");
                } else {
                   s_session.setAttribute("jhost", jhost);
                   boolean add_host_flag=true;
                   List<Jlinux_Host> list_host =  (List<Jlinux_Host>) s_session.getAttribute("list_host");
                   for(Jlinux_Host tmp_host: list_host){
                     if(tmp_host.getH_Host_name()==H_Host_name)
                         add_host_flag=false;
                      }
                   if(add_host_flag){
                     list_host.add(jhost);
                   }
                   s_session.setAttribute("list_host", list_host);
                   response.sendRedirect("user.jsp");
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

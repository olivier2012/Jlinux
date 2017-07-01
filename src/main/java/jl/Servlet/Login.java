package jl.Servlet;

import Hiber.DB.hw.User_data;
import Hiber.HibUtil;
import com.jcraft.jsch.JSch;
import java.io.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import jl.JL_network;
import org.hibernate.SessionFactory;


//this class creates session and adds to it info about user first name and last name
public class Login extends HttpServlet {
    final static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Login.class.getName());
//    private String connectionURL;   //field for storage of  DB  connection string
    HashMap<String, String> AL_http = new HashMap<String, String>();

    ArrayList<String> UserOp = new ArrayList<String>();
/*
    public void init() {          //this method is used for one-time activities , it's called when servlet is initialized 
//        connectionURL = getServletContext().getInitParameter("connect_string");
         JSch servlet_jsch;
         SessionFactory sFactory;
        try {
            servlet_jsch = new JSch();
            sFactory = HibUtil.getSessionFactory();
            
            /*loading Oracle driver, usually is done automatically*/
//            Class.forName("oracle.jdbc.driver.OracleDriver");
     /*   } catch (Exception ex) {
            System.out.println("\t" + ex);
        }
    }*/


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        SessionFactory sFactory = HibUtil.getSessionFactory();
        sFactory.getCurrentSession().beginTransaction();
        PrintWriter pw = resp.getWriter();
        HashMap<String,String> hm_requestParam = new HashMap<String,String>();
        hm_requestParam.put("Linux_Host_IP",req.getParameter("Linux_Host_IP"));
        hm_requestParam.put("User_name",req.getParameter("User_name"));
        hm_requestParam.put("Password",req.getParameter("Password"));
        hm_requestParam.put("Usertype","linux");
        hm_requestParam.put("Adate",(new Date()).toString());
        User_data.add(hm_requestParam, sFactory);
       
        HttpSession session = req.getSession(); //get existent session or create a new one if id doesn't exist 

        UserOp.add(req.getContextPath() + req.getServletPath() + "?" + req.getPathInfo() + req.getQueryString());

        pw.println("<body><h2 style='color:green'>Linux  System  Information</h2>");

        pw.println("<br/><p style=\"font-family:serif ; font-size: 20px ;\">You choice <span style=\" color: red \"> " + AL_http.size() + " </span>Items . Total CAD$: <span style=\" color: red \"></span> Dollars <hr/>");
        // pw.println("<hr/><a href='purchase?invalidate'>Invalidate session now</a>");
        pw.println("Linux_Host_IP : " + hm_requestParam.get("Linux_Host_IP"));
        pw.println("<table border =1px;>");
        pw.println("<tr><th> Name </th><th>   Price </th><th> Purchase </th></tr>");
//            readall(connectionURL, pw, AL_http, fname, fprice, resp);
        pw.println("</table>");
        pw.println("<input type='button' value='Check In Your Purchase(s)' onclick=\"window.location='/WebApplicationSession" + "/Checkin" + "'\"/>");
        pw.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) //call doGet()
            throws ServletException, IOException {
        doGet(req, resp);
    }

}

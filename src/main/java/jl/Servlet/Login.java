package jl.Servlet;

import java.io.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;


//this class creates session and adds to it info about user first name and last name
public class Login extends HttpServlet {

    private String connectionURL;   //field for storage of  DB  connection string
    HashMap<String, String> AL_http = new HashMap<String, String>();
    // JSONObject UAjson = new JSONObject();
    //int index = 0 ;
    ArrayList<String> UserOp = new ArrayList<String>();

    public void init() {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {
            /*loading Oracle driver, usually is done automatically*/
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception ex) {
            System.out.println("\t" + ex);
        }
    }

    public Boolean isExist(String name, HashMap AL_http) {
        return AL_http.containsKey(name);
    }

    private String replaceHash(String orig) {
        return orig.replace("#", "_HaSh_");
    }

    private String replaceHashBack(String orig) {
        return orig.replace("_HaSh_", "#");
    }

    public float mytotal(HashMap AL_http) {
        Object[] cltmp = AL_http.values().toArray();
        float total = 0;
        float patmp = 0;
        for (Object c : cltmp) {
            patmp = Float.parseFloat((String) c);
            total = total + patmp;
        }
        return total;
    }

    public void readall(String connectionURL, PrintWriter pw, HashMap AL_http, String fname, String fprice, HttpServletResponse resp) throws SQLException {
        try (
                Connection con = DriverManager.getConnection(connectionURL);
                Statement stmt = con.createStatement();) {

            ResultSet rs = null;
            rs = stmt.executeQuery("select name , price from books");
            while (rs != null && rs.next()) {
                if (AL_http.containsKey(rs.getString("name"))) {
                    pw.println("<tr style=\"background-color: yellow;\" ><td> " + rs.getString("name") + "</td><td> " + rs.getString("price")
                            + "</td><td><input type='button' value='bought' onclick=\"window.location='" + "purchase32?name=" + replaceHash(rs.getString("name")) + "&price=" + rs.getFloat("price") + "'\"; /></td></tr>");
                    /*
                                       pw.println("<tr style=\"background-color: yellow;\" ><td> " +  rs.getString("name") + "</td><td> " + rs.getString("price")
                            + "</td><td><input type='button' value='bought' onclick=" + "\"window.location='purchase3?name=" + Escapstring(rs.getString("name")) + "&price=" + rs.getFloat("price") + "\'\"; /></td></tr>");*/
                } else {
                    pw.println("<tr><td> " + rs.getString("name") + "</td><td> " + rs.getString("price")
                            + "</td><td><input type='button' value='buy' onclick=\"window.location='" + "purchase32?name=" + replaceHash(rs.getString("name")) + "&price=" + rs.getFloat("price") + "'\"; /></td></tr>");
                }
            }
            return;
        } catch (Exception ex) {
            pw.println(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        HttpSession session = req.getSession(); //get existent session or create a new one if id doesn't exist 
        String fname = req.getParameter("name");
        String fprice = req.getParameter("price");
        String inval = req.getParameter("invalidate");

        UserOp.add(req.getContextPath() + req.getServletPath() + "?" + req.getPathInfo() + req.getQueryString());

        if (fname == null || fname.isEmpty() || fprice == null || fprice.isEmpty()) {

        } else {
            if (!AL_http.containsKey(fname)) {
                AL_http.put(replaceHashBack(fname), fprice);
                UserOp.add(req.getRequestURI().toString());
                session.setAttribute("AL_http", AL_http);
                session.setAttribute("UserOp", UserOp);
            }
            //           }
        }

        pw.println("<body><h2 style='color:green'>Purchase of books page</h2>");
        RequestDispatcher rd = req.getRequestDispatcher("navigator.html");
        rd.include(req, resp);
        /*     pw.println("<hr/>ContextPath=<b style='color:red'>" + req.getContextPath() + "<br/>");
        pw.println("ServletPath=<b style='color:blue'>" + req.getServletPath() + "<br/>");
        pw.println("PathInfo=<b style='color:orange'>" + req.getPathInfo() + "<br/>");
        pw.println("QueryString=<b style='color:green'>" + req.getQueryString() + "<br/>");
        pw.println("Welcome, <b>" + req.getParameter("name") + "  "
                + req.getParameter("price") + "</b>");
        pw.println("your IP address is :  " + req.getRemoteAddr() + "  your port is : " + req.getRemotePort()
                + "  your host name is  : " + req.getRemoteHost()); */

        pw.println("<br/><p style=\"font-family:serif ; font-size: 20px ;\">You choice <span style=\" color: red \"> " + AL_http.size() + " </span>Items . Total CAD$: <span style=\" color: red \">" + mytotal(AL_http) + " </span> Dollars <hr/>");
        // pw.println("<hr/><a href='purchase?invalidate'>Invalidate session now</a>");
        pw.println("<table border =1px;>");
        pw.println("<tr><th> Name </th><th>   Price </th><th> Purchase </th></tr>");
        try {
            readall(connectionURL, pw, AL_http, fname, fprice, resp);
        } catch (SQLException ex) {
            Logger.getLogger(BookPurchasePage_arrylist_31.class.getName()).log(Level.SEVERE, null, ex);
        }
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

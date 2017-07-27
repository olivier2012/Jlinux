package controllers.jl.Servlet.hardware;

import Hiber.DB.hw.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Servlet_function extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    public  void show_all_sess_attributes() {
        
        Enumeration<?> e = getServletContext().getAttributeNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();

            // Get the value of the attribute
            Object value = getServletContext().getAttribute(name);

            if (value instanceof Map) {
                for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
            } else if (value instanceof List) {
                for (Object element : (List) value) {
                    System.out.println(element);
                }
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

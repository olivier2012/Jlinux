/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.HibUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jl.JL;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class User_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(User_data.class.getName());
    public static void add(HashMap hm_User,SessionFactory sFactory){
        log.debug("add the"+ Class.class.getName()+" cpu infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        User user = new User();
        user.setAdate(new Date());
        user.setHost_name((String) hm_User.get("Linux_Host_IP"));
        user.setHost_IP((String) hm_User.get("Linux_Host_IP"));
        user.setUser_name((String) hm_User.get("User_name"));
        user.setPasswd((String) hm_User.get("Host_IP"));
        user.setFname((String) hm_User.get("Fname"));
        user.setLname((String) hm_User.get("Lname"));
        user.setPasswd((String) hm_User.get("Password"));
        /*usertype : admin , user , client ,linux_user*/
        user.setUsertype((String) hm_User.get("Usertype"));
        user.setCdate((Date) new Date());
        user.setAdate((Date) hm_User.get("Adate"));
        user.setEmail((String) hm_User.get("microcode"));
        
        dbsession.persist(user);
        tr.commit();        
        dbsession.close();
//        add_sFactory.close();
      log.debug("add the Hdisk infomation to database...finished ");
     }
    }

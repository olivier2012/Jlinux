/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.DAO.Jlinux_User_DAO;
import Hiber.DAO.Jlinux_User_DAO_Impl;
import static Hiber.DB.hw.Network_data.Is_selectbyHostname;
import Hiber.HibUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jl.JL;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author olivier-h
 */
public class User_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(User_data.class.getName());
     private static Jlinux_User_DAO jlinux_user_dao;
     
     public User_data(){
        jlinux_user_dao = new Jlinux_User_DAO_Impl(); 
      }
     
    public Jlinux_User_DAO jlinux_user_dao(){
     return jlinux_user_dao();
    }
    
    public void update(Jlinux_User user){
         jlinux_user_dao.openCurrentSessionwithTransaction();
         jlinux_user_dao.updateJlinux_User(user);
         jlinux_user_dao.closeCurrentSessionwithTransaction();
     }
     
    public void insert(Jlinux_User user){
         jlinux_user_dao.openCurrentSessionwithTransaction();
         jlinux_user_dao.insertJlinux_UserTable(user);
         jlinux_user_dao.closeCurrentSessionwithTransaction();
     }
    
    public void delete(long UserId){
         jlinux_user_dao.openCurrentSessionwithTransaction();
         jlinux_user_dao.deletebyJlinux_Users(UserId);
         jlinux_user_dao.closeCurrentSessionwithTransaction();
     }
        
    public Jlinux_User find(String User_name){
         jlinux_user_dao.openCurrentSessionwithTransaction();
         Jlinux_User user = jlinux_user_dao.getJlinux_UserName(User_name);
         jlinux_user_dao.closeCurrentSessionwithTransaction();
         return user;
     }
    
    public List<Jlinux_User> findAll(){
         jlinux_user_dao.openCurrentSessionwithTransaction();
         List<Jlinux_User> list = jlinux_user_dao.getListOfJlinux_Users();
         jlinux_user_dao.closeCurrentSessionwithTransaction();
         return list;
     }
     
    public static void add(HashMap hm_User,SessionFactory sFactory){
        log.debug("add the"+ Class.class.getName()+" cpu infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        boolean flag = Is_selectbyHostname( hm_User,sFactory);
        
        Jlinux_User user = new Jlinux_User();
        
        user.setAdate(new Date());
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
        if(flag){
        dbsession.update(user);
        }else{
        dbsession.persist(user);
        }
        tr.commit();        
        dbsession.close();
//        add_sFactory.close();
      log.debug("add the User infomation to database...finished ");
     }
    
        public static boolean Is_selectbyHostname(HashMap hm_User,SessionFactory sFactory){
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        Jlinux_User juser = (Jlinux_User) dbsession.createCriteria(Jlinux_User.class).add(Restrictions.eq("User_name",hm_User.get("User_name")));
        tr.commit();
        dbsession.close();
        if (juser==null)
            return false;
        else
            return true;  

     }
    }

package jl.service;


import Hiber.DB.hw.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import Hiber.HibUtil;
import java.util.Date;
import org.hibernate.SessionFactory;

 
public class LoginService {
 
    public boolean authenticateUser(String User_name, String Passwd,Session dbsession) {
        Jlinux_User user = getUserByUserId(User_name,dbsession);         
        if(user!=null && user.getUser_name().equals(User_name) && user.getPasswd().equals(Passwd)){
            user.setAdate(new Date());
            return true;
        }else{
            return false;
        }
    }
    
    public Jlinux_User getUserByUserId_s(String User_name){
       Session dbsession1 = null;
        if(dbsession1==null){
     SessionFactory sFactory = HibUtil.getSessionFactory();
     dbsession1 = sFactory.openSession();
        }
        Jlinux_User tmpUser =getUserByUserId(User_name,dbsession1);
        dbsession1.close();
        return tmpUser;
    }
 
    public Jlinux_User getUserByUserId(String User_name,Session dbsession) {
        Transaction tx = null;
        Jlinux_User user = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_User where User_name='"+User_name+"'");
            user = (Jlinux_User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            dbsession.close();
        }
        return user;
    }
    
    public List<Jlinux_User> getListOfUsers(){
        Session dbsession1 = null;
        if(dbsession1==null){
     SessionFactory sFactory = HibUtil.getSessionFactory();
     dbsession1 = sFactory.openSession();
        }
        List tmpUser =getListOfUsers(dbsession1);
        dbsession1.close();
        return tmpUser;
    }
    public List<Jlinux_User> getListOfUsers(Session dbsession){
        List<Jlinux_User> list = new ArrayList<Jlinux_User>();
//        Session session = HibUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;       
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            list = dbsession.createQuery("from Jlinux_User").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return list;
    }
}

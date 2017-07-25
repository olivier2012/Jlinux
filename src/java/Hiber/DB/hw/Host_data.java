/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.HibUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jl.JL;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class Host_data {
    
    final static String TAB_NAME = "Jlinux_Host";
    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Host_data.class.getName());
    
     public static List<Jlinux_Host> selectByH_Host_name(String H_Host_name){
        Session dbsession1 = null;
        if(dbsession1==null){
            SessionFactory sFactory = HibUtil.getSessionFactory();
            dbsession1 = sFactory.openSession();
        }
        List tmpnetwork_data = selectByH_Host_name( H_Host_name,dbsession1);
        dbsession1.close();
        return  tmpnetwork_data;
     }
     
     public static List<Jlinux_Host> selectByH_Host_name(String H_Host_name,Session dbsession){  
         List<Jlinux_Host> list = new ArrayList<Jlinux_Host>();
        Transaction tx = null;
        Jlinux_Host host = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
           Query query = dbsession.createQuery(" from " + TAB_NAME );
           list = query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            dbsession.close();
        }
        return list;
     }
     
     public static void deleteByH_Host_name(String H_Host_name,SessionFactory sFactory){
     
     }
      
     public static List<Jlinux_Host> selectByUserid(Jlinux_User User,Session dbsession){  
         List<Jlinux_Host> list = new ArrayList<Jlinux_Host>();
        Transaction tx = null;
        Jlinux_Host host = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
           Query query = dbsession.createQuery(" from " + TAB_NAME + " where UserId = " + User.getUserId()  );
           list = query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            dbsession.close();
        }
        return list;
     }
               
}

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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class Host_data {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Host_data.class.getName());

    public static void add(HashMap hm,SessionFactory sFactory) {
        log.info("add the network infomation to database ");
//        SessionFactory addd_sFactory = HibUtil.getSessionFactory();
        Session net_dbsession = sFactory.openSession();

        Transaction tr = net_dbsession.beginTransaction();

        Host host = new Host((String) hm.get("Host_name"),Long.parseLong((String) hm.get("UserId")), (String) hm.get("User_name"),new Date());
        net_dbsession.persist(host);
       /* new host data save , then it need to update the User data */
       
        tr.commit();
        net_dbsession.close();
//        addd_sFactory.close();
        log.info("add the network infomation to database...finished ");
    }
    
     public static List<Network> selectByHost_name(String Host_name){
        Session dbsession1 = null;
        if(dbsession1==null){
            SessionFactory sFactory = HibUtil.getSessionFactory();
            dbsession1 = sFactory.openSession();
        }
        List tmpnetwork_data = selectByHost_name( Host_name,dbsession1);
        dbsession1.close();
        return  tmpnetwork_data;
     }
     
     public static List<Network> selectByHost_name(String Host_name,Session dbsession){  
         List<Network> list = new ArrayList<Network>();
        Transaction tx = null;
        Network network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
//            list = dbsession.createQuery("from Network where Host_name='"+Host_name+"'").list();
           list = dbsession.createQuery("from Network").list();
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
     
     public static void deleteByHost_name(String Host_name,SessionFactory sFactory){
     
     }
      
     /*hostmap can update all of column , use match key , and update the value*/
     public static Network UpdateByHost_name(String Host_name,Map<String,String> hostmap,Session dbsession){
        Transaction tx = null;
        Network network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Network where Host_name='"+Host_name+"'");
            network = (Network)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            dbsession.close();
        }
        return network;
     }
               
}

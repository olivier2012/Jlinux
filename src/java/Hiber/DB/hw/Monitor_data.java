/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.DB.Sys.LinuxOs_data;
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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author olivier-h
 */
public class Monitor_data {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Monitor_data.class.getName());

    public static void add(HashMap hm,SessionFactory sFactory,Jlinux_Host jhost) {
        log.info("add the Monitor infomation to database ");
//        SessionFactory addd_sFactory = HibUtil.getSessionFactory();
        Session net_dbsession = sFactory.openSession();

        Transaction tr = net_dbsession.beginTransaction();
        boolean flag = LinuxOs_data.Is_selectbyHostname( jhost,sFactory,net_dbsession,tr);
        Jlinux_Monitor monitor = new Jlinux_Monitor();
          /*  monitor.setH_Host_name(jhost.getH_Host_name());
            monitor.setUser(jhost.getUser());
            monitor.setH_User_name(jhost.getH_User_name());
            monitor.setH_Passwd(jhost.getH_Passwd());
            monitor.setAccess_time(jhost.getAccess_time());
            monitor.setCreated_time(jhost.getCreated_time());
            monitor.setHost_UUID(jhost.getHost_UUID());*/

//        Jlinux_Monitor monitor = new Jlinux_Monitor(jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());

        
        monitor.setDescription((String) hm.get("description"));
        monitor.setProduct((String) hm.get("product"));
        monitor.setVendor((String) hm.get("vendor"));
        monitor.setPhysical_id((String) hm.get("physical_id"));
        monitor.setBus_info((String) hm.get("bus_info"));
        monitor.setVersion((String) hm.get("version"));
        
        monitor.setWidth((String) hm.get("width"));
        monitor.setClock((String) hm.get("clock"));
        monitor.setCapabilities((String) hm.get("capabilities"));
        monitor.setConfiguration((String) hm.get("configuration"));
        monitor.setResources((String) hm.get("resources"));
        jhost.getJmonitor().add(monitor);
        if (flag)
          net_dbsession.saveOrUpdate(monitor);
        else{   
          net_dbsession.persist(monitor);
        }
       
        
        tr.commit();
        net_dbsession.close();
//        addd_sFactory.close();
        log.info("add the  monitor infomation to database...finished " + Monitor_data.class.getName());
    }
    
     public static List<Jlinux_Network> selectByH_Host_name(String H_Host_name){
        Session dbsession1 = null;
        if(dbsession1==null){
            SessionFactory sFactory = HibUtil.getSessionFactory();
            dbsession1 = sFactory.openSession();
        }
        List tmpnetwork_data = selectByH_Host_name( H_Host_name,dbsession1);
        dbsession1.close();
        return  tmpnetwork_data;
     }
     
     public static List<Jlinux_Network> selectByH_Host_name(String H_Host_name,Session dbsession){  
         List<Jlinux_Network> list = new ArrayList<Jlinux_Network>();
        Transaction tx = null;
        Jlinux_Network network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            list = dbsession.createQuery("from Jlinux_Network where H_Host_name='"+H_Host_name+"'").list();
//           list = dbsession.createQuery("from Network").list();
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
      
     /*hostmap can update all of column , use match key , and update the value*/
     public static Jlinux_Network UpdateByH_Host_name(String H_Host_name,Map<String,String> hostmap,Session dbsession){
        Transaction tx = null;
        Jlinux_Network network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_Network where H_Host_name='"+H_Host_name+"'");
            network = (Jlinux_Network)query.uniqueResult();
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

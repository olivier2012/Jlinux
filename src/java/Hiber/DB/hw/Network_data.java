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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author olivier-h
 */
public class Network_data {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Network_data.class.getName());

    public static void add(HashMap hm,SessionFactory sFactory,Jlinux_Host jhost) {
        log.info("add the network infomation to database ");
//        SessionFactory addd_sFactory = HibUtil.getSessionFactory();
        Session net_dbsession = sFactory.openSession();

        Transaction tr = net_dbsession.beginTransaction();
        boolean flag = LinuxOs_data.Is_selectbyHostname( jhost,sFactory,net_dbsession,tr); 
        Jlinux_Network network = new Jlinux_Network();
          /*  network.setH_Host_name(jhost.getH_Host_name());
            network.setUser(jhost.getUser());
            network.setH_User_name(jhost.getH_User_name());
            network.setH_Passwd(jhost.getH_Passwd());
            network.setAccess_time(jhost.getAccess_time());
            network.setCreated_time(jhost.getCreated_time());
            network.setHost_UUID(jhost.getHost_UUID());*/

//        Jlinux_Network network = new Jlinux_Network(jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());
//        network.setAccess_time(new Date());
        network.setJ_UserId(jhost);
        network.setIpv4((String) hm.get("inet_addr"));
        network.setNet_cardId((String) hm.get("Iface"));
        network.setMemID((String) hm.get(""));
        
        network.setIpv4_gw((String) hm.get(""));
        network.setRx((String) hm.get("RX-OK"));
        network.setTx((String) hm.get("TX-OK"));
        network.setIpv4_status((String) hm.get(""));
        network.setIpv6((String) hm.get("inet6"));
        network.setIpv6_mask((String) hm.get(""));
        network.setIpv6_gw((String) hm.get(""));
        network.setIpv6_Rx((String) hm.get("")); 
        
        network.setIpv6_Tx((String) hm.get(""));
        network.setIpv6_Tx((String) hm.get(""));
        network.setMTU((String) hm.get("MTU"));
  
        network.setLink_encap((String) hm.get("link_encap"));
        jhost.getJnetwork().add(network);
       if (flag)
           net_dbsession.saveOrUpdate(network);
        else{   
           net_dbsession.persist(network);
        }
       
        
        tr.commit();
        net_dbsession.close();
//        addd_sFactory.close();
        log.info("add the network infomation to database...finished ");
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
            list = dbsession.createQuery("from Jlinux_Network where H_Host_name='"+H_Host_name+"' group by H_Host_name ").list();
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
     
     public static void deleteByH_Host_name(String H_Host_name,SessionFactory sFactory){
     
     }
      
     /*hostmap can update all of column , use match key , and update the value*/
     public static Jlinux_Network UpdateByH_Host_name(String H_Host_name,Map<String,String> hostmap,Session dbsession){
        Transaction tx = null;
        Jlinux_Network network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_Network where H_Host_name='"+H_Host_name+"' group by H_Host_name"); 
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

package model.Hiber.DB.hw;

import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Hiber.HibUtil;
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
public class HDisk_data {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(HDisk_data.class.getName());

    public static void add(HashMap hm,SessionFactory sFactory,Jlinux_H_WithTime jhost) {
        log.info("add the HDisk infomation to database " + HDisk_data.class.getName());
//        SessionFactory addd_sFactory = HibUtil.getSessionFactory();
       try{
        Session net_dbsession = sFactory.openSession();
        Transaction tr = net_dbsession.beginTransaction();
        
        boolean flag = LinuxOs_data.Is_selectbyHostname( jhost,sFactory,net_dbsession,tr);
        Jlinux_HDisk hdisk = new Jlinux_HDisk();
           /* hdisk.setH_Host_name(jhost.getH_Host_name());
            hdisk.setUser(jhost.getUser());
            hdisk.setH_User_name(jhost.getH_User_name());
            hdisk.setH_Passwd(jhost.getH_Passwd());
            hdisk.setAccess_time(jhost.getAccess_time());
            hdisk.setCreated_time(jhost.getCreated_time());
            hdisk.setHost_UUID(jhost.getHost_UUID());*/
//            hdisk.setJ_UserId(jhost);
            hdisk.setHddisk_name((String) hm.get("NAME"));
            hdisk.setMajmin((String) hm.get("MAJ_MIN"));
            hdisk.setRM((String) hm.get("RM"));
            hdisk.setRO((String) hm.get("RO"));
            hdisk.sethdSize((String) hm.get("SIZE"));
            hdisk.setPartition_type((String) hm.get("TYPE"));
            hdisk.setMounted_on((String) hm.get("MOUNTPOINT"));
            jhost.getHardDisks().add(hdisk);
        if (flag)
           net_dbsession.saveOrUpdate(hdisk);
        else{   
           net_dbsession.persist(hdisk);
        }
       
        
        tr.commit();
        net_dbsession.close();
       }catch(Exception e){
         log.info(e);
       }
//        addd_sFactory.close();
        log.info("add the HDisk infomation to database...finished ");
    }
    
     public static List<Jlinux_HDisk> selectByH_Host_name(String H_Host_name){
        Session dbsession1 = null;
        if(dbsession1==null){
            SessionFactory sFactory = HibUtil.getSessionFactory();
            dbsession1 = sFactory.openSession();
        }
        List tmpnetwork_data = selectByH_Host_name( H_Host_name,dbsession1);
        dbsession1.close();
        return  tmpnetwork_data;
     }
     
     public static List<Jlinux_HDisk> selectByH_Host_name(String H_Host_name,Session dbsession){  
         List<Jlinux_HDisk> list = new ArrayList<Jlinux_HDisk>();
        Transaction tx = null;
        Jlinux_HDisk network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            list = dbsession.createQuery("from Jlinux_HDisk where H_Host_name='"+H_Host_name+"'").list();
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
     public static Jlinux_HDisk UpdateByH_Host_name(String H_Host_name,Map<String,String> hostmap,Session dbsession){
        Transaction tx = null;
        Jlinux_HDisk network = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_HDisk where H_Host_name='"+H_Host_name+"'");
            network = (Jlinux_HDisk)query.uniqueResult();
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

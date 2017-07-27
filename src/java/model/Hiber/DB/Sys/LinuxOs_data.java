/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hiber.DB.Sys;

import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Column;
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
public class LinuxOs_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(LinuxOs_data.class.getName());
    public static boolean add(HashMap hmtmp,Jlinux_H_WithTime jhost,SessionFactory sFactory){
        boolean ld_flag=false;
        log.debug("add the LinuxOS_data  infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        try{
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        boolean flag = Is_selectbyHostname( jhost,sFactory,dbsession,tr);
        
        Jlinux_LinuxOs los = new Jlinux_LinuxOs();
          /*  los.setH_Host_name(jhost.getH_Host_name());
            los.setUserId(jhost.getUserId());
            los.setH_User_name(jhost.getH_User_name());
            los.setH_Passwd(jhost.getH_Passwd());
            los.setAccess_time(jhost.getAccess_time());
            los.setCreated_time(jhost.getCreated_time());
            los.setHost_UUID(jhost.getHost_UUID());*/
//            los.setJ_UserId(jhost);
            los.setKernel_name((String) hmtmp.get("Kernel_name"));
            los.setNode_name((String) hmtmp.get("Node_name"));
            los.setKernel_version((String) hmtmp.get("Kernel_version"));
            los.setBuild_time((String) hmtmp.get("Build_time"));
            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
            los.setArchitecture((String) hmtmp.get("Architecture"));
            los.setOperate_system((String) hmtmp.get("Operate_system")); 
            jhost.getJlinuxos().add(los);
        if (flag)
        {
//           dbsession.update(jhost);
           dbsession.saveOrUpdate(los);
        }
           else
        {   
//            los = new Jlinux_LinuxOs(jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());
//            los.setKernel_name((String) hmtmp.get("Kernel_name"));
//            los.setNode_name((String) hmtmp.get("Node_name"));
//            los.setKernel_version((String) hmtmp.get("Kernel_version"));
//            los.setBuild_time((String) hmtmp.get("Build_time"));
//            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
//            los.setArchitecture((String) hmtmp.get("Architecture"));
//            los.setOperate_system((String) hmtmp.get("Operate_system"));
        dbsession.persist(los);
//        dbsession.persist(jhost);
        }
        tr.commit();        
        dbsession.close();
         ld_flag=true;
        }catch(Exception e){ e.printStackTrace();}
//        add_sFactory.close();
      log.debug("add theLinuxOS  infomation to database...finished ");
      return ld_flag;
    }
     public static List<Jlinux_LinuxOs> selectByH_Host_name(String H_Host_name,Session dbsession){  
         List<Jlinux_LinuxOs> list = new ArrayList<Jlinux_LinuxOs>();
        Transaction tx = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
//            list = dbsession.createQuery("from Network where Host_name='"+Host_name+"'").list();
           list = dbsession.createQuery("from Jlinux_LinuxOs").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
//            dbsession.cjcpue();
        }
        return list;
     }
     
    public static List<Jlinux_LinuxOs> selectByH_Host_name(String H_Host_name){
        Session dbsession1 = null;
        if(dbsession1==null){
            SessionFactory sFactory = HibUtil.getSessionFactory();
            dbsession1 = sFactory.openSession();
        }
        List tmplinuxos_data = selectByH_Host_name( H_Host_name,dbsession1);
        dbsession1.close();
        return  tmplinuxos_data;
     }
     
     public static boolean Is_selectbyHostname(Jlinux_Host jhost,SessionFactory sFactory,Session dbsession,Transaction tr){
        boolean iflag = false;
         try{
//        Session is_dbsession = sFactory.openSession();
//        Transaction tr = is_dbsession.beginTransaction();
        
//        Query query = (Query)dbsession.createQuery("from Jlinux_Host where H_Host_NAME = " + jhost.getH_Host_name());
        Query query = (Query)dbsession.createSQLQuery("select * from Jlinux_Host where H_Host_NAME = '" + jhost.getH_Host_name()+"'");
        log.info(query.toString());
        List list = query.list();
//        tr.commit();
//        dbsession.close();
//        Jlinux_LinuxOs  jlo = (Jlinux_LinuxOs) dbsession.createCriteria(Jlinux_LinuxOs.class).add(Restrictions.eq("H_Host_name", jhost.getH_Host_name()));
        if (list.isEmpty())
            iflag = false;
        else
            iflag = true;
        }
         catch(Exception e){
             log.debug(e);
         }finally {
           return iflag;
         }
     }
    
}

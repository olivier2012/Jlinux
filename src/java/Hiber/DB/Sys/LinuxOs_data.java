/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.Sys;

import Hiber.DB.hw.CPU_data;
import Hiber.DB.hw.Jlinux_Host;
import Hiber.HibUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Column;
import jl.function.Network_function;
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
    public static void add(HashMap hmtmp,Jlinux_Host jhost,SessionFactory sFactory){
        log.debug("add the LinuxOS  infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        boolean flag = Is_selectbyHostname( jhost,sFactory,dbsession,tr);
        Jlinux_LinuxOs los = new Jlinux_LinuxOs();
            los.setH_Host_name(jhost.getH_Host_name());
            los.setUserId(jhost.getUserId());
            los.setH_User_name(jhost.getH_User_name());
            los.setH_Passwd(jhost.getH_Passwd());
            los.setAccess_time(jhost.getAccess_time());
            los.setCreated_time(jhost.getCreated_time());
            los.setHost_UUID(jhost.getHost_UUID());
            los.setKernel_name((String) hmtmp.get("Kernel_name"));
            los.setNode_name((String) hmtmp.get("Node_name"));
            los.setKernel_version((String) hmtmp.get("Kernel_version"));
            los.setBuild_time((String) hmtmp.get("Build_time"));
            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
            los.setArchitecture((String) hmtmp.get("Architecture"));
            los.setOperate_system((String) hmtmp.get("Operate_system")); 
        if (flag)
           dbsession.update(los);
           else{   
//            los = new Jlinux_LinuxOs(jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());
//            los.setKernel_name((String) hmtmp.get("Kernel_name"));
//            los.setNode_name((String) hmtmp.get("Node_name"));
//            los.setKernel_version((String) hmtmp.get("Kernel_version"));
//            los.setBuild_time((String) hmtmp.get("Build_time"));
//            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
//            los.setArchitecture((String) hmtmp.get("Architecture"));
//            los.setOperate_system((String) hmtmp.get("Operate_system"));
        dbsession.persist(los);
        }
        tr.commit();        
        dbsession.close();
//        add_sFactory.close();
      log.debug("add theLinuxOS  infomation to database...finished ");
    }
     public static Jlinux_LinuxOs selectbyHostname(Jlinux_Host jhost,SessionFactory sFactory){
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        Jlinux_LinuxOs  jlo = (Jlinux_LinuxOs) dbsession.createCriteria(Jlinux_LinuxOs.class).add(Restrictions.eq("H_Host_name", jhost.getH_Host_name()));
        
        return jlo;
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

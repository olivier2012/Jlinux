/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.Sys;

import Hiber.DB.hw.CPU_data;
import Hiber.HibUtil;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Column;
import jl.function.Network_function;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class LinuxOs_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(LinuxOs_data.class.getName());
    public static void add(HashMap hmtmp){
        log.debug("add the cpu infomation to database ");
        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = add_sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        LinuxOs los = new LinuxOs();
           los.setKernel_name((String) hmtmp.get("Kernel_name"));
            los.setNode_name((String) hmtmp.get("Node_name"));
            los.setKernel_version((String) hmtmp.get("Kernel_version"));
            los.setBuild_time((String) hmtmp.get("Build_time"));
            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
            los.setArchitecture((String) hmtmp.get("Architecture"));
            los.setOperate_system((String) hmtmp.get("Operate_system"));
            los.setHost_name((String) hmtmp.get("Host_name"));
            los.setAccess_time(new Date());
        dbsession.persist(los);
        tr.commit();        
        dbsession.close();
        add_sFactory.close();
      log.debug("add the cpu infomation to database...finished ");
    }
}

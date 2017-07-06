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
    public static void add(HashMap hmtmp,Jlinux_Host jhost,SessionFactory sFactory){
        log.debug("add the cpu infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        Jlinux_LinuxOs los = new Jlinux_LinuxOs(jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());
            los.setKernel_name((String) hmtmp.get("Kernel_name"));
            los.setNode_name((String) hmtmp.get("Node_name"));
            los.setKernel_version((String) hmtmp.get("Kernel_version"));
            los.setBuild_time((String) hmtmp.get("Build_time"));
            los.setHardware_platform((String) hmtmp.get("Hardware_platform"));
            los.setArchitecture((String) hmtmp.get("Architecture"));
            los.setOperate_system((String) hmtmp.get("Operate_system"));

//        Jlinux_Host host = new Jlinux_Host();
//        host.setAccess_time(new Date());
//        host.setHost_name((String) hmtmp.get("Host_name"));
//        host.setKernel_name((String) hmtmp.get("Kernel_name"));
//        host.setLinuxOsId( los.getLinuxOsId());
//        
//        int timeActive = Integer.parseInt(host.getActive());
//        host.setActive(Integer.toString(timeActive+1));
//        dbsession.persist(host);
        dbsession.persist(los);
        tr.commit();        
        dbsession.close();
//        add_sFactory.close();
      log.debug("add the cpu infomation to database...finished ");
    }
}

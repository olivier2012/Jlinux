/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.HibUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jl.JL;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class CPU_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(CPU_data.class.getName());
    
    public static Jlinux_CPU Selectbyhostid(SessionFactory sFactory,Jlinux_Host jhost ,long Host_id){
         Session dbsession = sFactory.openSession();
         Jlinux_CPU cpu = (Jlinux_CPU) dbsession.get(Jlinux_CPU.class, Host_id);
        return cpu;
    }
     
    public static void add(HashMap hm,SessionFactory sFactory,Jlinux_Host jhost){
        log.debug("add the cpu infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        Jlinux_CPU cpu = new Jlinux_CPU((String) hm.get("processor"),(String) hm.get("vendor_id"),(String) hm.get("cpu_family"),(String) hm.get("model"),(String) hm.get("model_name"),(String) hm.get("stepping"),(String) hm.get("microcode"),(String) hm.get("cpu_mhz"),
                (String) hm.get("cache_size"),(String) hm.get("cache_size"),(String) hm.get("physical_id"),(String) hm.get("siblings"),(String) hm.get("core_id"),
                (String) hm.get("apicid"),(String) hm.get("fpu"),(String) hm.get("fpu_exception"),(String) hm.get("cpuid_level"),(String) hm.get("wp"),(String) hm.get("power_management"),(String) hm.get("cpu_cores"),(String) hm.get("flags"),(String) hm.get("bogomips"),
                (String) hm.get("clflush_size"),(String) hm.get("cache_alignment"),(String) hm.get("address_size"),jhost.getH_Host_name(),jhost.getUserId(),jhost.getH_User_name(),jhost.getH_Passwd(),jhost.getAccess_time(),jhost.getCreated_time(),jhost.getHost_UUID());
        
        /*
        cpu.setProcessor((String) hm.get("processor"));
        cpu.setVendor_id((String) hm.get("vendor_id"));
        cpu.setCpu_family((String) hm.get("cpu_family"));
        
        cpu.setModel((String) hm.get("model"));
        cpu.setModel_name((String) hm.get("model_name"));
        cpu.setStepping((String) hm.get("stepping"));
        cpu.setMicrocode((String) hm.get("microcode"));
        cpu.setCpu_mhz((String) hm.get("cpu_mhz"));
        cpu.setCache_size((String) hm.get("cache_size"));
        cpu.setPhysical_id((String) hm.get("physical_id"));
        cpu.setSiblings((String) hm.get("siblings")); 
        
        cpu.setCore_id((String) hm.get("core_id"));
        cpu.setCpu_cores((String) hm.get("cpu_cores"));
        cpu.setApicid((String) hm.get("apicid"));  
        cpu.setInitial_apicid((String) hm.get("initial_apicid"));
  
        cpu.setFpu((String) hm.get("fpu"));
        cpu.setFpu_exception((String) hm.get("fpu_exception"));
   
        cpu.setCpuid_level((String) hm.get("cpuid_level"));      
        cpu.setWp((String) hm.get("wp")); 
        cpu.setFlags((String) hm.get("flags"));
        cpu.setBogomips((String) hm.get("bogomips"));
        cpu.setClflush_size((String)hm.get("clflush_size"));
        cpu.setCache_alignment((String)hm.get("cache_alignment")); 
        cpu.setAddress_size((String)hm.get("address_sizes")); */
        dbsession.persist(cpu);
//        Host host = new Host();
//        host.setAccess_time(new Date());
//        host.setHost_name((String) hm.get("Host_name"));
//        int timeActive = Integer.parseInt(host.getActive());
//        host.setActive(Integer.toString(timeActive+1));
//        host.setCpuId(cpu.getCPUId());
//        dbsession.persist(host);
        tr.commit();        
        dbsession.close();
//        add_sFactory.close();
      log.debug("add the cpu infomation to database...finished ");
     }
    }

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
    public static void add(HashMap hm_cpu){
        log.debug("add the cpu infomation to database ");
        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = add_sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        CPU cpu = new CPU();
        cpu.setAccess_time(new Date());
        cpu.setHost_name((String) hm_cpu.get("Host_name"));
        cpu.setProcessor((String) hm_cpu.get("processor"));
        cpu.setVendor_id((String) hm_cpu.get("vendor_id"));
        cpu.setCpu_family((String) hm_cpu.get("cpu_family"));
        
        cpu.setModel((String) hm_cpu.get("model"));
        cpu.setModel_name((String) hm_cpu.get("model_name"));
        cpu.setStepping((String) hm_cpu.get("stepping"));
        cpu.setMicrocode((String) hm_cpu.get("microcode"));
        cpu.setCpu_mhz((String) hm_cpu.get("cpu_mhz"));
        cpu.setCache_size((String) hm_cpu.get("cache_size"));
        cpu.setPhysical_id((String) hm_cpu.get("physical_id"));
        cpu.setSiblings((String) hm_cpu.get("siblings")); 
        
        cpu.setCore_id((String) hm_cpu.get("core_id"));
        cpu.setCpu_cores((String) hm_cpu.get("cpu_cores"));
        cpu.setApicid((String) hm_cpu.get("apicid"));  
        cpu.setInitial_apicid((String) hm_cpu.get("initial_apicid"));
  
        cpu.setFpu((String) hm_cpu.get("fpu"));
        cpu.setFpu_exception((String) hm_cpu.get("fpu_exception"));
   
        cpu.setCpuid_level((String) hm_cpu.get("cpuid_level"));      
        cpu.setWp((String) hm_cpu.get("wp")); 
        cpu.setFlags((String) hm_cpu.get("flags"));
        cpu.setBogomips((String) hm_cpu.get("bogomips"));
        cpu.setClflush_size((String)hm_cpu.get("clflush_size"));
        cpu.setCache_alignment((String)hm_cpu.get("cache_alignment")); 
        cpu.setAddress_size((String)hm_cpu.get("address_sizes")); 
        dbsession.persist(cpu);
        tr.commit();        
        dbsession.close();
        add_sFactory.close();
      log.debug("add the cpu infomation to database...finished ");
     }
    }

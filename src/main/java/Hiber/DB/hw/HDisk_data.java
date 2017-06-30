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
public class HDisk_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(HDisk_data.class.getName());
    public static void add(HashMap hm_HDisk){
        log.debug("add the"+ Class.class.getName()+" cpu infomation to database ");
        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = add_sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        HDisk hdisk = new HDisk();
        hdisk.setAccess_time(new Date());
        hdisk.setHost_name((String) hm_HDisk.get("Host_name"));/*
        hdisk.setProcessor((String) hm_HDisk.get("processor"));
        hdisk.setVendor_id((String) hm_HDisk.get("vendor_id"));
        hdisk.setCpu_family((String) hm_HDisk.get("cpu_family"));
        
        hdisk.setModel((String) hm_HDisk.get("model"));
        hdisk.setModel_name((String) hm_HDisk.get("model_name"));
        hdisk.setStepping((String) hm_HDisk.get("stepping"));
        hdisk.setMicrocode((String) hm_HDisk.get("microcode"));
        hdisk.setCpu_mhz((String) hm_HDisk.get("cpu_mhz"));
        hdisk.setCache_size((String) hm_HDisk.get("cache_size"));
        hdisk.setPhysical_id((String) hm_HDisk.get("physical_id"));
        hdisk.setSiblings((String) hm_HDisk.get("siblings")); 
        
        hdisk.setCore_id((String) hm_HDisk.get("core_id"));
        hdisk.setCpu_cores((String) hm_HDisk.get("cpu_cores"));
        hdisk.setApicid((String) hm_HDisk.get("apicid"));  
        hdisk.setInitial_apicid((String) hm_HDisk.get("initial_apicid"));
  
        hdisk.setFpu((String) hm_HDisk.get("fpu"));
        hdisk.setFpu_exception((String) hm_HDisk.get("fpu_exception"));
   
        hdisk.setCpuid_level((String) hm_HDisk.get("cpuid_level"));      
        hdisk.setWp((String) hm_HDisk.get("wp")); 
        hdisk.setFlags((String) hm_HDisk.get("flags"));
        hdisk.setBogomips((String) hm_HDisk.get("bogomips"));
        hdisk.setClflush_size((String)hm_HDisk.get("clflush_size"));
        hdisk.setCache_alignment((String)hm_HDisk.get("cache_alignment")); 
        hdisk.setAddress_size((String)hm_HDisk.get("address_sizes")); */
        dbsession.persist(hdisk);
        tr.commit();        
        dbsession.close();
        add_sFactory.close();
      log.debug("add the Hdisk infomation to database...finished ");
     }
    }

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
public class User_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(User_data.class.getName());
    public static void add(HashMap hm_User,SessionFactory sFactory){
        log.debug("add the"+ Class.class.getName()+" cpu infomation to database ");
//        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        User user = new User();
        user.setAccess_time(new Date());
        user.setHost_name((String) hm_User.get("Host_name"));
        user.setProcessor((String) hm_User.get("processor"));
        user.setVendor_id((String) hm_User.get("vendor_id"));
        user.setCpu_family((String) hm_User.get("cpu_family"));
        
        user.setModel((String) hm_User.get("model"));
        user.setModel_name((String) hm_User.get("model_name"));
        user.setStepping((String) hm_User.get("stepping"));
        user.setMicrocode((String) hm_User.get("microcode"));
        user.setCpu_mhz((String) hm_User.get("cpu_mhz"));
        user.setCache_size((String) hm_User.get("cache_size"));
        user.setPhysical_id((String) hm_User.get("physical_id"));
        user.setSiblings((String) hm_User.get("siblings")); 
        
        user.setCore_id((String) hm_User.get("core_id"));
        user.setCpu_cores((String) hm_User.get("cpu_cores"));
        user.setApicid((String) hm_User.get("apicid"));  
        user.setInitial_apicid((String) hm_User.get("initial_apicid"));
  
        user.setFpu((String) hm_User.get("fpu"));
        user.setFpu_exception((String) hm_User.get("fpu_exception"));
   
        user.setCpuid_level((String) hm_User.get("cpuid_level"));      
        user.setWp((String) hm_User.get("wp")); 
        user.setFlags((String) hm_User.get("flags"));
        user.setBogomips((String) hm_User.get("bogomips"));
        user.setClflush_size((String)hm_User.get("clflush_size"));
        user.setCache_alignment((String)hm_User.get("cache_alignment")); 
        user.setAddress_size((String)hm_User.get("address_sizes")); 
        dbsession.persist(user);
        tr.commit();        
        dbsession.close();
        add_sFactory.close();
      log.debug("add the Hdisk infomation to database...finished ");
     }
    }

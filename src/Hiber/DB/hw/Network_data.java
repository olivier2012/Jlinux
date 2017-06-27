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
public class Network_data {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Network_data.class.getName());
    public static void add(HashMap hm){
        log.debug("add the network infomation to database ");
        SessionFactory add_sFactory = HibUtil.getSessionFactory();
        Session dbsession = add_sFactory.openSession();
        Transaction tr = dbsession.beginTransaction();
        
        Network network = new Network();
        network.setAccess_time(new Date());
        network.setHost_name((String) hm.get("Host_name"));
     /*   network.setProcessor((String) hm.get("processor"));
        network.setVendor_id((String) hm.get("vendor_id"));
        network.setCpu_family((String) hm.get("network_family"));
        
        network.setModel((String) hm.get("model"));
        network.setModel_name((String) hm.get("model_name"));
        network.setStepping((String) hm.get("stepping"));
        network.setMicrocode((String) hm.get("microcode"));
        network.setCpu_mhz((String) hm.get("network_mhz"));
        network.setCache_size((String) hm.get("cache_size"));
        network.setPhysical_id((String) hm.get("physical_id"));
        network.setSiblings((String) hm.get("siblings")); 
        
        network.setCore_id((String) hm.get("core_id"));
        network.setCpu_cores((String) hm.get("network_cores"));
        network.setApicid((String) hm.get("apicid"));  
        network.setInitial_apicid((String) hm.get("initial_apicid"));
  
        network.setFpu((String) hm.get("fpu"));
        network.setFpu_exception((String) hm.get("fpu_exception"));
   
        network.setCpuid_level((String) hm.get("networkid_level"));      
        network.setWp((String) hm.get("wp")); 
        network.setFlags((String) hm.get("flags"));
        network.setBogomips((String) hm.get("bogomips"));
        network.setClflush_size((String)hm.get("clflush_size"));
        network.setCache_alignment((String)hm.get("cache_alignment")); 
        network.setAddress_size((String)hm.get("address_sizes")); */
        dbsession.persist(network);
        tr.commit();        
        dbsession.close();
        add_sFactory.close();
      log.debug("add the network infomation to database...finished ");
     }
    }

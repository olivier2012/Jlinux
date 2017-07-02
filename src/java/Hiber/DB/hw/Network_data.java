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

    public static void add(HashMap hm,SessionFactory sFactory) {
        log.info("add the network infomation to database ");
//        SessionFactory addd_sFactory = HibUtil.getSessionFactory();
        Session net_dbsession = sFactory.openSession();

        Transaction tr = net_dbsession.beginTransaction();

        Network network = new Network();
        network.setAccess_time(new Date());

        network.setHost_name((String) hm.get("Host_name"));
        network.setIpv4((String) hm.get("inet_addr"));
        network.setNet_cardId((String) hm.get("Iface"));
        network.setMemID((String) hm.get(""));
        
        network.setIpv4_gw((String) hm.get(""));
        network.setRx((String) hm.get("RX-OK"));
        network.setTx((String) hm.get("TX-OK"));
        network.setIpv4_status((String) hm.get(""));
        network.setIpv6((String) hm.get("inet6"));
        network.setIpv6_mask((String) hm.get(""));
        network.setIpv6_gw((String) hm.get(""));
        network.setIpv6_Rx((String) hm.get("")); 
        
        network.setIpv6_Tx((String) hm.get(""));
        network.setIpv6_Tx((String) hm.get(""));
        network.setMTU((String) hm.get("MTU"));
  
        network.setLink_encap((String) hm.get("link_encap"));
        net_dbsession.persist(network);
        tr.commit();
        net_dbsession.close();
//        addd_sFactory.close();
        log.info("add the network infomation to database...finished ");
    }
}

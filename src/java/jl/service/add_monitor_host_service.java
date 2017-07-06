/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.service;

import jl.JL_network;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olivier-h
 */
public class add_monitor_host_service {
    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(add_monitor_host_service.class.getName());
    public boolean checkallofhw(String H_Host_name, String H_User_name, String H_Passwd){
        boolean amhs_flag = true;
        log.info(H_Host_name +"  "+ H_User_name+"  "+ H_Passwd);
        return amhs_flag; 
    }
}

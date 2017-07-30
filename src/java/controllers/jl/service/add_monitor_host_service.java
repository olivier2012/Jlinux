/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.jl.service;

import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import controllers.jl.MyUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import controllers.jl.function.*;
import model.Hiber.HibUtil;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author olivier-h
 */
public class add_monitor_host_service {
    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(add_monitor_host_service.class.getName());
    public Jlinux_H_WithTime checkallofhw(String H_Host_name, String H_User_name, String H_Passwd,Jlinux_User web_login_user){
        Jlinux_User User = web_login_user;
        boolean amhs_flag = false,check_jhost=false;
        SessionFactory sFactory = null;
        Session jschsession = null;
        Jlinux_H_WithTime jhost=null;
        List<Jlinux_H_WithTime> list_host = new ArrayList<Jlinux_H_WithTime>() ; 
        log.info(H_Host_name +"  "+ H_User_name+"  "+ H_Passwd);
        try {     
            JSch jsch = new JSch();
            check_jhost = host_function.check_host(H_Host_name ,H_User_name,H_Passwd,User);
            if(!check_jhost){
             jhost =  host_function.Add(H_Host_name, H_User_name, H_Passwd,User);
            }
            /*如果是新的ip 可能 会遇到 UnknownHostKey ， 需要处理 */
            jsch.setKnownHosts("C:\\Users\\olivier-h\\.ssh\\known_hosts");
            jschsession = jsch.getSession(jhost.getH_User_name(), jhost.getH_Host_name(), jhost.getH_Host_port());
            jschsession.setPassword(H_Passwd);
            
            UserInfo ui = new MyUserInfo();
            jschsession.setUserInfo(ui);
            jschsession.connect(30000);

            String Linux_command = "uname -a ";
            String Linux_info = Network_function.getCommand_back(Linux_command, jschsession);
            /*   */
            HashMap<String, String> maintmp = Network_function.Linux_Os(jschsession);
            sFactory = HibUtil.getSessionFactory();

            
        
            boolean check_linuxOs = LinuxOs_function.check_linuxOs(jhost,maintmp,sFactory,jschsession);
            boolean check_network = Network_function.check_network(jhost,maintmp,sFactory,jschsession);
            boolean check_cpu =  Cpu_function.check_cpu(jhost,maintmp,sFactory,jschsession);
           /* boolean check_hdisk = HDdisk_function.check_hdisk(jhost,maintmp,sFactory,jschsession);
            boolean check_monitor = Monitor_function.check_monitor(jhost, maintmp, sFactory, jschsession);*/
            /* boolean check_accessory = Monitor_function.check_accessory(jhost, maintmp, sFactory, jschsession);*/
            if(check_linuxOs && check_network && check_cpu/* && check_hdisk && check_monitor*/){
                amhs_flag=true;
            }

        } catch (Exception e){
           log.info(e);
        }finally{
//        sFactory.close();
//        jschsession.disconnect();
        return jhost; }
    }
}

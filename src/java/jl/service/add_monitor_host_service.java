/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.service;

import Hiber.DB.Sys.LinuxOs_data;
import Hiber.DB.hw.Jlinux_Host;
import Hiber.HibUtil;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.util.HashMap;
import jl.DBinit;
import jl.JL_network;
import jl.MyUserInfo;
import jl.function.Cpu_function;
import jl.function.HDdisk_function;
import jl.function.LinuxOs_function;
import jl.function.Monitor_function;
import jl.function.Network_function;
import jl.function.host_function;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author olivier-h
 */
public class add_monitor_host_service {
    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(add_monitor_host_service.class.getName());
    public boolean checkallofhw(String H_Host_name, String H_User_name, String H_Passwd){
        long UserId = 2;
        boolean amhs_flag = true;
        Jlinux_Host jhost=null;
        log.info(H_Host_name +"  "+ H_User_name+"  "+ H_Passwd);
        try {     
            JSch jsch = new JSch();
            jhost = host_function.check_host(H_Host_name ,H_User_name,H_Passwd,UserId);
            /*如果是新的ip 可能 会遇到 UnknownHostKey ， 需要处理 */
            jsch.setKnownHosts("C:\\Users\\olivier-h\\.ssh\\known_hosts");
            Session jschsession = jsch.getSession(jhost.getH_User_name(), jhost.getH_Host_name(), jhost.getH_Host_port());
            jschsession.setPassword(H_Passwd);
            
            UserInfo ui = new MyUserInfo();
            jschsession.setUserInfo(ui);
            jschsession.connect(30000);

            String Linux_command = "uname -a ";
            String Linux_info = Network_function.getCommand_back(Linux_command, jschsession);
            /*   */
            HashMap<String, String> maintmp = Network_function.Linux_Os(jschsession);
            SessionFactory sFactory = HibUtil.getSessionFactory();

            
        
            boolean check_linuxOs = LinuxOs_function.check_linuxOs(jhost,maintmp,sFactory);
            boolean check_network = Network_function.check_network(jhost,maintmp,sFactory,jschsession);
            boolean check_cpu =  Cpu_function.check_cpu(jhost,maintmp,sFactory,jschsession);
            boolean check_hdisk = HDdisk_function.check_hdisk(jhost,maintmp,sFactory,jschsession);
            boolean check_monitor = Monitor_function.check_monitor(jhost, maintmp, sFactory, jschsession);
           /* check_Accessory(H_Host_name ,H_User_name,H_Passwd); */
        } catch (Exception e){
           log.info(e);
        }finally{
        return amhs_flag; }
    }
}

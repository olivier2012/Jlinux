/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import Hiber.DB.Sys.LinuxOs_data;
import Hiber.DB.hw.CPU_data;
import Hiber.DB.hw.Network_data;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import jl.function.*;
import static jl.function.Network_function.getIpMask;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olivier-h
 */
public class JL_network {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(JL_network.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log.info("main begin.........! ");
        // DBinit.dbinit();
        try {
            JSch jsch = new JSch();

            /*如果是新的ip 可能 会遇到 UnknownHostKey ， 需要处理 */
            jsch.setKnownHosts("C:\\Users\\olivier-h\\.ssh\\known_hosts");

            //System.out.print("please input the host that you want to connect (ip address : 127.0.0.1): ");
//        String host = "192.168.2.204";
//            String host = "192.168.2.106";
            String host = "172.16.17.57";
            String username = "demo";
            String passwd = "demo";

            String Host_name = host;

            Session jschsession = jsch.getSession(username, host, 22);
            jschsession.setPassword(passwd);

            UserInfo ui = new MyUserInfo();
            jschsession.setUserInfo(ui);
            jschsession.connect(30000);

            /*First need to know which kind of  linux  */
            String Linux_command = "uname -a ";
            String Linux_info = Network_function.getCommand_back(Linux_command, jschsession);
            /*   */
            HashMap<String, String> maintmp = Network_function.Linux_Os(jschsession);

            LinuxOs_data.add(DBinit.addTimestamp(maintmp, Host_name));

            // HashMap Linux_map = DBinit.Linux_uname(Linux_info);
            /* run command , got the system info  */
            String command = "ifconfig -s ";
            log.info("call the execCommand");
            /* system info in the str*/
            String System_info = execCommand.executeCommand(command, jschsession);

            /*add the system info to database */
            String Orig_System_info = System_info;
            
            
            /*here we need to detect whether the network  multi interfaces  */
            Map<String,String> smntmp = new HashMap<String,String>();
              Map<String,String> tmpHm = new HashMap<String,String>();
//            boolean aaa = Network_function.ismultiNet(Orig_System_info);
            if (Network_function.ismultiNet(Orig_System_info)) {
                String[] multipS = Network_function.multiNet(Orig_System_info);
                /* split "\r\n\r\n " this word is first one , so we jump the multipS the 0 one . */
                for (int i = 0; i < multipS.length; i++) {
                    if(i!=0){
                    smntmp = tmpHm;
                    }
                    String System_info1 = multipS[i];
                    /* Iface   MTU Met   RX-OK RX-ERR RX-DRP RX-OVR    TX-OK TX-ERR TX-DRP TX-OVR Flg
                       br-ex      1500 0         0      0      0 0             8      0      0      0 BRU
                       br-int     1500 0         0      0      0 0             8      0      0      0 BRU 
                       then call the String2map_network  to handle them */
                    tmpHm = Network_function.String2map_network(System_info1,i,smntmp);
                    if(i!=0){
          /*  virbr0    Link encap:Ethernet  HWaddr e6:44:49:36:65:54  
          inet addr:192.168.122.1  Bcast:192.168.122.255  Mask:255.255.255.0
          UP BROADCAST MULTICAST  MTU:1500  Metric:1
          RX packets:0 errors:0 dropped:0 overruns:0 frame:0
          TX packets:0 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:0 
          RX bytes:0 (0.0 B)  TX bytes:0 (0.0 B)    handle this information
                        just the two beginning  rows */
                    tmpHm = Network_function.getIpMask((LinkedHashMap) tmpHm,jschsession,Host_name);
                      Network_data.add((HashMap) tmpHm);
                    }
                    tmpHm.forEach((k,v)-> System.out.println("key :"+k + "  value : "+v));
                }
            } 
            jschsession.disconnect();

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

}

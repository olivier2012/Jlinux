/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import Hiber.DB.hw.CPU_data;
import Hiber.HibUtil;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.LogManager;
import jl.function.execCommand;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import static org.hibernate.annotations.SourceType.DB;

/**
 *
 * @author olivier-h
 */
public class JL_cpu {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(JL_cpu.class.getName());

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
            String host = "192.168.2.106";
            String username = "demo";
            String passwd = "demo";

            String Host_name = host;

            Session jschsession = jsch.getSession(username, host, 22);
            jschsession.setPassword(passwd);

            UserInfo ui = new MyUserInfo();
            jschsession.setUserInfo(ui);
            jschsession.connect(30000);

            /* run command , got the system info  */
            String command = "cat /proc/cpuinfo ";
            log.info("call the execCommand");
            /* system info in the str*/
            String System_info = execCommand.executeCommand(command, jschsession);
            SessionFactory sFactory = HibUtil.getSessionFactory();
            /*add the system info to database */
            String Orig_System_info = System_info;

            /*here we need to detect whether the cpu multiprocessor */
            boolean aaa = DBinit.ismultip(Orig_System_info);
            if (DBinit.ismultip(Orig_System_info)) {
                String[] multipS = DBinit.multip(Orig_System_info);
                /* split "processor " this word is first one , so we jump the multipS the 0 one . */
                for (int i = 0; i < multipS.length; i++) {
                    String System_info1 = multipS[i];
                    HashMap tmpHm = DBinit.String2map(System_info1);
                    tmpHm.put("Host_name", Host_name);
                    /* */
                    log.info("ready  the cpu info , covert it to map");
                   /* CPU_data.add(tmpHm,sFactory);*/
                }
            } else {
                HashMap tmpHm = DBinit.String2map(System_info);
                tmpHm.put("Host_name", Host_name);
                /* */
                log.info("ready  the cpu info , covert it to map");
               /* CPU_data.add(tmpHm,sFactory);*/
            }

            jschsession.disconnect();

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }


}

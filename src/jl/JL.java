/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.logging.LogManager;
import jl.function.execCommand;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author olivier-h
 */
public class JL {
   final static Logger log = org.apache.logging.log4j.LogManager.getLogger(JL.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log.info("main begin.........! ");
                 try {
        JSch jsch = new JSch();

        /*如果是新的ip 可能 会遇到 UnknownHostKey ， 需要处理 */
        jsch.setKnownHosts("C:\\Users\\olivier-h\\.ssh\\known_hosts");
        String host = null;
        String username = null;
        String passwd = null;

        //System.out.print("please input the host that you want to connect (ip address : 127.0.0.1): ");
        host = "192.168.2.204";
        username = "olivier";
        passwd = "x09seokw";

        Session session = jsch.getSession(username, host, 22);
        
        session.setPassword(passwd);
        String command = "ls";
        
        String str = execCommand.executeCommand(command,session);        
                 
        } catch (Exception ee) {
            System.out.println(ee);
        }
        
    }
    
}

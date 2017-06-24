/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.IOException;
import java.io.InputStream;
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
        
        UserInfo ui = new MyUserInfo();
        session.setUserInfo(ui);
        session.connect(30000);
        
        String command = "iostat ";
        log.info("call the execCommand");
        String str = execCommand.executeCommand(command, session);   
       /* ChannelExec channel = (ChannelExec) session.openChannel("exec");
	channel.setCommand(command);

	channel.setInputStream(null);
	channel.setErrStream(System.err);

	final InputStream in = channel.getInputStream();

	channel.connect();

	final StringBuilder result = new StringBuilder();
	final byte[] tmp = new byte[1024];
	while (true) {
		while (in.available() > 0) {
			final int i = in.read(tmp, 0, 1024);
			if (i < 0) {
				break;
			}
			result.append(new String(tmp, 0, i));
                        log.info(result.toString());
		}
		if (channel.isClosed()) {
			log.info("exit-status: " + channel.getExitStatus());
			break;
		}
		try {
			Thread.sleep(1000);
		} catch (final Exception ee) {
		}
	}

	channel.disconnect();     */
                 
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }
                 
    
}

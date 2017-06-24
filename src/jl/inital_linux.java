/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.HostKeyRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;
import static java.awt.SystemColor.info;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JOptionPane;
import jl.function.execCommand;


/**
 *
 * @author olivier-h
 */
public class inital_linux {

    public static void main(String[] args) throws JSchException, IOException {
         try {
        JSch jsch = new JSch();

        /*如果是新的ip 可能 会遇到 UnknownHostKey ， 需要处理 */
        jsch.setKnownHosts("C:\\Users\\olivier-h\\.ssh\\known_hosts");
        String host = null;
        String username = null;
        String passwd = null;

        //System.out.print("please input the host that you want to connect (ip address : 127.0.0.1): ");
        host = "192.168.2.204";
        username = "demo";
        passwd = "demo";

        Session session = jsch.getSession(username, host, 22);
        
        session.setPassword(passwd);
        
//        String passphrase = null;
        UserInfo ui = new MyUserInfo();
        session.setUserInfo(ui);
       session.connect(30000);
        Channel channel = session.openChannel("exec");
        String command = "top";
        channel.setInputStream(System.in);
        channel.setOutputStream(System.out);
        channel.connect(3 * 1000); 
        
        Thread.sleep(1000);

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }
}


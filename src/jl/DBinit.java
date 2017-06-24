/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import Hiber.DB.Accessory;
import Hiber.DB.CPU;
import Hiber.DB.HDisk;
import Hiber.DB.Host;
import Hiber.DB.Monitor;
import Hiber.DB.Network;
import Hiber.DB.User;
import Hiber.HibUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author olivier-h
 */
public class DBinit {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(DBinit.class.getName());
     public static void dbinit(){ 
        log.info("DBinit.dbinit.....! ");
        SessionFactory sFactory = HibUtil.getSessionFactory();
        Session session = sFactory.openSession();

        User user = new User();
        Host host = new Host(); 
        Network network = new Network();
        HDisk hdisk = new HDisk();
        CPU cpu = new CPU();
        Accessory access = new Accessory();
        Monitor monitor = new Monitor();
        
        session.close();
        sFactory.close();
     }
     
     public static HashMap String2map(String str) throws IOException{
         log.info("DBinit.String2map .....! ");
          HashMap<String,String> tmpmap = new HashMap<String,String> ();
          BufferedReader br = new BufferedReader(new StringReader(str));
          String thisLine = null ;
          StringBuilder SBs = new StringBuilder();
          while((thisLine = br.readLine())!=null){
            System.out.println(thisLine);
            String key = thisLine.substring(0,thisLine.indexOf(':'));
            String value = thisLine.substring(thisLine.indexOf(':')+1);
            tmpmap.put(key,value);
          }
       return tmpmap;
     }
}

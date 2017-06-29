/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import Hiber.DB.hw.Accessory;
import Hiber.DB.hw.CPU;
import Hiber.DB.hw.HDisk;
import Hiber.DB.hw.Host;
import Hiber.DB.hw.Monitor;
import Hiber.DB.hw.Network;
import Hiber.DB.hw.User;
import Hiber.HibUtil;
import antlr.StringUtils;
import com.jcraft.jsch.JSchException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static jl.JL_network.log;
import jl.function.execCommand;
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
        SessionFactory init_sFactory = HibUtil.getSessionFactory();
        Session dbsession = init_sFactory.openSession();

        User user = new User();
        Host host = new Host(); 
        Network network = new Network();
        HDisk hdisk = new HDisk();
        CPU cpu = new CPU();
        Accessory access = new Accessory();
        Monitor monitor = new Monitor();
        
        dbsession.close();
        init_sFactory.close();
     }
     
     public static HashMap String2map(String str) throws IOException{
         log.info("DBinit.String2map .....! ");
          HashMap<String,String> tmpmap = new HashMap<String,String> ();
          log.info("last one : "+str.length());
          BufferedReader br = new BufferedReader(new StringReader(str));
          String thisLine = null ;
          StringBuilder SBs = new StringBuilder();
          Boolean emptyflag = false;
          for(int i=0;i<CountLines(str);i++){
            thisLine = br.readLine();
            System.out.println(thisLine);
            String key = lowercase(replaceSpace(thisLine.substring(0,thisLine.indexOf(':'))));
            String value = thisLine.substring(thisLine.indexOf(':')+1);
 //           String value = addDoublequotes(thisLine.substring(thisLine.indexOf(':')+1));
            if(value.equals("")){
             value=null;
            }
         if(key !=null || value !=null){
            tmpmap.put(key,value);}
          }
       log.info("DBinit.String2map .....before return ! ");
       return tmpmap;
     }
     
    private static String replaceSpace(String orig){
       return orig.replace(" ","_").replace("\t","");
    }
    
    private static String addDoublequotes(String orig){
       return "\""+orig+"\"";
    }
     
    public static String lowercase(String orig){
       return orig.toLowerCase() ;
    }
    
    private static String uppercase(String orig){
       return orig.toUpperCase();
    }
    
    private static String Capitalcase(String orig){
      return orig.substring(0,1).toUpperCase() + orig.substring(1).toLowerCase();
    }
    
    /*检测 字符串 为 null ， 有问题，所以用 计算 行的 数量来分 */
    private static int CountLines(String orig){
       String[] tmplines = orig.split("\r\n|\r|\n");
      return tmplines.length;
    }
    
    /* for multi cpu ,  the cpu information will include few part same content but the processor different */
    static boolean ismultip(String tmps) {
        String[] tmpstr = tmps.split("\n\n");
        return tmpstr.length > 1;
    }

    static String[] multip(String orig) {
        String[] tmpstr = orig.split("\n\n");
        return tmpstr;
    }

    static HashMap<String,String> addTimestamp(HashMap<String,String> maintmp,String Host_name){
        HashMap<String,String> addtime = maintmp;
        addtime.put("Host_name", Host_name);
        addtime.put("Access_time", new Date().toString());
        return addtime;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

import Hiber.DB.Sys.LinuxOs_data;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import static jdk.nashorn.internal.objects.NativeArray.map;
import jl.DBinit;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olivier-h
 */
public class Network_function {
  final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Network_function.class.getName());
    
    public static String[] multiNet(String orig){
       String[] tmpstr = orig.split("\r\n|\r|\n");
      return tmpstr;
    }
    
    public static boolean ismultiNet(String tmps){
       String[] tmpstr = tmps.split("\r\n|\r|\n");
       return tmpstr.length >0;
    }
    
    private static int CountLines(String orig){
       String[] tmplines = orig.split("\r\n|\r|\n");
      return tmplines.length;
    }
    
    private static String replaceSpace(String orig){
       return orig.replace(" ","_").replace("\t","");
    }
     
      public static void String2map(String str) throws IOException{
         log.info("Network_function.String2map .....! ");
          log.info("last one : "+str.length());
          BufferedReader br = new BufferedReader(new StringReader(str));
          String thisLine = null ;
          StringBuilder SBs = new StringBuilder();
          Boolean emptyflag = false;
          for(int i=0;i<CountLines(str);i++){
            thisLine = br.readLine();
            System.out.println(thisLine);
          List<String> network_name = Arrays.asList(thisLine.split(""));
          }
          
 //           String value = addDoublequotes(thisLine.substring(thisLine.indexOf(':')+1));
       log.info("DBinit.String2map .....before return ! ");
//       return network_name;
     }
    public static Map String2map_network(String str,int index,Map<String,String> smntmp) throws IOException{
        /*index ==0  we got the ifconfig header , put those into hashmap key , is importent */
        
         log.info("Network_function.String2Array_network .....! ");
          log.info("last one : "+str.length());
          String[] tmpmap =str.split(" ");
          if(index==0){
          smntmp = Array2map_key(tmpmap);
          }else{
          smntmp = Array2map_value(tmpmap,smntmp);
           }
       log.info("Network_function.String2Array_network.....before return ! ");
       return smntmp;
     }      
    
    public static Map Array2map_key(String[] str){
        Map<String,String> amktmp = new  LinkedHashMap<String,String>();
        for(int i=0 ; i<str.length;i++){
            String value="";
            if(!(str[i].isEmpty()||str[i].equals(" "))){
            String key = str[i];
            amktmp.put(key, value);
            }
        }
            amktmp.put("Host_name","");
            amktmp.put("Access_time","");
            return (LinkedHashMap) amktmp;
    }
   
        public static Map Array2map_value(String[] str,Map<String,String> amktmp){
//        Map<String,String> amktmp = new  LinkedHashMap<String,String>();
        Iterator iterator= amktmp.entrySet().iterator();
        String Key="";
        String Value="";
        for(int i=0 ; i<str.length;i++){
            if(!(str[i].isEmpty()||str[i].equals(" "))){
            if( iterator.hasNext()){
            Map.Entry entry =(Map.Entry)iterator.next();
            Key= entry.getKey().toString();
            }
            Value = str[i];
            amktmp.put(Key, Value);
            }
        }
            amktmp.put("Host_name","");
            amktmp.put("Access_time","");
            return amktmp;
    }
        
      public  static String getCommand_back(String command, Session se) throws JSchException, IOException  {
             
            log.info("call the execCommand"+command);
            /* system info in the str*/
            String Linux_infot = execCommand.executeCommand(command,se);
            return Linux_infot;
        }   
      
      /* need to create on database  to save */
       public  static HashMap<String,String> Linux_Os(Session se) throws JSchException, IOException{
            HashMap<String,String> hmtmp = new HashMap<String,String>();
            hmtmp.put("Kernel_name",Network_function.getCommand_back("uname -s",se));
            hmtmp.put("Node_name",Network_function.getCommand_back("uname -n",se));
            hmtmp.put("Kernel_version",Network_function.getCommand_back("uname -v",se));
            hmtmp.put("Build_time",Network_function.getCommand_back("uname -o",se));
            hmtmp.put("Hardware_platform",Network_function.getCommand_back("uname -m",se));
            hmtmp.put("Architecture",Network_function.getCommand_back("uname -i",se));
            hmtmp.put("Operate_system",Network_function.getCommand_back("uname -r",se));
                System.out.print(Arrays.asList(hmtmp));
         return hmtmp;
       }
         
}

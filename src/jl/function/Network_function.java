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
import java.util.Arrays;
import java.util.HashMap;
import jl.DBinit;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olivier-h
 */
public class Network_function {
  final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Network_function.class.getName());
    
    public static String[] multiNet(String orig){
       String[] tmpstr = orig.split("\r\n\r\n");
      return tmpstr;
    }
    
    public static boolean ismultiNet(String tmps){
       String[] tmpstr = tmps.split("\r\n\r\n");
       return tmpstr.length >0;
    }
    
    private static int CountLines(String orig){
       String[] tmplines = orig.split("\r\n|\r|\n");
      return tmplines.length;
    }
    
    private static String replaceSpace(String orig){
       return orig.replace(" ","_").replace("\t","");
    }
    
    /* return 这个是个 正则表达式，需要以文件形式在远端机器上，然后 用 ifconfig -a | sed -rf parse.sed  */
    private static String net_re(){
       return "s/^([^ ]+) */\\1\\n/                               # interface name\n" +
"s/Link encap:(.*)(  |$).*/\\1/                    # link encapsulation\n" +
"N                                                # append next line to PS\n" +
"/inet addr/! s/\\n[^\\n]*$/\\n0.0.0.0\\n/            # use 0.0.0.0 if no \"inet addr\"\n" +
"s/ *inet addr:([^ ]+).*/\\1\\n/                    # capture ip address if present\n" +
"s/\\n[^\\n]*$//                                    # cleanup the last line\n" +
"s/([^\\n]+)\\n([^\\n]+)\\n([^\\n]+)/IFACE \\1 \\3 \\2/p  # print entry\n" +
"s/.*//                                           # empty PS\n" +
": loop                                           # \\\n" +
"N                                                #  \\\n" +
"/^\\n$/b                                          #   skip until next empty line\n" +
"s/.*//                                           #  /\n" +
"b loop  ";
    }
    
    
    
         public static HashMap String2map(String str) throws IOException{
         log.info("Network_function.String2map .....! ");
          HashMap<String,String> tmpmap = new HashMap<String,String> ();
          log.info("last one : "+str.length());
          BufferedReader br = new BufferedReader(new StringReader(str));
          String thisLine = null ;
          StringBuilder SBs = new StringBuilder();
          Boolean emptyflag = false;
          for(int i=0;i<CountLines(str);i++){
            thisLine = br.readLine();
            System.out.println(thisLine);
            String key = DBinit.lowercase(replaceSpace(thisLine.substring(0,thisLine.indexOf(':'))));
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

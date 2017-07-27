package controllers.jl.function;

import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import static controllers.jl.DBinit.lowercase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javafx.scene.input.KeyCode.T;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class Monitor_function {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Monitor_function.class.getName());

    public static String[] multiNet(String orig) {
        String[] tmpstr = orig.split("\r\n|\r|\n");
        return tmpstr;
    }

    public static boolean ismultiNet(String tmps) {
        String[] tmpstr = tmps.split("\r\n|\r|\n");
        return tmpstr.length > 0;
    }

    private static int CountLines(String orig) {
        String[] tmplines = orig.split("\r\n|\r|\n");
        return tmplines.length;
    }

    private static String replaceSpace(String orig) {
        return orig.replace(" ", "_").replace("\t", "");
    }
    
    private static String replaceColon(String orig) {
        return orig.replace(":", "_");
    }

    private static String replaceSpace_trim_fb(String orig) {
        return orig.trim().replace(" ", "_").replace("\t", "");
    }

    public static void String2map(String str) throws IOException {
        log.info("Network_function.String2map .....! ");
        log.info("last one : " + str.length());
        BufferedReader br = new BufferedReader(new StringReader(str));
        String thisLine = null;
        StringBuilder SBs = new StringBuilder();
        Boolean emptyflag = false;
        for (int i = 0; i < CountLines(str); i++) {
            thisLine = br.readLine();
            System.out.println(thisLine);
            List<String> network_name = Arrays.asList(thisLine.split(""));
        }

        //           String value = addDoublequotes(thisLine.substring(thisLine.indexOf(':')+1));
        log.info("DBinit.String2map .....before return ! ");
//       return network_name;
    }

    public static Map String2map_network(String str, int index, Map<String, String> smntmp) throws IOException {
        /*index ==0  we got the ifconfig header , put those into hashmap key , is importent */
        
        log.info("Network_function.String2Array_network .....! ");
        log.info("last one : " + str.length());
        String[] tmpmap = str.split(" ");
        if (index == 0) {
            smntmp = Array2map_key(tmpmap);
        } else {
            smntmp = Array2map_value(tmpmap, smntmp);
        }
        log.info("Network_function.String2Array_network.....before return ! ");
        return smntmp;
    }

    public static Map Array2map_key(String[] str) {
        Map<String, String> amktmp = new LinkedHashMap<String, String>();
        for (int i = 0; i < str.length; i++) {
            String value = "";
            if (!(str[i].isEmpty() || str[i].equals(" "))) {
                String key = replaceColon(str[i]);
                amktmp.put(key, value);
            }
        }
        return (LinkedHashMap) amktmp;
    }

    public static Map Array2map_value(String[] str, Map<String, String> amktmp) {
//        Map<String,String> amktmp = new  LinkedHashMap<String,String>();
        Iterator iterator = amktmp.entrySet().iterator();
        String Key = "";
        String Value = "";
        for (int i = 0; i < str.length; i++) {
            if (!(str[i].isEmpty() || str[i].equals(" "))) {
                if (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    Key = entry.getKey().toString();
                }
                Value = str[i];
                amktmp.put(Key, Value);
            }
        }
        return amktmp;
    }

    public static Map getIpMask(LinkedHashMap amktmp, Session jschsession, String Host_name) throws JSchException, IOException {

        String command = "ifconfig " + amktmp.get("Iface").toString();
        log.info("call the execCommand : " + command);
        /* system info in the str*/
        String System_info = execCommand.executeCommand(command, jschsession);
        String Orig_System_info = System_info;
        if (Monitor_function.ismultiNet(Orig_System_info)) {
            String[] multipS = Monitor_function.multiNet(Orig_System_info);
            /* virbr0    Link encap:Ethernet  HWaddr e6:44:49:36:65:54  
          inet addr:192.168.122.1  Bcast:192.168.122.255  Mask:255.255.255.0 */
            for (int i = 0; i < 2; i++) {
                String System_info1 = multipS[i];
                /*accroding the space to split the string to array .*/
                String[] infotmp = System_info1.split("  ");
                /*remove all the empty elements from array*/
//                    arrayRemoveEmpty(infotmp);
                /* show the data after remove all of  null or empty*/
                String[] splitstringagain = arrayRemoveEmpty(infotmp);
                /* show the data after remove all of  null or empty()*/
                String key;
                String value;
                for (int t = 0; t < splitstringagain.length; t++) {
                    String aaa = splitstringagain[t].toString();
                    if (splitstringagain[t].toString().contains(":")) {
                        if ((splitstringagain[t].contains("HWaddr") || (splitstringagain[t].contains("inet6 addr")))) {
                            key = lowercase(replaceSpace_trim_fb(splitstringagain[t].substring(0, splitstringagain[t].indexOf(' '))));
                            value = splitstringagain[t].substring(splitstringagain[t].indexOf(' ') + 1);
                        } else {
                            key = lowercase(replaceSpace_trim_fb(splitstringagain[t].substring(0, splitstringagain[t].indexOf(':'))));
                            value = splitstringagain[t].substring(splitstringagain[t].indexOf(':') + 1);
                        }
                        if (key != null && value != null) {
                            amktmp.put(key, value);
                        }
                    }
                }
            }

        }
        /* every record of network card  , add the host and access time  */
        amktmp.put("Host_name", Host_name);
        amktmp.put("Access_time", new Date().toString());
        return amktmp;
    }

    public static String[] arrayRemoveEmpty(String[] tmp) {
//        List<String> list = new ArrayList<String>();
//        Collections.addAll(list, tmp);
////        list.removeAll(Arrays.asList(Optional.ofNullable(null)));
//        list.removeAll(Arrays.asList("",null));
//        String[] aretmp =  (String[]) list.toArray(new String[list.size()]);
        String[] aretmp;
        List<String> list = Arrays.asList(tmp);
        List<String> result = new ArrayList<String>();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                result.add(str);
            }
        }
        aretmp = result.toArray(new String[result.size()]);
        return aretmp;

    }

    public static String getCommand_back(String command, Session se) throws JSchException, IOException {

        log.info("call the execCommand : " + command);
        /* system info in the str*/
        String Linux_infot = execCommand.executeCommand(command, se);
        return Linux_infot;
    }

    /* need to create on database  to save */
    public static HashMap<String, String> Linux_Os(Session se) throws JSchException, IOException {
        HashMap<String, String> hmtmp = new HashMap<String, String>();
        hmtmp.put("Kernel_name", Monitor_function.getCommand_back("uname -s", se));
        hmtmp.put("Node_name", Monitor_function.getCommand_back("uname -n", se));
        hmtmp.put("Kernel_version", Monitor_function.getCommand_back("uname -v", se));
        hmtmp.put("Build_time", Monitor_function.getCommand_back("uname -o", se));
        hmtmp.put("Hardware_platform", Monitor_function.getCommand_back("uname -m", se));
        hmtmp.put("Architecture", Monitor_function.getCommand_back("uname -i", se));
        hmtmp.put("Operate_system", Monitor_function.getCommand_back("uname -r", se));
        System.out.print(Arrays.asList(hmtmp));
        return hmtmp;
    }
  
    public static void printmap(Map<String,String> tmpmap){
         for(Map.Entry entry : tmpmap.entrySet()){
           System.out.println(entry.getKey()+" , " + entry.getValue());
         }
     }
    
     public static boolean check_monitor(Jlinux_H_WithTime jhost , Map<String,String> maintmp , SessionFactory sFactory,Session jschsession){
        boolean  run_flag =false;
        try{
                        /* run command , got the system info  */
            String command = "lshw -c display ";
            log.info("call the execCommand : ");
            /* system info in the str*/
            String System_info = execCommand.executeCommand(command, jschsession);

            /*add the system info to database */
            String Orig_System_info = System_info;
            /*
            $ lshw -c display
              *-display               
       description: VGA compatible controller
       product: 3rd Gen Core processor Graphics Controller
       vendor: Intel Corporation
       physical id: 2
       bus info: pci@0000:00:02.0
       version: 09
       width: 64 bits
       clock: 33MHz
       capabilities: vga_controller bus_master cap_list rom
       configuration: driver=i915 latency=0
       resources: irq:27 memory:f6400000-f67fffff memory:e0000000-efffffff ioport:f000(size=64)
            */

            /*here we need to detect whether the network  multi interfaces  */
            Map<String, String> smntmp = new HashMap<String, String>();
            Map<String, String> tmpHm = new HashMap<String, String>();
            String key = null, value = null;
//            boolean aaa = Network_function.ismultiNet(Orig_System_info);
            if (Monitor_function.ismultiNet(Orig_System_info)) {
                String[] multipS = Monitor_function.multiNet(Orig_System_info);
                for (int i = 0; i < multipS.length; i++) {
                     String multips_Re =RE_Format_monitor(replaceTab_trim_monitor(replaceSpace_trim_monitor(multipS[i])));
                     String [] tmpmap =multips_Re.split(":");
                     
                     for(int j =0 ; j<tmpmap.length;j++){
                             if (j==0){
                              key = replaceSpace_key(tmpmap[j]);
                              value=null;
                             }
                             if(j==1){
                              value = tmpmap[j];
                             }
                       if(tmpmap[j]=="*-display"){
                            key = null;}
                       if(key!=null && value!=null){
                       smntmp.put(key, value);
                       }
                       System.out.println(" key =  " + key + "       ---value: "+ value);
                       System.out.println(smntmp.size());
                     }
                     
                /*     smntmp = Array2map_value(tmpmap,smntmp);
                   printmap(smntmp);
                 HDisk_data.add((HashMap) smntmp, sFactory, jhost);*/
              }
             Monitor_data.add((HashMap) smntmp, sFactory, jhost);   
            }
        run_flag = true;
        } catch(Exception e){
           run_flag =false;
           log.info(e);
        }
         
        
     return run_flag;   
    } 

     public static String RE_Format_monitor(String st){
          // StringBuilder sbtmp = new StringBuilder();
   /* 1, handle this " bus info: pci@0000:00:02.0 "  , only keep the first colon , the second one and third one  , will be replace  */
           String REGEX = "^bus.*";
           Pattern pattern = Pattern.compile(REGEX);
           Matcher matcher = pattern.matcher(st);
          if (matcher.matches()){
           st =replaceColon_keepfirst(replaceColon_(st));
          }
      /* 2, handle this " resources: irq:16 ioport:1070(size=16) memory:e8000000-efffffff memory:fe000000-fe7fffff memory:c0000000-c0007fff "  , only keep the first colon , the second one and third one  , will be replace  */  
           String REGEX1 = "^resource.*";
           Pattern pattern1 = Pattern.compile(REGEX1);
           Matcher matcher1 = pattern1.matcher(st);
          if (matcher1.matches()){
           st =replaceColon_keepfirst(replaceColon_(st));
          }
           return st;
     } 
     
    private static String replaceColon_(String orig) {
        return orig.replaceAll("\\:", "_");
    }
    private static String replaceColon_keepfirst(String orig) {
        return orig.replaceFirst("_", "\\:");
    }
 
    
    private static String replaceSpace_key(String orig) {
        return orig.replace(" ","_");
    }
        
    private static String replaceSpace_trim_monitor(String orig) {
        return orig.trim();
    }
    private static String replaceTab_trim_monitor(String orig) {
        return orig.replaceAll("\t", "");
    }
}

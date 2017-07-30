package controllers.jl.function;

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
import static javafx.scene.input.KeyCode.T;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class Network_function {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(Network_function.class.getName());

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
                String key = str[i];
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
        if (Network_function.ismultiNet(Orig_System_info)) {
            String[] multipS = Network_function.multiNet(Orig_System_info);
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
        hmtmp.put("Kernel_name", Network_function.getCommand_back("uname -s", se));
        hmtmp.put("Node_name", Network_function.getCommand_back("uname -n", se));
        hmtmp.put("Kernel_version", Network_function.getCommand_back("uname -v", se));
        hmtmp.put("Build_time", Network_function.getCommand_back("uname -o", se));
        hmtmp.put("Hardware_platform", Network_function.getCommand_back("uname -m", se));
        hmtmp.put("Architecture", Network_function.getCommand_back("uname -i", se));
        hmtmp.put("Operate_system", Network_function.getCommand_back("uname -r", se));
        System.out.print(Arrays.asList(hmtmp));
        return hmtmp;
    }
    
     public static boolean check_network(Jlinux_H_WithTime jhost , Map<String,String> maintmp , SessionFactory sFactory,Session jschsession){
        boolean  run_flag =false;
        try{
                        /* run command , got the system info  */
            String command = "ifconfig -s ";
            log.info("call the execCommand : ");
            /* system info in the str*/
            String System_info = execCommand.executeCommand(command, jschsession);

            /*add the system info to database */
            String Orig_System_info = System_info;

            /*here we need to detect whether the network  multi interfaces  */
            Map<String, String> smntmp = new HashMap<String, String>();
            Map<String, String> tmpHm = new HashMap<String, String>();
//            boolean aaa = Network_function.ismultiNet(Orig_System_info);
            if (Network_function.ismultiNet(Orig_System_info)) {
                String[] multipS = Network_function.multiNet(Orig_System_info);
                /* split "\r\n\r\n " this word is first one , so we jump the multipS the 0 one . */
                for (int i = 0; i < multipS.length; i++) {
                    if (i != 0) {
                        smntmp = tmpHm;
                    }
                    String System_info1 = multipS[i];
                    /* Iface   MTU Met   RX-OK RX-ERR RX-DRP RX-OVR    TX-OK TX-ERR TX-DRP TX-OVR Flg
                       br-ex      1500 0         0      0      0 0             8      0      0      0 BRU
                       br-int     1500 0         0      0      0 0             8      0      0      0 BRU 
                       then call the String2map_network  to handle them */
                    tmpHm = Network_function.String2map_network(System_info1, i, smntmp);
                    if (i != 0) {
                        /*  virbr0    Link encap:Ethernet  HWaddr e6:44:49:36:65:54  
          inet addr:192.168.122.1  Bcast:192.168.122.255  Mask:255.255.255.0
          UP BROADCAST MULTICAST  MTU:1500  Metric:1
          RX packets:0 errors:0 dropped:0 overruns:0 frame:0
          TX packets:0 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:0 
          RX bytes:0 (0.0 B)  TX bytes:0 (0.0 B)    handle this information
                        just the two beginning  rows */
                        tmpHm = Network_function.getIpMask((LinkedHashMap) tmpHm, jschsession, jhost.getH_Host_name());
                        Network_data.add((HashMap) tmpHm, sFactory ,jhost);
                    }
                    tmpHm.forEach((k, v) -> System.out.println("key :" + k + "  value : " + v));
                }
            }
        run_flag = true;
        } catch(Exception e){
           run_flag =false;
           log.info(e);
        }
         
        
     return run_flag;   
    } 

}

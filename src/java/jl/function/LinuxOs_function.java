/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

import Hiber.DB.Sys.LinuxOs_data;
import Hiber.DB.hw.Jlinux_Host;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jl.JL_network;
import static jl.function.Network_function.log;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author olivier-h
 */
public class LinuxOs_function {
     final static Logger log = org.apache.logging.log4j.LogManager.getLogger(LinuxOs_function.class.getName());
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
    
    public static String getCommand_back(String command, Session se) throws JSchException, IOException {

        log.info("call the execCommand : " + command);
        /* system info in the str*/
        String Linux_infot = execCommand.executeCommand(command, se);
        return Linux_infot;
    }
    public static HashMap<String,String> addTimestamp(HashMap<String,String> maintmp,String Host_name){
        HashMap<String,String> addtime = maintmp;
        addtime.put("Host_name", Host_name);
        addtime.put("Access_time", new Date().toString());
        return addtime;
    }
    
   
    public static boolean check_linuxOs(Jlinux_Host jhost , Map<String,String> maintmp , SessionFactory sFactory,Session jschsession){
        boolean  run_flag =false;
        try{
        run_flag = LinuxOs_data.add(LinuxOs_function.addTimestamp((HashMap<String, String>) maintmp, jhost.getH_Host_name()), jhost,sFactory);
        
        } catch(Exception e){
           run_flag =false;
           log.info(e);
        }  
     return run_flag;   
    };
}

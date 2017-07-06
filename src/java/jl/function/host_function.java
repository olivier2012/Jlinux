/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

import Hiber.DB.hw.Jlinux_Host;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.util.Date;
import java.util.UUID;
import jl.MyUserInfo;

/**
 *
 * @author olivier-h
 */
public class host_function {
  public  static Jlinux_Host check_host(String H_Host_name ,String H_User_name,String H_Passwd,long UserId){
       boolean  run_flag =false;
       Jlinux_Host jhost =null;

            String Host_UUID = GenerateUUID().toString();  
            jhost= new Jlinux_Host(H_Host_name,UserId,H_User_name,H_Passwd,new Date(),new Date(),Host_UUID) {};
      return jhost ;
  };  
  
  public static UUID GenerateUUID(){
     return UUID.randomUUID();
   }
}

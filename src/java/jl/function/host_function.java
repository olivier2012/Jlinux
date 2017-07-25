/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

import Hiber.DB.hw.Host_data;
import Hiber.DB.hw.Jlinux_H_WithTime;
import Hiber.DB.hw.Jlinux_Host;
import Hiber.DB.hw.Jlinux_User;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import jl.MyUserInfo;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class host_function {

    
    public static Jlinux_Host Add(String H_Host_name, String H_User_name, String H_Passwd, Jlinux_User User) {
        String Host_UUID = GenerateUUID().toString();
        Jlinux_H_WithTime jhost= new Jlinux_H_WithTime();
        jhost.setH_Host_name(H_Host_name);
        jhost.setH_User_name(H_User_name);
        jhost.setUser( User);
        jhost.setH_Passwd(H_Passwd) ; 
        jhost.setCreated_time(new Date());
        jhost.setAccess_time(new Date());
        jhost.setHost_UUID(Host_UUID);
        jhost.setActive("1");
        

        return jhost;
    }
    public static boolean check_host(String H_Host_name, String H_User_name, String H_Passwd, Jlinux_User User) {
        boolean run_flag = false;
        List <Jlinux_Host> list_temp = Host_data.selectByUserid(User);
        for(Jlinux_Host tmp_host: list_temp){
           if(tmp_host.getH_Host_name()==H_Host_name)
               run_flag=true;
        }
        
        return run_flag;
    }

    ;  
  
  public static UUID GenerateUUID() {
        return UUID.randomUUID();
    }

    public static Jlinux_Host getHostByH_Host_name(String H_Host_name, org.hibernate.Session dbsession) {
        Transaction tx = null;
        Jlinux_Host jhost = null;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_Host where H_Host_name='" + H_Host_name + "'");
            jhost = (Jlinux_Host) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return jhost;
    }

    public static List<Jlinux_Host> getHostByUser_ID(Jlinux_User User, org.hibernate.Session dbsession) {
        Transaction tx = null;
       List<Jlinux_Host> list =new ArrayList<Jlinux_Host>();;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            list = dbsession.createQuery("from Jlinux_Host ").list(); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }
}

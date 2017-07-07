/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

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

    public static Jlinux_Host check_host(String H_Host_name, String H_User_name, String H_Passwd, long UserId) {
        boolean run_flag = false;
        Jlinux_Host jhost = null;

        String Host_UUID = GenerateUUID().toString();
        jhost = new Jlinux_Host(H_Host_name, UserId, H_User_name, H_Passwd, new Date(), new Date(), Host_UUID) {
        };
        return jhost;
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

    public static List<Jlinux_Host> getHostByUser_ID(long User_ID, org.hibernate.Session dbsession) {
        Transaction tx = null;
       List<Jlinux_Host> list =new ArrayList<Jlinux_Host>();;
        try {
            tx = dbsession.getTransaction();
            tx.begin();
            list = dbsession.createQuery("from Jlinux_Host where UserId=" + User_ID).list(); 
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

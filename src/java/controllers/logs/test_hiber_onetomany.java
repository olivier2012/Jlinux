/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.logs;

import controllers.DAO.Jlinux_User_DAO_Impl;
import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import java.util.Date;
import java.util.Set;
import controllers.jl.service.*;
import model.Hiber.HibUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author olivier-h
 */
public class test_hiber_onetomany {
    public static void main(String[] args){
        SessionFactory sFactory = HibUtil.getSessionFactory();
        Session db1session = sFactory.openSession();
        Transaction tr = db1session.beginTransaction();
        Jlinux_H_WithTime host = new Jlinux_H_WithTime();
        LoginService ls = new LoginService();
        Jlinux_User user = new Jlinux_User();
              user =  ls.getUserByUserId_s("olivier"); 
        long userid1=user.getUserId();
        System.out.println(user.toString());
        
        System.out.println("=================inital jlinux_host_withtime ------ ");
        
          host.setJ_UserId(userid1);
          host.setActive("1");
          host.setH_Host_name("127.0.0.1");
          host.setH_Host_port(22);
          host.setH_Passwd("password");
          host.setH_User_name("usertoaccesslinux");
          host.setAccess_time(new Date());
//          user.getHosts().add(host);
          db1session.persist(host);
          tr.commit();
                
        System.out.println("get host : "+host.toString());
        Jlinux_LinuxOs los=new Jlinux_LinuxOs();
        los.setJ_HostId(los.getHost().getHostId());
        los.setKernel_name("test file ");
        los.setArchitecture("test by olivier ");
        host.getJlinuxos().add(los);
        db1session.save(host);
        db1session.save(los);
        tr.commit();
        System.out.println("Linux OS has been create by  " + host.getJlinuxos().size());
        db1session.close();
        
    }
}

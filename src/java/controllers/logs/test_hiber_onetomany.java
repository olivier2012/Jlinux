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
         Jlinux_H_WithTime host1 = new Jlinux_H_WithTime();
        LoginService ls = new LoginService();
        Jlinux_User olivier = new Jlinux_User("olivier");
//        user =  ls.getUserByUserId_s("olivier"); 
        olivier.setAdate(new Date());
        olivier.setEmail("olivier@olivier.com");
        olivier.setFname("olivier");
        olivier.setLname("olivier");
        olivier.setUser_name("olivier");
        olivier.setPasswd("accesslinuxpassword");
        olivier.setUsertype("register_user");
        
//        db1session.persist(olivier);
//        tr.commit();
        
        long userid1=olivier.getUserId();
        System.out.println(olivier.toString());
        
        System.out.println("=================inital jlinux_host_withtime ------ ");
        
          host.setJ_UserId(userid1);
          host.setActive("1");
          host.setH_Host_name("0.0.0.0");
          host.setH_Host_port(22);
          host.setH_Passwd("password");
          host.setH_User_name("usertoaccesslinux");
          host.setAccess_time(new Date());
          /* ==================*/
          host1.setJ_UserId(userid1);
          host1.setActive("1");
          host1.setH_Host_name("10.0.0.1");
          host1.setH_Host_port(22);
          host1.setH_Passwd("password1");
          host1.setH_User_name("usertoaccesslinux1");
          host1.setAccess_time(new Date());
          olivier.getHosts().add(host1);
          olivier.getHosts().add(host);
//          db1session.saveOrUpdate(olivier);
//          tr.commit();
                
        System.out.println("get host : "+host.toString());
        Jlinux_LinuxOs los=new Jlinux_LinuxOs();
        los.setJ_HostId(host.getHostId());
        los.setJ_UserId(olivier);
        los.setKernel_name("test file ");
        los.setArchitecture("test by olivier ");
        host.getJlinuxos().add(los);
//        db1session.saveOrUpdate(olivier);
        db1session.persist(olivier);
        tr.commit();
        System.out.println("Linux OS has been create by  " + host.getJlinuxos().size());
        db1session.close();
        
    }
}

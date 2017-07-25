/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logs;

import Hiber.DB.Sys.*;
import static Hiber.DB.Sys.LinuxOs_data.Is_selectbyHostname;
import Hiber.DB.hw.*;
import Hiber.HibUtil;
import java.util.Date;
import java.util.Set;
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
        Jlinux_Host host = (Jlinux_Host) db1session.get(Jlinux_Host.class, (long)1);
        Jlinux_LinuxOs los=new Jlinux_LinuxOs();
        los.setHostId(host.getHostId());
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

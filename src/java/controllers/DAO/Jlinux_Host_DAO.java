package controllers.DAO;

import java.util.List;
import model.Hiber.DB.hw.Jlinux_H_WithTime;
import model.Hiber.DB.hw.Jlinux_User;
import org.hibernate.Session;


public interface   Jlinux_Host_DAO extends DAO<Jlinux_H_WithTime> {
    public Session openCurrentSession();
    public Session openCurrentSessionwithTransaction();
    public void closeCurrentSession();
    public void closeCurrentSessionwithTransaction();
    
    public int getJlinux_HostCount();
    
    public void insertJlinux_HostTable(Jlinux_H_WithTime host);
    
    public void updateJlinux_Host(Jlinux_H_WithTime host);
    
       
    public  Jlinux_H_WithTime getJlinux_HostName(String h_host_name);    
    
    public void deleteAllJlinux_Hosts();
    public void deletebyJlinux_Hosts(String HostId);
    
     public List<Jlinux_H_WithTime> getListOfJlinux_Hosts();

}
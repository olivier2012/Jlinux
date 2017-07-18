package Hiber.DAO;

import Hiber.DB.hw.Jlinux_User;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

public interface   Jlinux_User_DAO {
    public Session openCurrentSession();
    public Session openCurrentSessionwithTransaction();
    public void closeCurrentSession();
    public void closeCurrentSessionwithTransaction();
    
    public int getJlinux_UserCount();
    
    public void createJlinux_UserTable(Jlinux_User user);
    
    public void insertJlinux_User(Jlinux_User user);
       
    public  Jlinux_User getJlinux_UserName(String User_name);    
    
    public void deleteAllJlinux_Users();
    public void deletebyJlinux_Users(long UserId);
    
     public List<Jlinux_User> getListOfJlinux_Users();

}
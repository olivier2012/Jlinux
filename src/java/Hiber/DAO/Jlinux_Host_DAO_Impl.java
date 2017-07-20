package Hiber.DAO;
import Hiber.DB.hw.*;
import Hiber.HibUtil;
import static Hiber.HibUtil.getSessionFactory;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;

@Component
public class Jlinux_Host_DAO_Impl implements     Jlinux_Host_DAO {

    SessionFactory sFactory = HibUtil.getSessionFactory();
    Session dbsession = sFactory.openSession();
    Transaction tr = dbsession.beginTransaction();
    private Session currentSession=dbsession;
    private Transaction currentTransaction=tr;


    private static SessionFactory getSessionFactory() {
          SessionFactory sFactory = HibUtil.getSessionFactory(); 
        return sFactory;
    }

     public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {

        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }


    public void closeCurrentSession() {
        currentSession.close();
    }


    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    
    @Override
    public int getJlinux_HostCount(){
        return dbsession.createCriteria(Jlinux_Host.class).list().size();
    }
    
    @Override
    public void insertJlinux_HostTable(Jlinux_Host user){
       currentSession.save(user);
    }
    
    @Override
    public void updateJlinux_Host(Jlinux_Host user){
        currentSession.update(user);
    }
    
   @Override
    public  Jlinux_Host getJlinux_HostName(String h_host_name){
        try{
        Jlinux_Host host = (Jlinux_Host) dbsession.createCriteria(Jlinux_Host.class).add(Restrictions.eq("h_host_name", h_host_name));
         return host;
        }  // catch all exceptions if any, return null as a sign of failure 
        catch(Exception e) {  return  null;  }
    }
    
    @Override
    public void deleteAllJlinux_Hosts(){   //special ORACLE syntax
        List<Jlinux_Host> entityList = getListOfJlinux_Hosts( );
        for(Jlinux_Host entity: entityList){
         currentSession.delete(entity);
        }
        
    }
    
    public void deletebyJlinux_Hosts(String HostId){   //special ORACLE syntax
       Jlinux_Host result =  (Jlinux_Host) dbsession.createCriteria(Jlinux_Host.class).add(Restrictions.idEq(HostId)).uniqueResult();
        if(result !=null){
         dbsession.delete(result);
        }
    }
    
    @Override
    public List<Jlinux_Host> getListOfJlinux_Hosts( ) {
         List<Jlinux_Host> list = dbsession.createCriteria(Jlinux_Host.class).list();
         return list;

    }

    
}
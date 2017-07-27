package controllers.DAO;
import model.Hiber.DB.hw.Jlinux_H_WithTime;
import java.util.List;
import java.util.Map;
import model.Hiber.HibUtil;
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
        return dbsession.createCriteria(Jlinux_H_WithTime.class).list().size();
    }
    
    @Override
    public void insertJlinux_HostTable(Jlinux_H_WithTime host){
       currentSession.save(host);
    }
    
    @Override
    public void updateJlinux_Host(Jlinux_H_WithTime host){
        currentSession.update(host);
    }
    
   @Override
    public  Jlinux_H_WithTime getJlinux_HostName(String h_host_name){
        try{
        Jlinux_H_WithTime host = (Jlinux_H_WithTime) dbsession.createCriteria(Jlinux_H_WithTime.class).add(Restrictions.eq("h_host_name", h_host_name));
         return host;
        }  // catch all exceptions if any, return null as a sign of failure 
        catch(Exception e) {  return  null;  }
    }
    
    @Override
    public void deleteAllJlinux_Hosts(){   //special ORACLE syntax
        List<Jlinux_H_WithTime> entityList = getListOfJlinux_Hosts( );
        for(Jlinux_H_WithTime entity: entityList){
         currentSession.delete(entity);
        }
        
    }
    
    public void deletebyJlinux_Hosts(String HostId){   //special ORACLE syntax
       Jlinux_H_WithTime result =  (Jlinux_H_WithTime) dbsession.createCriteria(Jlinux_H_WithTime.class).add(Restrictions.idEq(HostId)).uniqueResult();
        if(result !=null){
         dbsession.delete(result);
        }
    }
    
    @Override
    public List<Jlinux_H_WithTime> getListOfJlinux_Hosts( ) {
         List<Jlinux_H_WithTime> list = dbsession.createCriteria(Jlinux_H_WithTime.class).list();
         return list;

    }

    
}
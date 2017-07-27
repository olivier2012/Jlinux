package controllers.DAO;
import model.Hiber.DB.hw.Jlinux_User;
import java.util.List;
import java.util.Map;
import model.Hiber.HibUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;

@Component
public class Jlinux_User_DAO_Impl implements     Jlinux_User_DAO {

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
    public int getJlinux_UserCount(){
        return dbsession.createCriteria(Jlinux_User.class).list().size();
    }
    
    @Override
    public void insertJlinux_UserTable(Jlinux_User user){
       currentSession.save(user);
    }
    
    @Override
    public void updateJlinux_User(Jlinux_User user){
        currentSession.update(user);
    }
    
   @Override
    public  Jlinux_User getJlinux_UserName(String User_name){
        Transaction tx = null;
        Jlinux_User user = null;
        try{
            tx = dbsession.getTransaction();
            tx.begin();
            Query query = dbsession.createQuery("from Jlinux_User where User_name='"+User_name+"'");
            user = (Jlinux_User)query.uniqueResult();
            tx.commit();
         return user;
        }  // catch all exceptions if any, return null as a sign of failure 
        catch(Exception e) {  return  null;  }
    }
    
    public  Jlinux_User getJlinux_UserName(long UserId){
        try{
        Jlinux_User user = (Jlinux_User) dbsession.createQuery("from Jlinux_User where UserId = " + UserId );
         return user;
        }  // catch all exceptions if any, return null as a sign of failure 
        catch(Exception e) {  return  null;  }
    }
    
    @Override
    public void deleteAllJlinux_Users(){   //special ORACLE syntax
        List<Jlinux_User> entityList = getListOfJlinux_Users( );
        for(Jlinux_User entity: entityList){
         currentSession.delete(entity);
        }
        
    }
    
    public void deletebyJlinux_Users(long UserId){   //special ORACLE syntax
       Jlinux_User result =  (Jlinux_User) dbsession.createCriteria(Jlinux_User.class).add(Restrictions.idEq(UserId)).uniqueResult();
        if(result !=null){
         dbsession.delete(result);
        }
    }
    
    @Override
    public List<Jlinux_User> getListOfJlinux_Users( ) {
         List<Jlinux_User> list = dbsession.createCriteria(Jlinux_User.class).list();
         return list;

    }

    
}
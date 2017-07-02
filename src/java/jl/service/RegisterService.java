package jl.service;

import Hiber.DB.hw.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import Hiber.HibUtil;
import org.hibernate.SessionFactory;


public class RegisterService {
     
public boolean register(User user){
    SessionFactory sFactory = HibUtil.getSessionFactory();
     Session dbsession = sFactory.openSession();
     /*if isUserExists() return true, 已经存在，就返回真，如果为false ，继续执行 */
     if(isUserExists(user,dbsession)) {return true;}  
     
     
     Transaction tx = null;
     try {
         tx = dbsession.getTransaction();
         tx.begin();
         dbsession.saveOrUpdate(user);       
         tx.commit();
     } catch (Exception e) {
         if (tx != null) {
             tx.rollback();
         }
         e.printStackTrace();
     } finally {
         dbsession.close();
     } 
     return true;
}
 
public boolean isUserExists(User user,Session dbsession){
//     Session dbsession = HibUtil.getSessionFactory().getCurrentSession();
     boolean result = false;
     Transaction tx = null;
     try{
         tx = dbsession.getTransaction();
         tx.begin();
         Query query = dbsession.createQuery("from User where User_name='"+user.getUser_name()+"'");
         User u = (User)query.uniqueResult();
         tx.commit();
         if(u!=null) 
         {
             result = true;
         } 
         else{ 
             result = false; 
         }
     }catch(Exception ex){
         if(tx!=null){
             tx.rollback();
         }
     }finally{
//         dbsession.close();
     }
     return result;
}
}
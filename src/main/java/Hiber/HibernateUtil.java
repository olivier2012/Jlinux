package Hiber;

import Hiber.DB.Sys.LinuxOs;
import Hiber.DB.hw.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
        Configuration conf  = new Configuration( ).configure( );  //reads hibernate.cfg.xml
        conf.addAnnotatedClass( User.class );
        conf.addAnnotatedClass( Host.class );
        conf.addAnnotatedClass( CPU.class );
        conf.addAnnotatedClass( Network.class );
        conf.addAnnotatedClass( HDisk.class );
        conf.addAnnotatedClass( Monitor.class );
        conf.addAnnotatedClass( Accessory.class );
        conf.addAnnotatedClass( simpletest.class );
        conf.addAnnotatedClass( LinuxOs.class );
       sessionFactory = conf.buildSessionFactory(
        new StandardServiceRegistryBuilder( ).applySettings(conf.getProperties()).build( )
        );
//            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
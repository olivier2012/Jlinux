package model.Hiber;
import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class HibUtil {    
    private static final SessionFactory sessFactory ;
    
    static {	// Java static initializer, executed  before call of any static method
       // sessFactory = new Configuration( ).configure( ).buildSessionFactory();    //deprecated method
        Configuration conf  = new Configuration( ).configure( );  //reads hibernate.cfg.xml
        conf.addAnnotatedClass( Jlinux_User.class );
        conf.addAnnotatedClass( Jlinux_Host.class );
        conf.addAnnotatedClass( Jlinux_H_WithTime.class);
        conf.addAnnotatedClass( Jlinux_CPU.class );
        conf.addAnnotatedClass( Jlinux_Network.class );
        conf.addAnnotatedClass( Jlinux_HDisk.class );
        conf.addAnnotatedClass( Jlinux_Monitor.class );
        conf.addAnnotatedClass( Jlinux_Accessory.class );
        conf.addAnnotatedClass( Jlinux_LinuxOs.class );
        sessFactory = conf.buildSessionFactory(
        new StandardServiceRegistryBuilder( ).applySettings(conf.getProperties()).build( )
        );
    }

  public  static SessionFactory getSessionFactory(){            return sessFactory;   }
}

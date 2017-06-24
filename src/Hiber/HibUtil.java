package Hiber;
import Hiber.DB.Accessory;
import Hiber.DB.CPU;
import Hiber.DB.HDisk;
import Hiber.DB.Host;
import Hiber.DB.Monitor;
import Hiber.DB.Network;
import Hiber.DB.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class HibUtil {    
    private static final SessionFactory sessFactory ;
    
    static {	// Java static initializer, executed  before call of any static method
       // sessFactory = new Configuration( ).configure( ).buildSessionFactory();    //deprecated method
        Configuration conf  = new Configuration( ).configure( );  //reads hibernate.cfg.xml
        conf.addAnnotatedClass( User.class );
        conf.addAnnotatedClass( Host.class );
        conf.addAnnotatedClass( CPU.class );
        conf.addAnnotatedClass( Network.class );
        conf.addAnnotatedClass( HDisk.class );
        conf.addAnnotatedClass( Monitor.class );
        conf.addAnnotatedClass( Accessory.class );
        sessFactory = conf.buildSessionFactory(
        new StandardServiceRegistryBuilder( ).applySettings(conf.getProperties()).build( )
        );
    }

  public  static SessionFactory getSessionFactory(){            return sessFactory;   }
}

package Hiber;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class HibUtil {    
    private static final SessionFactory sessFactory ;
    
    static {	// Java static initializer, executed  before call of any static method
       // sessFactory = new Configuration( ).configure( ).buildSessionFactory();    //deprecated method
        Configuration conf  = new Configuration( ).configure( );  //reads hibernate.cfg.xml
  //      conf.addAnnotatedClass( Test_Employee.class );
        //conf.addAnnotatedClass( Test_country.class );
        sessFactory = conf.buildSessionFactory(
        new StandardServiceRegistryBuilder( ).applySettings(conf.getProperties()).build( )
        );
    }

    static SessionFactory getSessionFactory(){            return sessFactory;   }
}

package controllers.jl.function;

import model.Hiber.DB.hw.*;
import java.util.Date;
import org.apache.logging.log4j.Logger;

public class User_function {

    final static Logger log = org.apache.logging.log4j.LogManager.getLogger(User_function.class.getName());
    
    User_data user_data = new User_data();
    Jlinux_User user1 = new Jlinux_User("127.0.0.1","admin","admin_f","admin_m","admin_l","jlinux","admin",new Date(),new Date(),"admin@admin.admin",true);


}

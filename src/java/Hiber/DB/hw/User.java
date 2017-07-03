/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author olivier-h
 */
@Entity
@Table(name = "Jlinux_User")
public class User {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_user_seq")
    @SequenceGenerator(
    name="Jlinux_user_seq",
    sequenceName="user_sequence",
    allocationSize=1
    )
    private long UserId;
    
    @Column(name="Host_name", length = 120)
    private String Host_name;
    
    @Column(name="Host_IP", length = 120)
    private String Host_IP;

    @Column(name="User_name", length = 120)
    private String User_name;

    public User() {
       //To change body of generated methods, choose Tools | Templates.
    }

    public String getHost_IP() {
        return Host_IP;
    }

    public void setHost_IP(String Host_IP) {
        this.Host_IP = Host_IP;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }
    
    public String getHost_name() {
        return Host_name;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }
    
    @Column(name="First_name",length=40)
    private String Fname;
    
    @Column(name = "middle_name", length = 40)
    private String Mname;
    
   @Column(name = "last_name", length = 40)
    private String Lname;
   
    @Column(name="password",length=250)
    private String Passwd;
    
    /*type: admin,client,user,linux*/
   @Column(name = "UserType", length = 40)
    private String Usertype;
   
    @Column(name = "Create_Date")
    private Date Cdate;
   
    @Column(name="Access_Date")
    private Date Adate;
    
   @Column(name = "Email", length = 80)
    private String Email;
   
   /*add the email confirm function  ,  when the email confirm is false , user can not login */
   @Column(name = "Email_confirm", length = 80)
    private Boolean Email_confirm;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long UserId) {
        this.UserId = UserId;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }
    
     public String getMname() {
        return Mname;
    }

    public void setMname(String Fname) {
        this.Fname = Mname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String Usertype) {
        this.Usertype = Usertype;
    }

    public Date getCdate() {
        return Cdate;
    }

    public void setCdate(Date Cdate) {
        this.Cdate = Cdate;
    }

    public Date getAdate() {
        return Adate;
    }

    public void setAdate(Date Adate) {
        this.Adate = Adate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
     public User(String Fname, String Mname, String Lname, String Email, String User_name, String Passwd ,Date date) {
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.Email = Email;
        this.User_name = User_name;
        this.Passwd = Passwd;
        this.Adate=date;
        this.Cdate=date;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author olivier-h
 */
public class User {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long UserId;
    
    @Column(name="First_name",length=40)
    private String Fname;
    
   @Column(name = "last_name", length = 40)
    private String Lname;
   
    @Column(name="password",length=250)
    private String Passwd;
    
   @Column(name = "UserType", length = 40)
    private String Usertype;
   
    @Column(name = "Create_Date")
    private Date Cdate;
   
    @Column(name="Access_Date")
    private Date Adate;
    
   @Column(name = "Email", length = 80)
    private String Email;

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
   
   
}

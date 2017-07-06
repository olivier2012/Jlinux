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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author olivier-h
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Jlinux_Host {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_host_seq")
    @SequenceGenerator(
    name="Jlinux_host_seq",
    sequenceName="host_sequence",
    allocationSize=1
    )
    private long HostId;
    public Jlinux_Host(){};
    
    @Column(name="H_Host_name",length=20)
    private String H_Host_name;
    
    @Column(name="Active",length=5)
    private String Active = "0" ;
   
    /*UserId will join the user table as foreign key */
    @Column(name = "UserId", length = 20)
    private long UserId;
    
    /* H_User_name is login the linux node use the username and password */
    @Column(name="H_User_name", length = 120)
    private String H_User_name;

    @Column(name="H_Passwd", length = 120)
    private String H_Passwd;
   
    @Column(name="Access_time")
    private Date Access_time;

    public long getHostId() {
        return HostId;
    }

    public void setHostId(long HostId) {
        this.HostId = HostId;
    }

    public String getH_Host_name() {
        return H_Host_name;
    }

    public void setH_Host_name(String H_Host_name) {
        this.H_Host_name = H_Host_name;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long UserId) {
        this.UserId = UserId;
    }

    public String getH_User_name() {
        return H_User_name;
    }

    public void setH_User_name(String H_User_name) {
        this.H_User_name = H_User_name;
    }

    public String getH_Passwd() {
        return H_Passwd;
    }

    public void setH_Passwd(String H_Passwd) {
        this.H_Passwd = H_Passwd;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }

    public Date getCreated_time() {
        return Created_time;
    }

    public void setCreated_time(Date Created_time) {
        this.Created_time = Created_time;
    }

    public String getHost_UUID() {
        return Host_UUID;
    }

    /*need to check , how to generate the uuid and java */
    public void setHost_UUID(String Host_UUID) {
        this.Host_UUID = Host_UUID;
    }

    @Column(name="Created_time")
    private Date Created_time;
    
    @Column(name="Host_UUID")
    private String Host_UUID;
        
    /*Active has three status:" 0 标识 开始 建立 host值 ；"  ">1  标识已经 有别的部分追加 ；" " -1 标识已经过期 " */
    public String getActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }

    public Jlinux_Host(long HostId, String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        this.HostId = HostId;
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.UserId = UserId;
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Access_time = Access_time;
        this.Created_time = Created_time;
        this.Host_UUID = Host_UUID;
    }
   
    @Override
    public String toString() {
        return "Base_Host [HostId=" + HostId + ", Host_UUID=" + Host_UUID + ", Created_time=" + Created_time.toString() +
                ", Access_time=" + Access_time.toString() + ", UserId=" + UserId + ", H_Host_name=" + H_Host_name + ", H_User_name=" + H_User_name + 
                ", H_Passwd=" + H_Passwd + "]";
    }    
    
}

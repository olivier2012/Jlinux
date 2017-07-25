/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import Hiber.DB.Sys.Jlinux_LinuxOs;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Column(name="J_UserId")
    private long UserId;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(Jlinux_User User) {
        this.UserId = User.getUserId();
    }
    
    
    @Column(name="H_Host_name",length=20)
    private String H_Host_name;
    
    @Column(name="H_Host_port",length=20)
    private int H_Host_port=22;

    public int getH_Host_port() {
        return H_Host_port;
    }

    public void setH_Host_port(int H_Host_port) {
        this.H_Host_port = H_Host_port;
    }
    
    @Column(name="Active",length=5)
    private String Active = "0" ;
    
    @ManyToOne  
    private Jlinux_User User;
    
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

    public Jlinux_Host( String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Access_time = Access_time;
        this.Created_time = Created_time;
        this.Host_UUID = Host_UUID;
        this.User = User;
    }
    
    public Jlinux_Host( String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID,Set<Jlinux_HDisk> hardDisks) {
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Access_time = Access_time;
        this.Created_time = Created_time;
        this.Host_UUID = Host_UUID;
        this.hardDisks =hardDisks;
        this.User = User;
    }
    
    public Jlinux_Host( String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, Date Created_time, String Host_UUID,Set<Jlinux_CPU> jcpu) {
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Created_time = Created_time;
        this.Host_UUID = Host_UUID;
        this.jcpu = jcpu;
        this.User = User;
    }
    
    public Jlinux_Host( String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, String Host_UUID,Set<Jlinux_Monitor> jmonitor) {
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Host_UUID = Host_UUID;
        this.jmonitor = jmonitor;
    }
   
    public Jlinux_Host( String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, Set<Jlinux_Network> jnetwork) {
        this.H_Host_name = H_Host_name;
        /* as foreign key with jlinux_user*/
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.jnetwork = jnetwork;
    }
        
    @Override
    public String toString() {
        return "Base_Host [HostId=" + HostId + ", Host_UUID=" + Host_UUID + ", Created_time=" + Created_time.toString() +
                ", Access_time=" + Access_time.toString() + ", User=" + User.getUserId() + ", H_Host_name=" + H_Host_name + ", H_User_name=" + H_User_name + 
                ", H_Passwd=" + H_Passwd + "]";
    }  
 
    @OneToMany(
            mappedBy = "host",
            cascade = {CascadeType.PERSIST,  CascadeType.REMOVE },
            orphanRemoval = true 
    )
    Set<Jlinux_LinuxOs> Jlinuxos = new HashSet<>();    

    public Set<Jlinux_LinuxOs> getJlinuxos() {
        return Jlinuxos;
    }

    public void setJlinuxos(Set<Jlinux_LinuxOs> Jlinuxos) {
        this.Jlinuxos = Jlinuxos;
    }


    
    @OneToMany(
            mappedBy = "host",
            cascade = {CascadeType.PERSIST,  CascadeType.REMOVE },
            orphanRemoval = true 
    )
    Set<Jlinux_HDisk> hardDisks = new HashSet<>();
    
    @OneToMany(
            mappedBy = "host",
            cascade = {CascadeType.PERSIST,  CascadeType.REMOVE },
            orphanRemoval = true 
    )
    Set<Jlinux_CPU> jcpu = new HashSet<>();
    
    @OneToMany(
            mappedBy = "host",
            cascade = {CascadeType.PERSIST,  CascadeType.REMOVE },
            orphanRemoval = true 
    )
    Set<Jlinux_Monitor> jmonitor = new HashSet<>();
    
    @OneToMany(
            mappedBy = "host",
            cascade = {CascadeType.PERSIST,  CascadeType.REMOVE },
            orphanRemoval = true 
    )
    Set<Jlinux_Network> jnetwork = new HashSet<>();

    public Set<Jlinux_HDisk> getHardDisks() {
        return hardDisks;
    }

    public void setHardDisks(Set<Jlinux_HDisk> hardDisks) {
        this.hardDisks = hardDisks;
    }

    public Set<Jlinux_CPU> getJcpu() {
        return jcpu;
    }

    public void setJcpu(Set<Jlinux_CPU> jcpu) {
        this.jcpu = jcpu;
    }

    public Set<Jlinux_Monitor> getJmonitor() {
        return jmonitor;
    }

    public Jlinux_Host(long HostId, String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        this.HostId = HostId;
        this.H_Host_name = H_Host_name;
        this.User = User;
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
        this.Access_time = Access_time;
        this.Created_time = Created_time;
        this.Host_UUID = Host_UUID;
    }

    public void setJmonitor(Set<Jlinux_Monitor> jmonitor) {
        this.jmonitor = jmonitor;
    }

    public Set<Jlinux_Network> getJnetwork() {
        return jnetwork;
    }

    public void setJnetwork(Set<Jlinux_Network> jnetwork) {
        this.jnetwork = jnetwork;
    }

    public Jlinux_User getUser() {
        return User;
    }

    public void setUser(Jlinux_User User) {
        this.User = User;
    }
    
    
}

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
    private long J_UserId;

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(Jlinux_H_WithTime jhost) {
        this.J_UserId = jhost.getUser().getUserId();
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


        
    @Override
    public String toString() {
        return "Base_Host [HostId=" + HostId + ", H_Host_name=" + H_Host_name + ", H_User_name=" + H_User_name + 
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

    public void setJmonitor(Set<Jlinux_Monitor> jmonitor) {
        this.jmonitor = jmonitor;
    }

    public Set<Jlinux_Network> getJnetwork() {
        return jnetwork;
    }

    public void setJnetwork(Set<Jlinux_Network> jnetwork) {
        this.jnetwork = jnetwork;
    }

    public Jlinux_Host( String H_Host_name,  String H_User_name, String H_Passwd) {
        this.H_Host_name = H_Host_name;
        this.H_User_name = H_User_name;
        this.H_Passwd = H_Passwd;
    }
    
    
}

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
 * 加这个 entity 是为了 让 host 可以 不是 abstract 类，可以 实例化 
 */
@Entity
public  class Jlinux_H_WithTime extends Jlinux_Host {

    @Column(name="Active",length=5)
    private String Active = "0" ;

    @Column(name="Created_time")
    private Date Created_time;
        
    @Column(name="Access_time")
    private Date Access_time;
    
    @Column(name="Host_UUID")
    private String Host_UUID;
    
    @ManyToOne  
    private Jlinux_User User;
    
    public Jlinux_User getUser() {
        return User;
    }

    public void setUser(Jlinux_User User) {
        this.User = User;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }

    public Date getCreated_time() {
        return Created_time;
    }

    public void setCreated_time(Date Created_time) {
        this.Created_time = Created_time;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }

    public String getHost_UUID() {
        return Host_UUID;
    }

    public void setHost_UUID(String Host_UUID) {
        this.Host_UUID = Host_UUID;
    }

    public Set<Jlinux_LinuxOs> getJlinuxos() {
        return Jlinuxos;
    }

    public void setJlinuxos(Set<Jlinux_LinuxOs> Jlinuxos) {
        this.Jlinuxos = Jlinuxos;
    }

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

    public Jlinux_H_WithTime() {
    }

    public Jlinux_H_WithTime(String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd) {
        super(H_Host_name, H_User_name, H_Passwd);
    }

    public Jlinux_H_WithTime(Date Created_time, Date Access_time, String Host_UUID) {
        this.Created_time = Created_time;
        this.Access_time = Access_time;
        this.Host_UUID = Host_UUID;
        this.User = User;
    }

    public Jlinux_H_WithTime(Date Created_time, Date Access_time, String Host_UUID, String H_Host_name, Jlinux_User User, String H_User_name, String H_Passwd) {
        super(H_Host_name,  H_User_name, H_Passwd);
        this.Created_time = Created_time;
        this.Access_time = Access_time;
        this.Host_UUID = Host_UUID;
        this.User = User;
    }
        
    
    
}

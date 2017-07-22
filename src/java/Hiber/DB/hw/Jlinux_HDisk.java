/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author olivier-h
 */
@Entity
public class Jlinux_HDisk extends Jlinux_Host{
 
    @Column(name="Hddisk_name",length=30)
    private String Hddisk_name;
   
   @Column(name = "Majmin", length = 30)
    private String Majmin;
    
   @Column(name = "Mounted_on", length = 62)
    private String Mounted_on;
    
    @Column(name="partition_type",length=30)
    private String partition_type;
   
    @Column(name = "hdsize", length = 64)
    private String hdsize;
    
    @Column(name = "RO", length = 34)
    private String RO;
        
    @Column(name = "RM", length = 34)
    private String RM;
    
    public Jlinux_HDisk() {
    }

    public Jlinux_HDisk( String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super(H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
    }
    public Jlinux_HDisk(String Hddisk_name, String Majmin, String Mounted_on, String partition_type, String shdize, String RO, String RM, String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super(H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
        this.Hddisk_name = Hddisk_name;
        this.Majmin = Majmin;
        this.Mounted_on = Mounted_on;
        this.partition_type = partition_type;
        this.hdsize = hdsize;
        this.RO = RO;
        this.RM = RM;
    }

    public String getHddisk_name() {
        return Hddisk_name;
    }

    public void setHddisk_name(String Hddisk_name) {
        this.Hddisk_name = Hddisk_name;
    }

    public String getMajmin() {
        return Majmin;
    }

    public void setMajmin(String Majmin) {
        this.Majmin = Majmin;
    }

    public String getMounted_on() {
        return Mounted_on;
    }

    public void setMounted_on(String Mounted_on) {
        this.Mounted_on = Mounted_on;
    }

    public String getPartition_type() {
        return partition_type;
    }

    public void setPartition_type(String partition_type) {
        this.partition_type = partition_type;
    }

    public String gethdSize() {
        return hdsize;
    }

    public void sethdSize(String hdsize) {
        this.hdsize = hdsize;
    }

    public String getRO() {
        return RO;
    }

    public void setRO(String RO) {
        this.RO = RO;
    }

    public String getRM() {
        return RM;
    }

    public void setRM(String RM) {
        this.RM = RM;
    }
    
    @ManyToOne  
    private Jlinux_Host host;

    public String getHdsize() {
        return hdsize;
    }

    public void setHdsize(String hdsize) {
        this.hdsize = hdsize;
    }

    public Jlinux_Host getHost() {
        return host;
    }

    public void setHost(Jlinux_Host host) {
        this.host = host;
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hiber.DB.hw;

import com.sun.istack.internal.NotNull;
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
public class Jlinux_HDisk {
 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_HDisk_seq")
    @SequenceGenerator(
    name="Jlinux_HDisk_seq",
    sequenceName="Jlinux_HDisk_seq",
    allocationSize=1
    )
    @Id
    private Long id;
    
    @ManyToOne
     private Jlinux_H_WithTime  otm_host_hd;
   
    @NotNull
    @Column(name="HostId")
    private long J_HostId;
     
    @NotNull    
    @Column(name="UserId")
    private long J_UserId;
    
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

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(Jlinux_H_WithTime  host) {
        this.J_UserId = host.getUser().getUserId();
    }

    public String getHdsize() {
        return hdsize;
    }

    public void setHdsize(String hdsize) {
        this.hdsize = hdsize;
    }

    public Jlinux_H_WithTime getHost() {
        return otm_host_hd;
    }

    public void setHost(Jlinux_H_WithTime otm_host_hd) {
        this.otm_host_hd = otm_host_hd;
    }

    public Jlinux_HDisk( Jlinux_H_WithTime otm_host_hd, long J_HostId, long J_UserId, String Hddisk_name, String Majmin, String Mounted_on, String partition_type, String hdsize, String RO, String RM) {
        this.otm_host_hd = otm_host_hd;
        this.J_HostId = J_HostId;
        this.J_UserId = J_UserId;
        this.Hddisk_name = Hddisk_name;
        this.Majmin = Majmin;
        this.Mounted_on = Mounted_on;
        this.partition_type = partition_type;
        this.hdsize = hdsize;
        this.RO = RO;
        this.RM = RM;
    }

    @Override
    public String toString() {
        return "Jlinux_HDisk{" + "id=" + id + ", otm_host_hd=" + otm_host_hd + ", J_HostId=" + J_HostId + ", J_UserId=" + J_UserId + ", Hddisk_name=" + Hddisk_name + ", Majmin=" + Majmin + ", Mounted_on=" + Mounted_on + ", partition_type=" + partition_type + ", hdsize=" + hdsize + ", RO=" + RO + ", RM=" + RM + '}';
    }
    
    
}

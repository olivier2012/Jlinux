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
@Table(name = "Jlinux_HDisk")
public class HDisk {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_hdisk_seq")
    @SequenceGenerator(
    name="Jlinux_hdisk_seq",
    sequenceName="hdisk_sequence",
    allocationSize=1
    )
    private long HdId;

    public String getHost_name() {
        return Host_name;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }
    
    @Column(name="Host_name", length = 120)
    private String Host_name;
    
    @Column(name="Hddisk_name",length=20)
    private String Hddisk_name;
    
   @Column(name = "dev_name", length = 20)
    private String dev_name;
   
    @Column(name="blocks",length=12)
    private String blocks;
    
   @Column(name = "Mounted_on", length = 62)
    private String Mounted_on;
   
    @Column(name = "used", length = 30)
    private String used;

   @Column(name = "available", length = 30)
    private String available;
   
    @Column(name="partition", length = 20)
    private String partition;
    
    @Column(name="partition_type",length=10)
    private String partition_type;
   
    @Column(name = "units", length = 64)
    private String units;
       
   @Column(name = "sector", length = 64)
    private String sector;
   
    @Column(name = "io_size", length = 34)
    private String io_size;

   @Column(name = "disk_label", length = 30)
    private String disk_label;
   
    @Column(name="disk_id", length = 30)
    private String disk_id; 

    @Column(name="Access_time")
    private Date Access_time;

    public long getHdId() {
        return HdId;
    }

    public void setHdId(long HdId) {
        this.HdId = HdId;
    }

    public String getHddisk_name() {
        return Hddisk_name;
    }

    public void setHddisk_name(String Hddisk_name) {
        this.Hddisk_name = Hddisk_name;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getMounted_on() {
        return Mounted_on;
    }

    public void setMounted_on(String Mounted_on) {
        this.Mounted_on = Mounted_on;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public String getPartition_type() {
        return partition_type;
    }

    public void setPartition_type(String partition_type) {
        this.partition_type = partition_type;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIo_size() {
        return io_size;
    }

    public void setIo_size(String io_size) {
        this.io_size = io_size;
    }

    public String getDisk_label() {
        return disk_label;
    }

    public void setDisk_label(String disk_label) {
        this.disk_label = disk_label;
    }

    public String getDisk_id() {
        return disk_id;
    }

    public void setDisk_id(String disk_id) {
        this.disk_id = disk_id;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }

    
}

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
public class Jlinux_HDisk extends Jlinux_Host{
 
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

    public Jlinux_HDisk() {
    }

    public Jlinux_HDisk( String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super( H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
    }
    
    
}

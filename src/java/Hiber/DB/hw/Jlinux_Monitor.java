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
public class Jlinux_Monitor extends Jlinux_Host{
    
    public String getMonitor_name() {
        return Monitor_name;
    }

    public void setMonitor_name(String Monitor_name) {
        this.Monitor_name = Monitor_name;
    }

    public String getMonitor_type() {
        return Monitor_type;
    }

    public void setMonitor_type(String Monitor_type) {
        this.Monitor_type = Monitor_type;
    }

    public String getMonitor_IO_counts() {
        return Monitor_IO_counts;
    }

    public void setMonitor_IO_counts(String Monitor_IO_counts) {
        this.Monitor_IO_counts = Monitor_IO_counts;
    }

    public String getMonitor_IO_type() {
        return Monitor_IO_type;
    }

    public void setMonitor_IO_type(String Monitor_IO_type) {
        this.Monitor_IO_type = Monitor_IO_type;
    }

    public String getCommitlimit() {
        return commitlimit;
    }

    public void setCommitlimit(String commitlimit) {
        this.commitlimit = commitlimit;
    }
    
    @Column(name="Monitor_name",length=20)
    private String Monitor_name;
    
   @Column(name = "Monitor_type", length = 20)
    private String Monitor_type;
   
    @Column(name="Monitor_IO_counts",length=12)
    private String Monitor_IO_counts;
    
   @Column(name = "Monitor_IO_type", length = 12)
    private String Monitor_IO_type;
   
    @Column(name = "commitlimit", length = 22)
    private String commitlimit;

    public Jlinux_Monitor() {
    }

    public Jlinux_Monitor(long HostId, String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super(H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
    }
  
    
}

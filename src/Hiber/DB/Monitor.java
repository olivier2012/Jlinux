/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB;

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
@Table(name = "Jlinux_Monitor")
public class Monitor {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_Monitor_seq")
    @SequenceGenerator(
    name="Jlinux_Monitor_seq",
    sequenceName="Monitor_sequence",
    allocationSize=20
    )
    private long MonitorId;

    public long getMonitorId() {
        return MonitorId;
    }

    public void setMonitorId(long MonitorId) {
        this.MonitorId = MonitorId;
    }

    public String getHost_name() {
        return Host_name;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }

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

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }
    
    @Column(name="Host_name", length = 120)
    private String Host_name;
    
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
    
    @Column(name="Access_time")
    private Date Access_time;
}

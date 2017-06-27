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
@Table(name = "Jlinux_Host")
public class Host {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_host_seq")
    @SequenceGenerator(
    name="Jlinux_host_seq",
    sequenceName="host_sequence",
    allocationSize=20
    )
    private long HostId;
    
    @Column(name="Host_name",length=20)
    private String Host_name;
    
    @Column(name="network_id",length=18)
    private long NetworkId;
    
   @Column(name = "CpuId", length = 20)
    private long CpuId;
   
    @Column(name="HdId",length=20)
    private long HdId;
    
   @Column(name = "MemId", length = 20)
    private long MemID;
   
    @Column(name = "MonitorId" ,length = 20)
    private long MonitorId;

   @Column(name = "AccessorId", length = 20)
    private long AccessorId;

    public String getHost_name() {
        return Host_name;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }
   
    @Column(name="Access_time")
    private Date Access_time;

    public long getHostId() {
        return HostId;
    }

    public void setHostId(long HostId) {
        this.HostId = HostId;
    }

    public long getNetworkId() {
        return NetworkId;
    }

    public void setNetworkId(long NetworkId) {
        this.NetworkId = NetworkId;
    }

    public long getCpuId() {
        return CpuId;
    }

    public void setCpuId(long CpuId) {
        this.CpuId = CpuId;
    }

    public long getHdId() {
        return HdId;
    }

    public void setHdId(long HdId) {
        this.HdId = HdId;
    }

    public long getMemID() {
        return MemID;
    }

    public void setMemID(long MemID) {
        this.MemID = MemID;
    }

    public long getMonitorId() {
        return MonitorId;
    }

    public void setMonitorId(long MonitorId) {
        this.MonitorId = MonitorId;
    }

    public long getAccessorId() {
        return AccessorId;
    }

    public void setAccessorId(long AccessorId) {
        this.AccessorId = AccessorId;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }
    
}

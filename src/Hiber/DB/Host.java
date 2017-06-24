/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author olivier-h
 */
public class Host {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long HostId;
    
    @Column(name="network_id",length=40)
    private long NetworkId;
    
   @Column(name = "CpuId", length = 40)
    private long CpuId;
   
    @Column(name="HdId",length=60)
    private long HdId;
    
   @Column(name = "MemId", length = 40)
    private long MemID;
   
    @Column(name = "MonitorId" ,length = 40)
    private long MonitorId;

   @Column(name = "AccessorId", length = 80)
    private long AccessorId;
   
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

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
@Table(name = "Jlinux_Network")
public class Network {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_network_seq")
    @SequenceGenerator(
    name="Jlinux_network_seq",
    sequenceName="network_sequence",
    allocationSize=20
    )
    private long NetworkId;

    public long getNetworkId() {
        return NetworkId;
    }

    public void setNetworkId(long NetworkId) {
        this.NetworkId = NetworkId;
    }

    public String getHost_name() {
        return Host_name;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }

    public String getNet_cardId() {
        return Net_cardId;
    }

    public void setNet_cardId(String Net_cardId) {
        this.Net_cardId = Net_cardId;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String MemID) {
        this.MemID = MemID;
    }

    public String getIpv4_gw() {
        return ipv4_gw;
    }

    public void setIpv4_gw(String ipv4_gw) {
        this.ipv4_gw = ipv4_gw;
    }

    public String getRx() {
        return Rx;
    }

    public void setRx(String Rx) {
        this.Rx = Rx;
    }

    public String getTx() {
        return Tx;
    }

    public void setTx(String Tx) {
        this.Tx = Tx;
    }

    public String getIpv4_status() {
        return ipv4_status;
    }

    public void setIpv4_status(String ipv4_status) {
        this.ipv4_status = ipv4_status;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getIpv6_mask() {
        return ipv6_mask;
    }

    public void setIpv6_mask(String ipv6_mask) {
        this.ipv6_mask = ipv6_mask;
    }

    public String getIpv6_gw() {
        return ipv6_gw;
    }

    public void setIpv6_gw(String ipv6_gw) {
        this.ipv6_gw = ipv6_gw;
    }

    public String getIpv6_Rx() {
        return ipv6_Rx;
    }

    public void setIpv6_Rx(String ipv6_Rx) {
        this.ipv6_Rx = ipv6_Rx;
    }

    public String getIpv6_Tx() {
        return ipv6_Tx;
    }

    public void setIpv6_Tx(String ipv6_Tx) {
        this.ipv6_Tx = ipv6_Tx;
    }

    public String getIpv6_status() {
        return ipv6_status;
    }

    public void setIpv6_status(String ipv6_status) {
        this.ipv6_status = ipv6_status;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }
    
    @Column(name="Host_name", length = 120)
    private String Host_name;
        
    @Column(name="Net_cardId",length=40)
    private String Net_cardId;
    
   @Column(name = "MAC", length = 40)
    private String MAC;
   
    @Column(name="ipv4",length=32)
    private String ipv4;
    
   @Column(name = "ipv4_mask", length = 32)
    private String MemID;
   
    @Column(name = "ipv4_gw", length = 32)
    private String ipv4_gw;

   @Column(name = "Rx", length = 40)
    private String Rx;
   
    @Column(name="Tx", length = 40)
    private String Tx;
    
    @Column(name="ipv4_status",length=32)
    private String ipv4_status;
   
    @Column(name = "ipv6", length = 64)
    private String ipv6;
       
   @Column(name = "ipv6_mask", length = 64)
    private String ipv6_mask;
   
    @Column(name = "ipv6_gw", length = 64)
    private String ipv6_gw;

   @Column(name = "ipv6_Rx", length = 40)
    private String ipv6_Rx;
   
    @Column(name="ipv6_Tx", length = 40)
    private String ipv6_Tx; 
    
    @Column(name="ipv6_status",length=32)
    private String ipv6_status;
    
    @Column(name="Access_time")
    private Date Access_time;
}

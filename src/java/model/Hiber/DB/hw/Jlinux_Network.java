/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hiber.DB.hw;

import com.sun.istack.internal.NotNull;
import java.util.Date;
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
public class Jlinux_Network {
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_Network_seq")
    @SequenceGenerator(
    name="Jlinux_Network_seq",
    sequenceName="Jlinux_Network_seq",
    allocationSize=1
    )
    @Id
    private Long id;
    
    @ManyToOne
     private Jlinux_H_WithTime  otm_host_net;
   
    @NotNull
    @Column(name="HostId")
    private long J_HostId;
    
    @NotNull
    @Column(name="UserId")
    private long J_UserId;

    @Column(name="Net_cardId",length=40)
    private String Net_cardId;
    
    @Column(name="Net_name",length=40)
    private String Net_name;
   
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
    
    @Column(name="link_encap",length=32)
    private String link_encap;
        
    @Column(name="MTU",length=32)
    private String MTU;
            
    @Column(name="MAC",length=32)
    private String MAC;

    public Jlinux_Network() {
    }


    public String getNet_cardId() {
        return Net_cardId;
    }

    public void setNet_cardId(String Net_cardId) {
        this.Net_cardId = Net_cardId;
    }

    public String getNet_name() {
        return Net_name;
    }

    public void setNet_name(String Net_name) {
        this.Net_name = Net_name;
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

    public String getLink_encap() {
        return link_encap;
    }

    public void setLink_encap(String link_encap) {
        this.link_encap = link_encap;
    }

    public String getMTU() {
        return MTU;
    }

    public void setMTU(String MTU) {
        this.MTU = MTU;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(Jlinux_H_WithTime  host) {
        this.J_UserId = host.getUser().getUserId();
    }

    public Jlinux_Network( Jlinux_H_WithTime otm_host_net, long J_HostId, long J_UserId, String Net_cardId, String Net_name, String ipv4, String MemID, String ipv4_gw, String Rx, String Tx, String ipv4_status, String ipv6, String ipv6_mask, String ipv6_gw, String ipv6_Rx, String ipv6_Tx, String ipv6_status, String link_encap, String MTU, String MAC) {
        this.otm_host_net = otm_host_net;
        this.J_HostId = J_HostId;
        this.J_UserId = J_UserId;
        this.Net_cardId = Net_cardId;
        this.Net_name = Net_name;
        this.ipv4 = ipv4;
        this.MemID = MemID;
        this.ipv4_gw = ipv4_gw;
        this.Rx = Rx;
        this.Tx = Tx;
        this.ipv4_status = ipv4_status;
        this.ipv6 = ipv6;
        this.ipv6_mask = ipv6_mask;
        this.ipv6_gw = ipv6_gw;
        this.ipv6_Rx = ipv6_Rx;
        this.ipv6_Tx = ipv6_Tx;
        this.ipv6_status = ipv6_status;
        this.link_encap = link_encap;
        this.MTU = MTU;
        this.MAC = MAC;
    }

    @Override
    public String toString() {
        return "Jlinux_Network{" + "id=" + id + ", otm_host_net =" + otm_host_net + ", J_HostId=" + J_HostId + ", J_UserId=" + J_UserId + ", Net_cardId=" + Net_cardId + ", Net_name=" + Net_name + ", ipv4=" + ipv4 + ", MemID=" + MemID + ", ipv4_gw=" + ipv4_gw + ", Rx=" + Rx + ", Tx=" + Tx + ", ipv4_status=" + ipv4_status + ", ipv6=" + ipv6 + ", ipv6_mask=" + ipv6_mask + ", ipv6_gw=" + ipv6_gw + ", ipv6_Rx=" + ipv6_Rx + ", ipv6_Tx=" + ipv6_Tx + ", ipv6_status=" + ipv6_status + ", link_encap=" + link_encap + ", MTU=" + MTU + ", MAC=" + MAC + '}';
    }

    
     
}

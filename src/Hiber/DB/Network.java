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
public class Network {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long NetworkId;
    
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

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
public class Monitor {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long MonitorId;
    
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

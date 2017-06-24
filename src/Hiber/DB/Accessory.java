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
public class Accessory {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long AccessorId;
    
    @Column(name="keyboard_id",length=20)
    private String keyboard_id;
    
   @Column(name = "keyboard_name", length = 20)
    private String keyboard_name;
   
    @Column(name="mouse",length=12)
    private String mouse;
    
   @Column(name = "video_card", length = 12)
    private String video_card;
   
    @Column(name = "print", length = 22)
    private String print;
    
    @Column(name="Access_time")
    private Date Access_time;
}

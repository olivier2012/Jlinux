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
@Table(name = "Jlinux_Accessory")
public class Accessory {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_accessory_seq")
    @SequenceGenerator(
    name="Jlinux_accessory_seq",
    sequenceName="accessory_sequence",
    allocationSize=20
    )
    private long AccessorId;

    public void setAccessorId(long AccessorId) {
        this.AccessorId = AccessorId;
    }

    public void setHost_name(String Host_name) {
        this.Host_name = Host_name;
    }

    public void setKeyboard_id(String keyboard_id) {
        this.keyboard_id = keyboard_id;
    }

    public void setKeyboard_name(String keyboard_name) {
        this.keyboard_name = keyboard_name;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public void setVideo_card(String video_card) {
        this.video_card = video_card;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }
    
    @Column(name="Host_name", length = 120)
    private String Host_name;
    
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

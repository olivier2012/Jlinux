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
public class Jlinux_Accessory extends Jlinux_Host {
    
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

    public Jlinux_Accessory() {
    }

    public Jlinux_Accessory(String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super(H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
    }



}

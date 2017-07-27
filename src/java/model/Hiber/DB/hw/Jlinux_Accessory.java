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
 * only this table extends Jlinux_H_WithTime  , pay attention to  
 */
@Entity
public class Jlinux_Accessory  {
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_Accessory_seq")
    @SequenceGenerator(
    name="Jlinux_Accessory_seq",
    sequenceName="Jlinux_Accessory_seq",
    allocationSize=1
    )
    @Id
    private Long id;
    
    @ManyToOne
     private Jlinux_H_WithTime  otm_host_acc;
    @NotNull
    @Column(name="HostId")
    private long J_HostId;
    @NotNull    
    @Column(name="UserId")
    private long J_UserId;
    
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

    @Override
    public String toString() {
        return "Jlinux_Accessory{" + "id=" + id + ", otm_host_acc=" + otm_host_acc + ", J_HostId=" + J_HostId + ", J_UserId=" + J_UserId + ", keyboard_id=" + keyboard_id + ", keyboard_name=" + keyboard_name + ", mouse=" + mouse + ", video_card=" + video_card + ", print=" + print + '}';
    }

    public Jlinux_Accessory( Jlinux_H_WithTime otm_host_acc, long J_HostId, long J_UserId, String keyboard_id, String keyboard_name, String mouse, String video_card, String print) {
        this.otm_host_acc = otm_host_acc;
        this.J_HostId = J_HostId;
        this.J_UserId = J_UserId;
        this.keyboard_id = keyboard_id;
        this.keyboard_name = keyboard_name;
        this.mouse = mouse;
        this.video_card = video_card;
        this.print = print;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jlinux_H_WithTime getHost() {
        return otm_host_acc;
    }

    public void setHost(Jlinux_H_WithTime otm_host_acc) {
        this.otm_host_acc = otm_host_acc;
    }

    public long getJ_HostId() {
        return J_HostId;
    }

    public void setJ_HostId(long J_HostId) {
        this.J_HostId = J_HostId;
    }

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(long J_UserId) {
        this.J_UserId = J_UserId;
    }

    public String getKeyboard_id() {
        return keyboard_id;
    }

    public void setKeyboard_id(String keyboard_id) {
        this.keyboard_id = keyboard_id;
    }

    public String getKeyboard_name() {
        return keyboard_name;
    }

    public void setKeyboard_name(String keyboard_name) {
        this.keyboard_name = keyboard_name;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getVideo_card() {
        return video_card;
    }

    public void setVideo_card(String video_card) {
        this.video_card = video_card;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }




}

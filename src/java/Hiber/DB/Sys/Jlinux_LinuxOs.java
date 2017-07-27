/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.Sys;

import Hiber.DB.hw.*;
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
public class Jlinux_LinuxOs extends Jlinux_Host{
    @ManyToOne
     private Jlinux_Host  host;
    
    @Column(name="J_UserId")
    private long J_UserId;

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(Jlinux_H_WithTime  host) {
        this.J_UserId = host.getUser().getUserId();
    }
    
    @Column(name="Kernel_name",length=40)
    private String Kernel_name;
    
   @Column(name = "Node_name", length = 40)
    private String Node_name;
   
    @Column(name="Kernel_version",length=132)
    private String Kernel_version;
    
   @Column(name = "Build_time", length = 40)
    private String Build_time;
   
    @Column(name = "Hardware_platform", length = 40)
    private String Hardware_platform;

   @Column(name = "Architecture", length = 35)
    private String Architecture;
   
    @Column(name = "Operate_system", length = 45)
    private String Operate_system;

    public String getKernel_name() {
        return Kernel_name;
    }

    public void setKernel_name(String Kernel_name) {
        this.Kernel_name = Kernel_name;
    }

    public String getNode_name() {
        return Node_name;
    }

    public void setNode_name(String Node_name) {
        this.Node_name = Node_name;
    }

    public String getKernel_version() {
        return Kernel_version;
    }

    public void setKernel_version(String Kernel_version) {
        this.Kernel_version = Kernel_version;
    }

    public String getBuild_time() {
        return Build_time;
    }

    public void setBuild_time(String Build_time) {
        this.Build_time = Build_time;
    }

    public String getHardware_platform() {
        return Hardware_platform;
    }

    public void setHardware_platform(String Hardware_platform) {
        this.Hardware_platform = Hardware_platform;
    }

    public String getArchitecture() {
        return Architecture;
    }

    public void setArchitecture(String Architecture) {
        this.Architecture = Architecture;
    }

    public String getOperate_system() {
        return Operate_system;
    }

    public void setOperate_system(String Operate_system) {
        this.Operate_system = Operate_system;
    }

    public Jlinux_LinuxOs() {
    }

    public Jlinux_LinuxOs( String H_Host_name, String H_User_name, String H_Passwd) {
        super( H_Host_name,  H_User_name, H_Passwd);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hiber.DB.Sys;

import model.Hiber.DB.Sys.*;
import model.Hiber.DB.hw.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import model.CompositeKey.CompositeKey_U_H;

/**
 *
 * @author olivier-h
 */
@Entity
public class Jlinux_LinuxOs {
    
    @NotNull
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_linuxos_seq")
    @SequenceGenerator(
    name="Jlinux_linuxos_seq",
    sequenceName="Jlinux_linuxos_seq",
    allocationSize=1
    )
    @Id
    private Long id;
    
    @ManyToOne
     private Jlinux_H_WithTime  otm_host_os;
   
    @NotNull
    @Column(name="HostId")
    private long J_HostId;
    
    @NotNull
    @Column(name="UserId")
    private long J_UserId;

    public Jlinux_H_WithTime getHost() {
        return otm_host_os;
    }

    public void setHost(Jlinux_H_WithTime otm_host_os) {
        this.otm_host_os = otm_host_os;
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

    public void setJ_UserId(Jlinux_User  user) {
        this.J_UserId = user.getUserId();
    }
    @NotNull
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public Jlinux_LinuxOs(){};

    public Jlinux_LinuxOs( Jlinux_H_WithTime otm_host_os, long J_HostId, long J_UserId, String Kernel_name, String Node_name, String Kernel_version, String Build_time, String Hardware_platform, String Architecture, String Operate_system) {
        this.otm_host_os = otm_host_os;
        this.J_HostId = J_HostId;
        this.J_UserId = J_UserId;
        this.Kernel_name = Kernel_name;
        this.Node_name = Node_name;
        this.Kernel_version = Kernel_version;
        this.Build_time = Build_time;
        this.Hardware_platform = Hardware_platform;
        this.Architecture = Architecture;
        this.Operate_system = Operate_system;
    }

    @Override
    public String toString() {
        return "Jlinux_LinuxOs{" + "id=" + id + ", otm_host_os=" + otm_host_os + ", J_HostId=" + J_HostId + ", J_UserId=" + J_UserId + ", Kernel_name=" + Kernel_name + ", Node_name=" + Node_name + ", Kernel_version=" + Kernel_version + ", Build_time=" + Build_time + ", Hardware_platform=" + Hardware_platform + ", Architecture=" + Architecture + ", Operate_system=" + Operate_system + '}';
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Hiber.DB.hw;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author olivier-h
 */
@Entity
public class Jlinux_Monitor {
    
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_Monitor_seq")
    @SequenceGenerator(
    name="Jlinux_Monitor_seq",
    sequenceName="Jlinux_Monitor_seq",
    allocationSize=1
    )
    @Id
    private Long id;
    
    @ManyToOne
     private Jlinux_H_WithTime  otm_host_mon;
   
    @NotNull
    @Column(name="HostId")
    private long J_HostId;
     
    @NotNull    
    @Column(name="UserId")
    private long J_UserId;
    
    @Column(name="description",length=30)
    private String description;
    
   @Column(name = "product", length = 30)
    private String product;
   
    @Column(name="vendor",length=30)
    private String vendor;
    
   @Column(name = "physical_id", length = 12)
    private String physical_id;
   
    @Column(name = "bus_info", length = 30)
    private String bus_info;
    
    @Column(name = "version", length = 30)
    private String version;
   
    @Column(name="width",length=30)
    private String width;
    
   @Column(name = "clock", length = 12)
    private String clock;
   
    @Column(name = "capabilities", length = 30)
    private String capabilities;
    
    
    @Column(name = "configuration", length = 30)
    private String configuration;
    
    @Column(name = "resources", length = 100)
    private String resources;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPhysical_id() {
        return physical_id;
    }

    public void setPhysical_id(String physical_id) {
        this.physical_id = physical_id;
    }

    public String getBus_info() {
        return bus_info;
    }

    public void setBus_info(String bus_info) {
        this.bus_info = bus_info;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Jlinux_Monitor() {
    }

    public long getJ_UserId() {
        return J_UserId;
    }

    public void setJ_UserId(Jlinux_H_WithTime  host) {
        this.J_UserId = host.getUser().getUserId();
    }

    public Jlinux_Monitor(Jlinux_H_WithTime otm_host_mon, long J_HostId, long J_UserId, String description, String product, String vendor, String physical_id, String bus_info, String version, String width, String clock, String capabilities, String configuration, String resources) {
        this.otm_host_mon = otm_host_mon;
        this.J_HostId = J_HostId;
        this.J_UserId = J_UserId;
        this.description = description;
        this.product = product;
        this.vendor = vendor;
        this.physical_id = physical_id;
        this.bus_info = bus_info;
        this.version = version;
        this.width = width;
        this.clock = clock;
        this.capabilities = capabilities;
        this.configuration = configuration;
        this.resources = resources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jlinux_H_WithTime getHost() {
        return otm_host_mon;
    }

    public void setHost(Jlinux_H_WithTime otm_host_mon) {
        this.otm_host_mon = otm_host_mon;
    }

    public long getJ_HostId() {
        return J_HostId;
    }

    public void setJ_HostId(long J_HostId) {
        this.J_HostId = J_HostId;
    }

    @Override
    public String toString() {
        return "Jlinux_Monitor{" + "id=" + id + ", otm_host_mon =" + otm_host_mon + ", J_HostId=" + J_HostId + ", J_UserId=" + J_UserId + ", description=" + description + ", product=" + product + ", vendor=" + vendor + ", physical_id=" + physical_id + ", bus_info=" + bus_info + ", version=" + version + ", width=" + width + ", clock=" + clock + ", capabilities=" + capabilities + ", configuration=" + configuration + ", resources=" + resources + '}';
    }
    
}

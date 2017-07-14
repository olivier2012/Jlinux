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
public class Jlinux_Monitor extends Jlinux_Host{
    
  
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

    public Jlinux_Monitor(String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super(H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
    }
   
    
}

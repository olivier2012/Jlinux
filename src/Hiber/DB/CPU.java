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
public class CPU {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long CPUId;
    
    @Column(name="Processor",length=20)
    private String Processor;
    
   @Column(name = "vendor_id", length = 20)
    private String vendor_id;
   
    @Column(name="cpu_family",length=12)
    private String cpu_family;
    
   @Column(name = "model", length = 12)
    private String model;
   
    @Column(name = "model_name", length = 22)
    private String model_name;

   @Column(name = "step", length = 10)
    private String step;
   
    @Column(name="cpu_mhz", length = 20)
    private String cpu_mhz;
    
    @Column(name="cpu_cores",length=5)
    private String cpu_cores;
   
    @Column(name = "flags", length = 64)
    private String flags;
       
   @Column(name = "bogomips", length = 64)
    private String bogomips;
   
    @Column(name = "clflush_size", length = 14)
    private String clflush_size;

   @Column(name = "cache_alignment", length = 20)
    private String cache_alignment;
   
    @Column(name="address_size", length = 30)
    private String address_size; 
    
    @Column(name="cpu_core_id",length=12)
    private String cpu_core_id;
    
    @Column(name="Access_time")
    private Date Access_time;

    public long getCPUId() {
        return CPUId;
    }

    public void setCPUId(long CPUId) {
        this.CPUId = CPUId;
    }

    public String getProcessor() {
        return Processor;
    }

    public void setProcessor(String Processor) {
        this.Processor = Processor;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getCpu_family() {
        return cpu_family;
    }

    public void setCpu_family(String cpu_family) {
        this.cpu_family = cpu_family;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getCpu_mhz() {
        return cpu_mhz;
    }

    public void setCpu_mhz(String cpu_mhz) {
        this.cpu_mhz = cpu_mhz;
    }

    public String getCpu_cores() {
        return cpu_cores;
    }

    public void setCpu_cores(String cpu_cores) {
        this.cpu_cores = cpu_cores;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getBogomips() {
        return bogomips;
    }

    public void setBogomips(String bogomips) {
        this.bogomips = bogomips;
    }

    public String getClflush_size() {
        return clflush_size;
    }

    public void setClflush_size(String clflush_size) {
        this.clflush_size = clflush_size;
    }

    public String getCache_alignment() {
        return cache_alignment;
    }

    public void setCache_alignment(String cache_alignment) {
        this.cache_alignment = cache_alignment;
    }

    public String getAddress_size() {
        return address_size;
    }

    public void setAddress_size(String address_size) {
        this.address_size = address_size;
    }

    public String getCpu_core_id() {
        return cpu_core_id;
    }

    public void setCpu_core_id(String cpu_core_id) {
        this.cpu_core_id = cpu_core_id;
    }

    public Date getAccess_time() {
        return Access_time;
    }

    public void setAccess_time(Date Access_time) {
        this.Access_time = Access_time;
    }
    
    
}

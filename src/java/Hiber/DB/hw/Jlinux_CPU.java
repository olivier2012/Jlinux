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
public class Jlinux_CPU extends Jlinux_Host {

    @Column(name="processor",length=20)
    private String processor;
    
   @Column(name = "vendor_id", length = 20)
    private String vendor_id;
   
    @Column(name="cpu_family",length=12)
    private String cpu_family;
    
   @Column(name = "model", length = 12)
    private String model;
   
    @Column(name = "model_name", length = 250)
    private String model_name;

   @Column(name = "stepping", length = 5)
    private String stepping;
   
    @Column(name = "microcode", length = 5)
    private String microcode;
   
    @Column(name="cpu_mhz", length = 20)
    private String cpu_mhz;
      
    @Column(name="cache_size", length = 20)
    private String cache_size;
    
    @Column(name="physical_id", length = 20)
    private String physical_id;
    
    @Column(name="siblings", length = 20)
    private String siblings;
    
    @Column(name="core_id", length = 20)
    private String core_id;
    
    @Column(name="apicid", length = 20)
    private String apicid;
    
    @Column(name="initial_apicid", length = 20)
    private String initial_apicid;
    
    @Column(name="fpu", length = 20)
    private String fpu;
    
    @Column(name="fpu_exception", length = 20)
    private String fpu_exception;
    
    @Column(name="cpuid_level", length = 20)
    private String cpuid_level;
    
    @Column(name="wp", length = 20)
    private String wp;
    
    @Column(name="power_management", length = 120)
    private String power_management;
    
    @Column(name="cpu_cores",length=5)
    private String cpu_cores;
   
    @Column(name = "flags", length = 545)
    private String flags;
       
   @Column(name = "bogomips", length = 64)
    private String bogomips;
   
    @Column(name = "clflush_size", length = 14)
    private String clflush_size;

   @Column(name = "cache_alignment", length = 20)
    private String cache_alignment;
   
    @Column(name="address_size", length = 150)
    private String address_size; 

    public Jlinux_CPU(){};
    
    public Jlinux_CPU( String processor, String vendor_id, String cpu_family, String model, String model_name, String stepping, String microcode, String cpu_mhz, String cache_size, String physical_id, String siblings, String core_id, String apicid, String initial_apicid, String fpu, String fpu_exception, String cpuid_level, String wp, String power_management, String cpu_cores, String flags, String bogomips, String clflush_size, String cache_alignment, String address_size) {
        this.processor = processor;
        this.vendor_id = vendor_id;
        this.cpu_family = cpu_family;
        this.model = model;
        this.model_name = model_name;
        this.stepping = stepping;
        this.microcode = microcode;
        this.cpu_mhz = cpu_mhz;
        this.cache_size = cache_size;
        this.physical_id = physical_id;
        this.siblings = siblings;
        this.core_id = core_id;
        this.apicid = apicid;
        this.initial_apicid = initial_apicid;
        this.fpu = fpu;
        this.fpu_exception = fpu_exception;
        this.cpuid_level = cpuid_level;
        this.wp = wp;
        this.power_management = power_management;
        this.cpu_cores = cpu_cores;
        this.flags = flags;
        this.bogomips = bogomips;
        this.clflush_size = clflush_size;
        this.cache_alignment = cache_alignment;
        this.address_size = address_size;
    }

    public Jlinux_CPU( String processor, String vendor_id, String cpu_family, String model, String model_name, String stepping, String microcode, String cpu_mhz, String cache_size, String physical_id, String siblings, String core_id, String apicid, String initial_apicid, String fpu, String fpu_exception, String cpuid_level, String wp, String power_management, String cpu_cores, String flags, String bogomips, String clflush_size, String cache_alignment, String address_size, long HostId, String H_Host_name, long UserId, String H_User_name, String H_Passwd, Date Access_time, Date Created_time, String Host_UUID) {
        super( H_Host_name, UserId, H_User_name, H_Passwd, Access_time, Created_time, Host_UUID);
        this.processor = processor;
        this.vendor_id = vendor_id;
        this.cpu_family = cpu_family;
        this.model = model;
        this.model_name = model_name;
        this.stepping = stepping;
        this.microcode = microcode;
        this.cpu_mhz = cpu_mhz;
        this.cache_size = cache_size;
        this.physical_id = physical_id;
        this.siblings = siblings;
        this.core_id = core_id;
        this.apicid = apicid;
        this.initial_apicid = initial_apicid;
        this.fpu = fpu;
        this.fpu_exception = fpu_exception;
        this.cpuid_level = cpuid_level;
        this.wp = wp;
        this.power_management = power_management;
        this.cpu_cores = cpu_cores;
        this.flags = flags;
        this.bogomips = bogomips;
        this.clflush_size = clflush_size;
        this.cache_alignment = cache_alignment;
        this.address_size = address_size;
    }


    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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

    public String getStepping() {
        return stepping;
    }

    public void setStepping(String stepping) {
        this.stepping = stepping;
    }

    public String getMicrocode() {
        return microcode;
    }

    public void setMicrocode(String microcode) {
        this.microcode = microcode;
    }

    public String getCpu_mhz() {
        return cpu_mhz;
    }

    public void setCpu_mhz(String cpu_mhz) {
        this.cpu_mhz = cpu_mhz;
    }

    public String getCache_size() {
        return cache_size;
    }

    public void setCache_size(String cache_size) {
        this.cache_size = cache_size;
    }

    public String getPhysical_id() {
        return physical_id;
    }

    public void setPhysical_id(String physical_id) {
        this.physical_id = physical_id;
    }

    public String getSiblings() {
        return siblings;
    }

    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    public String getCore_id() {
        return core_id;
    }

    public void setCore_id(String core_id) {
        this.core_id = core_id;
    }

    public String getApicid() {
        return apicid;
    }

    public void setApicid(String apicid) {
        this.apicid = apicid;
    }

    public String getInitial_apicid() {
        return initial_apicid;
    }

    public void setInitial_apicid(String initial_apicid) {
        this.initial_apicid = initial_apicid;
    }

    public String getFpu() {
        return fpu;
    }

    public void setFpu(String fpu) {
        this.fpu = fpu;
    }

    public String getFpu_exception() {
        return fpu_exception;
    }

    public void setFpu_exception(String fpu_exception) {
        this.fpu_exception = fpu_exception;
    }

    public String getCpuid_level() {
        return cpuid_level;
    }

    public void setCpuid_level(String cpuid_level) {
        this.cpuid_level = cpuid_level;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getPower_management() {
        return power_management;
    }

    public void setPower_management(String power_management) {
        this.power_management = power_management;
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

    
}

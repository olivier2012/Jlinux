/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hiber.DB.hw;

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
@Table(name = "Jlinux_simpletest")
public class simpletest {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Jlinux_simpletest_seq")
    @SequenceGenerator(
    name="Jlinux_simpletest_seq",
    sequenceName="simpletest_sequence",
    allocationSize=20
    )
    private long AccessorId;
    
    @Column(name="name",length=20)
    private String name; 
}

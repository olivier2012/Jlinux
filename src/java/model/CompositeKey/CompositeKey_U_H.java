/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CompositeKey;

import java.io.Serializable;
import java.util.Objects;
import model.Hiber.DB.hw.*;

/**
 *
 * @author olivier-h
 */
public class CompositeKey_U_H implements Serializable{
     protected Jlinux_User userkey;
     protected Jlinux_H_WithTime hostkey;

    public CompositeKey_U_H(Jlinux_User userkey, Jlinux_H_WithTime hostkey) {
        this.userkey = userkey;
        this.hostkey = hostkey;
    }

    public CompositeKey_U_H() {
    }

    @Override
    public int hashCode() {
        return (int) (userkey.getUserId()+hostkey.getHostId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompositeKey_U_H other = (CompositeKey_U_H) obj;
        if (!Objects.equals(this.userkey, other.userkey)) {
            return false;
        }
        if (!Objects.equals(this.hostkey, other.hostkey)) {
            return false;
        }
        return true;
    }
     
      
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl.function;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olivier-h
 */
public class global_function {
     public String getAtribeNames_enum(HttpServletRequest request){
        
         try{
         StringBuilder toLog = new StringBuilder();  

        Enumeration attributeNames = request.getAttributeNames();           

        while(attributeNames.hasMoreElements()) {
            String current = (String) attributeNames.nextElement();

            toLog.append(current + "=" + request.getAttribute(current));            

            if(attributeNames.hasMoreElements()) {
                toLog.append(", ");
            }           
        }       

        return "TRACKER_ATTRIBUTES={"+ toLog.toString() + "}";
    }
    catch (Exception ex) {
        return "TRACKER_ATTRIBUTES={" + ex+ "}";
    }               
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jl;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;
import java.util.Scanner;

/**
 *
 * @author olivier-h
 */
public class MyUserInfo implements UserInfo,UIKeyboardInteractive {
    public String getPassword(){ return null; }
    public String getPassphrase(){ return null; }
    public boolean promptPassphrase(String message){ return false; }
    public boolean promptPassword(String message){ return false; }
                public void showMessage(String message){
             System.out.println(message);
            }
           public boolean promptYesNo(String message){
               boolean options= true;
               System.out.print(message + " (y/Y/N/n) : ");
               Scanner sc = new Scanner(System.in);
               String foo=sc.next();
               if(foo.equalsIgnoreCase("y")){
                 return true;
                 }else{
                 return false;
               }
           }
    public String[] promptKeyboardInteractive(String destination,
                                              String name,
                                              String instruction,
                                              String[] prompt,
                                              boolean[] echo){
      return null;
    }
}

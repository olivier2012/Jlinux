/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author olivier-h
 */
public class testLinedHashMapSequence {
        public static void main(String args[])

    {
   Map<String,Integer> map=  new LinkedHashMap<String,Integer>();

   // put some values into map

   map.put("first",1);
   map.put("second",2);
   map.put("third",3);
   map.put("fourth",4);
   map.put("fifth",5);
   map.put("sixth",6);
   map.put("seventh",7);
   map.put("eighth",8);
   map.put("ninth",9);



    Iterator iterator= map.entrySet().iterator();
       while(iterator.hasNext())
       {
           Entry entry =(Entry)iterator.next();   
           System.out.println(" entries= "+entry.getKey().toString());
       }

    }
}

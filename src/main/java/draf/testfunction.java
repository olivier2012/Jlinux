/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draf;

import Hiber.DB.hw.Network_data;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jl.DBinit;
import jl.function.Network_function;

/**
 *
 * @author olivier-h
 */
public class testfunction {
        public static void main(String[] args) throws IOException {
        System.out.println("main begin.........! ");
        String System_info="Iface   MTU Met   RX-OK RX-ERR RX-DRP RX-OVR    TX-OK TX-ERR TX-DRP TX-OVR Flg\n" +
"br-ex      1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"br-int     1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"br-tun     1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"docker0    1500 0         0      0      0 0             0      0      0      0 BMU\n" +
"eth0       1500 0        10      0      0 0            93      0      0      0 BMRU\n" +
"eth1       1500 0       184      0      0 0           123      0      0      0 BMRU\n" +
"eth2       1500 0        14      0      0 0            76      0      0      0 BMRU\n" +
"lo        65536 0       441      0      0 0           441      0      0      0 LRU\n" +
"qg-1883a8c5-77  1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"qr-48b82efa-1f  1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"qr-c09bd495-9d  1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"tapbd0419bd-4e  1500 0         0      0      0 0             8      0      0      0 BRU\n" +
"virbr0     1500 0         0      0      0 0             0      0      0      0 BMU";
                String Host_name = "192.168.2.204";
                    String Orig_System_info = System_info;

            /*here we need to detect whether the network  multi interfaces  */
            Map<String,String> smntmp = new HashMap<String,String>();
              Map<String,String> tmpHm = new HashMap<String,String>();
            boolean aaa = Network_function.ismultiNet(Orig_System_info);
            if (Network_function.ismultiNet(Orig_System_info)) {
                String[] multipS = Network_function.multiNet(Orig_System_info);
                /* split "\r\n\r\n " this word is first one , so we jump the multipS the 0 one . */
                for (int i = 0; i < multipS.length; i++) {
                    if(i!=0){
                    smntmp = tmpHm;
                    }
                    String System_info1 = multipS[i];
                    tmpHm = Network_function.String2map_network(System_info1,i,smntmp);
                    tmpHm.forEach((k,v)-> System.out.println("key :"+k + "  value : "+v));
                }
            } else {
                tmpHm.put("Host_name", Host_name);
                /* */
//                log.info("ready  the cpu info , covert it to map");
//                Network_data.add((HashMap) tmpHm);
            }
        }
}

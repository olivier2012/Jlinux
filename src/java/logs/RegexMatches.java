package logs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   private static final String REGEX = "^resources.*";
   private static final String INPUT = "resources: irq:16 ioport:1070(size=16) memory:e8000000-efffffff memory:fe000000-fe7fffff memory:c0000000-c0007fff";
//    private static final String INPUT = "bus:::::::: ";
   private static Pattern pattern;
   private static Matcher matcher;

   public static void main( String args[] ) {
      pattern = Pattern.compile(REGEX);
      matcher = pattern.matcher(INPUT);
/*
      System.out.println("Current REGEX is: "+REGEX);
      System.out.println("Current INPUT is: "+INPUT);

      System.out.println("lookingAt(): "+matcher.lookingAt());
      System.out.println("matches(): "+matcher.matches());
      System.out.println("=========================");*/
      String sst=RE_Format_monitor(INPUT);
//      String sst1= INPUT.replace(":", "_");
      System.out.println(sst);
      
   }
   
    public static String RE_Format_monitor(String st){
           StringBuilder sbtmp = new StringBuilder();
   /* 1, handle this " bus info: pci@0000:00:02.0 "  , only keep the first colon , the second one and third one  , will be replace  */
//           String st1 = "bus:::::::: ";
           String REGEX = "^bus.*$";
           Pattern pattern = Pattern.compile(REGEX);
           Matcher matcher = pattern.matcher(st);
           st =replaceColon_keepfirst(replaceColon_(st));
           System.out.println(st);
           char[] ca = st.toCharArray();
           
          if (matcher.matches()){
           /*   for(int i =0 ; i < st.length();i++){
                 if (ca[i]==(char)":")*/
                     
              }
           
           
           return st;
     } 
    
    private static String replaceColon_(String orig) {
        return orig.replaceAll("\\:", "_");
    }
    private static String replaceColon_keepfirst(String orig) {
        return orig.replaceFirst("_", "\\:");
    }
}

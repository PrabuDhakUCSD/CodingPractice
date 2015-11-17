package Misc;

import java.util.*;
import java.lang.*;

public class GenerateUniqueId {
   private final static long systemStartTime = System.currentTimeMillis();
   private final static int serverId = 3;
   private final static Random r = new Random();

   public static void run() {
      Date now = new Date();
      long elapsedTime = System.currentTimeMillis() - systemStartTime;
      long intValue = elapsedTime << 6;
      intValue |= serverId << 2;
      intValue |= r.nextInt(16);
      
      String encodedString = encodeIntToString(intValue);
      System.out.println(now.toString() + "\t: " + intValue + "\t: " + encodedString);
   }
   
   private static String encodeIntToString(long intVal) {
      String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJALMNOPQRSTUVWXYZ0123456789";
      int charSetLen = charSet.length();
      StringBuilder out = new StringBuilder();
      
      while(intVal > 0) {
         out.append(charSet.charAt((int)(intVal % charSetLen)));
         intVal /= charSetLen;
      }
      
      return out.reverse().toString();
   }
   
   public static void main(String args[]) {
   
      new Thread(new Runnable() {
            Random r = new Random();
            @Override
            public void run() {
               while(true) {
                  GenerateUniqueId.run();
                  try {
                     Thread.sleep(r.nextInt(1000));
                  } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
               }
            }
         }).start();
      
      new Thread(new Runnable() {
         Random r = new Random();
         @Override
         public void run() {
            while(true) {
               GenerateUniqueId.run();
               try {
                  Thread.sleep(r.nextInt(1000));
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         }
      }).start();
      
   }
}
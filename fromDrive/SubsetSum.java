package Misc;

import java.util.*;

public class SubsetSum {
   public static List<Integer> getSubSet(int[] ip, int s) {
      List<Integer> output = new ArrayList<Integer>();
      helper(ip, 0, s, output);
      return output;
   }
   
   public static boolean helper(int[] ip, int si, int s, List<Integer> output) {
      if (si >= ip.length) {
         if (s != 0)
            return false;
         return true;
      }
      
      if (helper(ip, si+1, s-ip[si], output)) {
         output.add(ip[si]);
         return true;
      }
      
      if (helper(ip, si+1, s, output))
         return true;
      
      return false;
   }
   
   public static void main(String args[]) {
      int[] ip = {1,4,6, -5, 3, 8, 10, 11, 0, -7, -2};
      List<Integer> op = getSubSet(ip, 28);
      for(int i:op){
         System.out.println(i);
      }
   }
}

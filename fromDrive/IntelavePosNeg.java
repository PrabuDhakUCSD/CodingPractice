package Misc;

import java.util.Arrays;

public class IntelavePosNeg {
   public static void interleave(int[] ip) {
      for(int i=0; i<ip.length; i++) {
         if ((i%2 == 0 && ip[i] >= 0) || (i%2 == 1 && ip[i] < 0))
            continue;
         
         int ind = getNext(ip, i+1, ip[i]);
         if (ind == -1)
            break;
         
         int correctVal = ip[ind];
         for (int j=ind-1; j>=i; j--) {
            ip[j+1] = ip[j];
         }
         
         ip[i] = correctVal;
      }
   }
   
   private static int getNext(int[] ip, int fromInd, int currentVal) {
      for (int i=fromInd; i<ip.length; i++) {
         if ((currentVal < 0 && ip[i] >=0) || (currentVal >=0 && ip[i] < 0))
            return i;
      }
      
      return -1;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {1,2,3,4,-1,-2,-3,-4};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
      
      ip = new int[] {-1,-2,-3,-4,1,2,3,4};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
      
      ip = new int[] {1,2,3,-1,4,-2,-3,-4,-5,-6,5,6};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
      
      ip = new int[] {1,-1,2,-2,3,4,5,-3,-4,-5,-6,-7,-8,-9,6};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
      
      ip = new int[] {1,2,3,4};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
      
      ip = new int[] {-1,-2,-3,-4};
      interleave(ip);
      System.out.println(Arrays.toString(ip));
   }
}

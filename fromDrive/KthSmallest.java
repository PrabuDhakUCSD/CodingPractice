package Misc;

import java.util.Random;

public class KthSmallest {
   public static int getKthSmallest(int[] ip, int k) {
      if (ip == null || ip.length == 0 || k < 1 || k > ip.length)
         throw new IllegalArgumentException();
      
      k = k-1;
      int s=0, e=ip.length-1;
      int piv;
      while (true) {
         piv = partition(ip, s, e);
         if (piv == k)
            break;
         
         if (k < piv) {
            e = piv -1;
         } else {
            s = piv + 1;
         }
      }
      
      return ip[piv];
   }
   
   private static int partition(int[] ip, int s, int e) {
      if (s > e)
         return -1;
      
      if (s == e)
         return s;
      
      int pivInd = s + new Random().nextInt(e-s+1);
      swap(ip, pivInd, e);
      pivInd = e;
      int pivVal = ip[pivInd];
      
      int lastSmall = s-1;
      int cur = s;
      
      for(; cur<pivInd; cur++) {
         if (ip[cur] > pivVal )
            continue;
         
         if (++lastSmall != cur) {
            swap(ip, lastSmall, cur);
         }
      }
      
      swap(ip, ++lastSmall, pivInd);
      return lastSmall;
   }
   
   private static void swap(int[] ip, int i, int j) {
      int temp = ip[i];
      ip[i] = ip[j];
      ip[j] = temp;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {7,3,4,8,9,1,2,5,6};
      
      for ( int i=1; i<= ip.length; i++) {
         System.out.println(getKthSmallest(ip, i));
      }
   }
}

package Misc;

import java.util.*;

public class GetKLargest {
   public static Integer[] getKLargest(int[] ip, int k) {
      if (ip == null || ip.length == 0 || k < 0 || k > ip.length)
         throw new IllegalArgumentException();
      
      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
                                             @Override
                                             public int compare(Integer a, Integer b) {
                                                return a - b;
                                             }
                                          });
      
      for (int i=0; i<k; i++) {
         minHeap.add(ip[i]);
      }
      
      for (int i=k; i< ip.length; i++) {
         if (ip[i] > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(ip[i]);
         }
      }
      
      return minHeap.toArray(new Integer[]{});
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {5,1,8,2,4,3,10,9,7,6,11};
      System.out.println(Arrays.toString(getKLargest(ip, 10)));
   }
}
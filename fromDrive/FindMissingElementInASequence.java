package Misc;

public class FindMissingElementInASequence {
   public static int missingElement(int[] input) {
      if (input == null || input.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int s=0, e=input.length-1;
      int mid;
      
      while (s <= e) {
         mid = (s+e)/2;
         
         if (input[mid] == mid) {
            s = mid+1;
         } else if (mid == s || input[mid-1] == mid-1) {
            return mid;
         } else {
            e = mid-1;
         }
      }
      
      return -1;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {1,2,3,4,5,6,7,8,9};
      System.out.println(missingElement(ip));
   }
 }

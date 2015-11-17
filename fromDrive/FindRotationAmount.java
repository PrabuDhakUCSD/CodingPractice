package Misc;

public class FindRotationAmount {
   public static int findRotation(int[] input) {
      int s=0, e=input.length-1;
      int mid;
      
      while (s < e) {
         mid = (s+e)/2;
         
         if (input[mid] > input[e]) {
            s=mid+1;
         } else {
            e=mid;
         }
      }
      
      return s;
   }
   
   public static void main(String args[]) {
      System.out.println(findRotation(new int[] {1,2,3}));
      System.out.println(findRotation(new int[] {3,1,2}));
      System.out.println(findRotation(new int[] {2,3,1}));
      System.out.println(findRotation(new int[] {4,5,6,1,2,3}));
      System.out.println(findRotation(new int[] {10,11,12,13,14,15,16,8,9}));
      System.out.println(findRotation(new int[] {15,16,10,11,12,13,14}));
   }
}

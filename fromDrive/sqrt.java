package Misc;

public class sqrt {
   public static int getSqrt(int ip) {
      if (ip == 0 || ip == 1)
         return ip;
      
      int start=1;
      int end = ip/2;
      int mid;
      
      int result = -1;

      while (start<=end) {
         mid = start + (end-start)/2;
         if (mid*mid == ip) {
            result = mid;
            break;
         }

         if (mid*mid > ip) {
            end = mid-1;
         } else {
            result = mid;
            start = mid+1;
         }
      }

      return result;
   }
   
   public static void main(String args[]) {
      System.out.println(getSqrt(2));
      System.out.println(getSqrt(3));
      System.out.println(getSqrt(4));
      System.out.println(getSqrt(7));
      System.out.println(getSqrt(9));
      System.out.println(getSqrt(12));
      System.out.println(getSqrt(14));
      System.out.println(getSqrt(16));
      System.out.println(getSqrt(20));
      System.out.println(getSqrt(22));
      System.out.println(getSqrt(24));
      System.out.println(getSqrt(25));
      System.out.println(getSqrt(28));
      System.out.println(getSqrt(33));
      System.out.println(getSqrt(36));
      System.out.println(getSqrt(38));
      System.out.println(getSqrt(40));
      System.out.println(getSqrt(42));
      System.out.println(getSqrt(47));
      System.out.println(getSqrt(49));
      System.out.println(getSqrt(200));
   }
}

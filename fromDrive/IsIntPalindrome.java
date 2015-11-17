package Misc;

public class IsIntPalindrome {
   public static boolean isPalin(int n) {
      if (n < 10)
         return true;
      
      int numDigits = 2;
      while( n >= Math.pow(10, numDigits))
         numDigits++;
      
      int divider = (int) Math.pow(10, numDigits-1);
      
      while(n >= 10) {
         int ldig = n/divider;
         int rdig = n%10;
         
         if (ldig != rdig)
            return false;
         
         n = n-(ldig * divider);
         n = n/10;
         
         divider = divider/100;
      }
      
      return true;
   }
   
   public static void main(String args[]) {
      System.out.println("56765 : " + isPalin(56765));
      System.out.println("56745 : " + isPalin(56745));
      System.out.println("5665 : " + isPalin(5665));
      System.out.println("10 : " + isPalin(10));
      System.out.println("010 : " + isPalin(010));
   }
}

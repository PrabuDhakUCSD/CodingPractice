package Misc;

public class GCDFinder {
   public static int gcd(int small, int big) {
      if (small == 0) 
         return big;
      
      return gcd(big%small, small);
   }
   
   public static int lcm(int a, int b) {
      if ( a == 0 || b == 0)
         return 0;
      
      return (a/gcd(a,b)) * b;
   }
   
   public static void main(String args[]) {
      System.out.println(gcd(4,12));
      System.out.println(gcd(3,9));
      System.out.println(gcd(15,125));
      System.out.println(gcd(16,4));
      System.out.println(gcd(0,13));
      System.out.println(gcd(1,10));
      System.out.println(gcd(100,100));
      
      System.out.println("----------------\n\n");
      
      System.out.println(lcm(4,12));
      System.out.println(lcm(21,6));
      System.out.println(lcm(0,6));
      System.out.println(lcm(3,10));
   }
}

package Misc;

import java.util.*;

public class GeneratePrimes {
   public static boolean isPrime(int num) {
      if (num <= 1)
         return false;
      
      if (num%2 == 0)
         return false;
      
      for (int i=3; i<= Math.ceil(Math.sqrt(num));) {
         if (num%i == 0)
            return false;
         
         i += 2;
      }
      
      return true;
   }
   
   public static List<Integer> genPrimes(int dig, int count) {
      List<Integer> output = new ArrayList<Integer>();
      
      int start = (int) Math.pow(10, dig-1);
      while (start % 6 != 0)
         start++;
      int end = (int) Math.pow(10, dig) - 1;
      
      while (count > 0) {
         if (start-1 > end)
            break;
         
         if (isPrime(start-1)) {
            output.add(start-1);
            count--;
         }
         
         if (start+1 > end)
            break;
         
         if (count > 0 && isPrime(start+1)) {
            output.add(start+1);
            count--;
         }
         
         start += 6;
      }
      
      return output;
   }
   
   public static void main(String args[]) {
      List<Integer> primes = genPrimes(3, 1000);
      for (Integer i : primes) {
         System.out.println(i);
      }
   }
}

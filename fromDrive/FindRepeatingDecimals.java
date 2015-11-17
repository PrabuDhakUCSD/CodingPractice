package Misc;
import java.util.*;
import java.lang.StringBuilder;

public class FindRepeatingDecimals {
   public static String repeatDecimals(int numer, int denom) {
      StringBuilder decimalPart = new StringBuilder();
      int quotient = numer/denom;
      int remain = numer%denom;
      
      // Map of reminder to pos in the decimal segment.
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      int ind = 0;
      while (remain != 0) {
         if (!map.containsKey(remain)) {
            map.put(remain, ind);
         } else {
            decimalPart = decimalPart.insert((int) map.get(remain), (char)'(');
            break;
         }
         
         remain *= 10;
         decimalPart.append(remain/denom);
         remain = remain % denom;
         ind++;
      }
      
      if (remain != 0) {
         decimalPart.append(')');
      }
      
      return Integer.toString(quotient) + "." + decimalPart.toString();
   }
   
   public static void main(String args[]) {
      System.out.println(repeatDecimals(10,3));
      System.out.println(repeatDecimals(2,4));
      System.out.println(repeatDecimals(22,7));
      System.out.println(repeatDecimals(58,2828));
   }
}

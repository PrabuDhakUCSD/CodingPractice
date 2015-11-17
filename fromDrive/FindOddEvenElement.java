package Misc;
import java.util.*;
public class FindOddEvenElement {
   public static int oddElement(int[] ip) {
      int res = 0;
      for (int i : ip) {
         res ^= i;
      }
      
      return res;
   }
   
   public static int evenElement(int[] ip) {
      int res = 0;
      Set<Integer> uniqueElem = new HashSet<Integer>();
      for (int i : ip) {
         res ^= i;
         uniqueElem.add(i);
      }
      
      for (int i : uniqueElem) {
         res ^= i;
      }
      
      return res;
   }
   
   public static void main(String args[]) {
      int[] ip = new int[] {4,5,6,7,4,5,6,7,8,5,5,6,6,7,7,8,8};
      System.out.println(oddElement(ip));
      
      ip = new int[] {4,5,6,7,4,5,6,7,8,5,5,6,6,7,7,8,8,8};
      System.out.println(oddElement(ip));
      
      ip = new int[] {4,5,6,7,4,5,6,7,8};
      System.out.println(oddElement(ip));
      
      ip = new int[] {4,5,6,7,5,6,7,5,6,7,4};
      System.out.println(evenElement(ip));
      
      ip = new int[] {4,5,6,7,5,6,7,5,6,7,4,4,8,8};
      System.out.println(evenElement(ip));
   }
}
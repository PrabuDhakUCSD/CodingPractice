package Misc;

import java.util.*;

public class NumberToAlphaEncoding {
   public static List<String> encode(String input) {
      Map<String, List<String>> m = new HashMap<String, List<String>>();
      return helper(input, m);
   }
   
   private static List<String> helper(String input, Map<String, List<String>> m) {
      if (input.length() == 0 || input.charAt(0) == '0')
         return null;
      
      if (m.containsKey(input))
         return m.get(input);

      List<String> output = new ArrayList<String>();
      int firstCharValue = input.charAt(0) - '0';
      String prefix = getStringFromNumber(firstCharValue);
      mergeAppend(helper(input.substring(1), m), prefix, output);
      
      if (input.length() >= 2) {
         int firstTwoCharValue = Integer.parseInt(input.substring(0, 2));
         if (firstTwoCharValue <27) {
            prefix = getStringFromNumber(firstTwoCharValue);
            mergeAppend(helper(input.substring(2), m), prefix, output);
         }
      }
      
      m.put(input, output);
      return output;
   }
   
   private static String getStringFromNumber(int value) {
      return Character.toString((char)('A' + value - 1));
   }
   
   private static void mergeAppend(List<String> li, String prefix, List<String> op) {
      if (li == null) {
         op.add(prefix);
      } else {
         for(String s : li) {
            op.add(prefix + "," + s);
         }
      }
   }
   
   public static void main(String args[]) {
      List<String> op = encode("1234");
      for(String s : op) {
         System.out.println(s);
      }
   }
}
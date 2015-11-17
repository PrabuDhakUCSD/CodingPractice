package Misc;

import java.util.*;

public class IntervalHavingAllWords {
   public static void findInterval(String[] ip, Map<String, Integer> required, int reqCount, int[] out) {
      int seenCount = 0;
      int startInd = 0;
      int start = 0;
      int end = 0;
      int minLen = Integer.MAX_VALUE;
      
      for (int ind=0; ind < ip.length; ind++) {
         String curWord = ip[ind];
         if (!required.containsKey(curWord))
            continue;
         
         int newVal = required.get(curWord)-1;
         required.put(curWord, newVal);
         if (newVal >= 0)
            seenCount++;
         
         if (seenCount == reqCount) {
            while (true) {
               curWord = ip[startInd];
               if (!required.containsKey(curWord)) {
                  startInd++;
                  continue;
               }
               
               if (required.get(curWord) < 0) {
                  required.put(curWord, required.get(curWord)+1);
                  startInd++;
                  continue;
               }
               
               if (ind-startInd+1 < minLen) {
                  minLen = ind-startInd+1;
                  start = startInd;
                  end = ind;
               }
               
               break;
            }
         }
      }
      
      out[0] = start;
      out[1] = end;
      out[2] = minLen;
   }
   
   public static void main(String args[]) {
      Map<String, Integer> m = new HashMap<String, Integer>();
      m.put("the", 1);
      m.put("fox", 2);
      m.put("brown", 1);
      m.put("bush", 1);
      
      String[] ip = {"the", "foo", "bar", "brown", "fox", "bush", "fox", "baz", "foo", "bar", "the"};
      int[] out = new int[3];
      
      findInterval(ip, m, 5, out);
      
      System.out.println(String.format("(%d, %d, %d)", out[0], out[1], out[2]));
   }
}
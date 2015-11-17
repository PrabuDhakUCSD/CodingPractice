package Misc;
import java.util.*;

public class RecoverShuffledSentence {

   public static String recover(String input, Map<String, String> dic) {
      int[] dp = new int[input.length()];
      for (int end=0; end<input.length(); end++) {
         dp[end] = -1; //can't form sentence
         for (int start=end; start>=0; start--) {
            if (isValidWord(input, start, end, dic) && (start == 0 || dp[start-1] != -1)) {
               dp[end] = start;
            }
         }
      }
      
      if (dp[input.length()-1] == -1)
         return "";
      
      // StringBuilder output = new StringBuilder();
      List<String> output = new ArrayList<String>();
      int endInd = input.length()-1;
      int startInd;
      
      while(endInd >= 0) {
         startInd = dp[endInd];
         output.add(0, getDicWord(input, startInd, endInd, dic) + " ");
         endInd = startInd-1;
      }
      
      return output.toString();
   }
   
   public static boolean isValidWord(String input, int s, int e, Map<String, String> dic) {
      char[] cWord = input.substring(s, e+1).toCharArray();
      Arrays.sort(cWord);
      String word = new String(cWord);
      
      return dic.containsKey(word);
   }
   
   public static String getDicWord(String input, int s, int e, Map<String, String> dic) {
      char[] cWord = input.substring(s, e+1).toCharArray();
      Arrays.sort(cWord);
      String word = new String(cWord);
      
      return dic.get(word);
   }
   
   public static void main(String args[]) {
      Map<String, String> dic = new HashMap<String, String>();
      dic.put("fox", "fox");
      dic.put("eht", "the");
      dic.put("bhsu", "bush");
      dic.put("dejmpu", "jumped");
      dic.put("cikqu", "quick");
      dic.put("bnorw", "brown");
      dic.put("eorv", "over");
      
      System.out.println(recover("htequkcirwobnxofpmujdeoverthehsub", dic));
   }
}

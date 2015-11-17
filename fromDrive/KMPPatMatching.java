package Misc;
import java.util.*;

public class KMPPatMatching {
   public static int[] preProcess(char[] pattern) {
      int[] lprefix = new int[pattern.length];
      lprefix[0] = 0;
      int len = 0;
      
      for (int i=1; i<pattern.length;) {
         if (pattern[len] == pattern[i]) {
            len++;
            lprefix[i] = len;
            i++;
         } else if (len == 0){
            lprefix[i] = 0;
            i++;
         } else {
            len = lprefix[len-1];
         }
      }
      
      return lprefix;
   }
   
   public static List<Integer> match(char[] text, char[] pattern) {
      int[] lprefix = preProcess(pattern);
      List<Integer> matches = new ArrayList<Integer>();
      int i=0, j=0;
      
      while (i<text.length) {
         if (text[i] == pattern[j]) {
            i++;
            j++;
            
            if (j == pattern.length) {
               matches.add(i-pattern.length);
               j = lprefix[j-1];
            }
         } else if (j!=0){
            j = lprefix[j-1];
         } else {
            i++;
         }
      }
      
      return matches;
   }
   
   public static void main(String args[]) {
      String pat = "AABAACAABAA";
      System.out.println(Arrays.toString(preProcess(pat.toCharArray())));
      
      pat="ABCDE";
      System.out.println(Arrays.toString(preProcess(pat.toCharArray())));
      
      pat="AAAAA";
      System.out.println(Arrays.toString(preProcess(pat.toCharArray())));
      
      pat="AAABAAA";
      System.out.println(Arrays.toString(preProcess(pat.toCharArray())));
      
      pat="AAACAAAAAC";
      System.out.println(Arrays.toString(preProcess(pat.toCharArray())));
      
      String text = "AABAACAADAABAAABAA";
      String pattern = "AABA";
      
      System.out.println(match(text.toCharArray(), pattern.toCharArray()));
   }
}

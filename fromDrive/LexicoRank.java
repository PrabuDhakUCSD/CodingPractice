package Misc;

public class LexicoRank {
   public static int lexiRank(String input) {
      char[] ip = input.toCharArray();
      int fact = getFact(ip.length);
      int rank = 0;
      for (int i=0; i<ip.length; i++) {
         fact = fact/(ip.length - i);
         rank += getSmaller(ip, i+1, ip[i]) * fact;
      }
      
      return rank + 1;
   }
   
   private static int getFact(int n) {
      if (n == 0)
         return 1;
      
      return n*getFact(n-1);
   }
   
   private static int getSmaller(char[] ip, int si, char c) {
      int count=0;
      
      for (int i=si; i<ip.length;i++)
         count = count + ((ip[i] < c)?1:0);
      
      return count;
   }
   
   public static void main(String args[]) {
      System.out.println(lexiRank("abcd"));
      System.out.println(lexiRank("abdc"));
      System.out.println(lexiRank("acbd"));
      System.out.println(lexiRank("acdb"));
      
      System.out.println(lexiRank("dbac"));
      System.out.println(lexiRank("dbca"));
      System.out.println(lexiRank("dcab"));
      System.out.println(lexiRank("dcba"));
   }
}
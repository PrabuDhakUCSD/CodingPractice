package Misc;

public class RegexMatching {
   public static boolean isMatch(String text, String pattern) {
      if (pattern.length() == 0)
         return text.length() == 0;
      
      if (pattern.length() == 1 || pattern.charAt(1) != '*') {
         if (text.length() == 0 || pattern.charAt(0) != '.' && pattern.charAt(0) != text.charAt(0))
            return false;
         
         return isMatch(text.substring(1), pattern.substring(1));
      }
      
      int skipIndex = -1;
      
      while(skipIndex < text.length() && (skipIndex == -1 || pattern.charAt(0) == '.' || text.charAt(skipIndex) == pattern.charAt(0))) {
         if (isMatch(text.substring(skipIndex+1), pattern.substring(2)))
            return true;
         skipIndex++;
      }
      
      return false;
   }
   
   public static void main(String args[]) {
      String text = "audha";
      String pattern = "audha.*";
      System.out.println(isMatch(text, pattern));
   }
}

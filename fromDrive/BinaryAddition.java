package Misc;

public class BinaryAddition {
   public static String addBinary(String a, String b) {
      StringBuilder output = new StringBuilder();
      
      int reminder = 0;
      int x = 0;
      int y = 0;
      
      int len1 = a.length();
      int len2 = b.length();
      
      int aInd = len1-1;
      int bInd = len2-1;
      
      while (aInd >= 0 || bInd >=0) {
         x = (aInd < 0)? 0 : a.charAt(aInd) - '0';
         y = (bInd < 0)? 0 : b.charAt(bInd) - '0';
         
         char sum = '0';
         
         int index = x+y+reminder;
         
         if (index == 0) {
            sum = '0';
            reminder = 0;
         }
         
         if (index == 1) {
            sum = '1';
            reminder = 0;
         }
         
         if (index == 2) {
            sum = '0';
            reminder = 1;
         }
         
         if (index == 3) {
            sum = '1';
            reminder = 1;      
         }
         
         output.append(sum);
         
         aInd--;
         bInd--;
      }
      
      if (reminder != 0) {
         output.append('1');
      }
      
      return output.reverse().toString();
   }
   
   public static void main(String args[]) {
      System.out.println(addBinary("11111", "111"));
   }
}

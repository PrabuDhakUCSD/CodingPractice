package Misc;

public class DedupString {
   public static String dedup(String ip) {
      char[] input = ip.toCharArray();
      int lastUniqueCharPos = 0;
      
      for (int i=1; i<input.length; i++) {
         char currentChar = input[i];
         input[i] = '\0';
         
         if (!hasChar(input, lastUniqueCharPos, currentChar)) {
            lastUniqueCharPos++;
            input[lastUniqueCharPos] = currentChar;
         }
      }
      
      char[] output = new char[lastUniqueCharPos+1];
      System.arraycopy(input, 0, output, 0, lastUniqueCharPos+1);
      return new String(output);
   }
   
   private static boolean hasChar(char[] input, int end, char c) {
      for (int i=0; i<=end; i++)
         if (input[i] == c)
            return true;
      
      return false;
   }
   
   public static void main(String args[]) {
      String output = dedup("sjhfhiqweknkjxdhweluitkqpwoeurytahsjdghlzmxncbvhgytuekszjbdxbieurkawueyrshfdksdkfsjhdiueywxbixuygwekfjnxviuyrtpqiwskjhfunv");
      System.out.println("Len: " + output.length() + "\t Output: " + output);
   }
}

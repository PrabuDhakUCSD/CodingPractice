package Misc;

public class SerializeStringAray {
   public static byte[] serialize(String[] ip) {
      int numStrings = ip.length;
      int totalLength = 0;
      
      for (String s : ip) {
         totalLength += s.length();
      }
      
      byte[] output = new byte[4 /*numStrings*/ + numStrings*4 /*len of each string*/ + totalLength*2 ];
      int outIndex = 0;
      
      serializeInt(output, outIndex, numStrings );
      outIndex+=4;
      
      for (String s : ip) {
         serializeInt(output, outIndex, s.length());
         outIndex += 4;
         serializeString(output, outIndex, s);
         outIndex += s.length()*2;
      }
      
      return output;
   }
   
   public static String[] deserialize(byte[] ip) {
      int byteInd = 0;
      int numStrings = deserializeInt(ip, byteInd);
      byteInd += 4;
      
      String[] output = new String[numStrings];
      int outIndex = 0;
      
      int strLen;
      
      while(numStrings > 0) {
         strLen = deserializeInt(ip, byteInd);
         byteInd += 4;
         output[outIndex++] = deserializeString(ip, byteInd, strLen);
         byteInd += strLen*2;
         numStrings--;
      }
      
      return output;
   }
   
   private static void serializeInt(byte[] output, int outIndex, int k) {
      for (int i=0; i<4; i++) {
         output[outIndex++] = (byte) (k & 0xFF);
         k >>>= 8;
      }
   }
   
   private static int deserializeInt(byte[] byteArr, int byteInd) {
      int output = 0;
      for (int i=0; i<4; i++) {
         output = output | byteArr[byteInd++] << i*8;
      }
      
      return output;
   }

   private static void serializeString(byte[] output, int outIndex, String s) {
      for (int i=0; i<s.length(); i++) {
         serializeChar(output, outIndex, s.charAt(i));
         outIndex+=2;
      }
   }

   private static String deserializeString(byte[] byteArr, int byteInd, int strLen) {
      StringBuilder output = new StringBuilder();
      for (int i=0; i<strLen; i++) {
         output.append(deserializeChar(byteArr, byteInd));
         byteInd+=2;
      }
      
      return output.toString();
   }
   
   private static void serializeChar(byte[] output, int outIndex, char c) {
      output[outIndex++] = (byte) (c & 0xFF);
      output[outIndex] = (byte) ((c>>8) & 0xFF);
   }
   
   private static char deserializeChar(byte[] byteArr, int byteInd) {
      char c = 0;
      
      c = (char) (c | byteArr[byteInd++]);
      c = (char) (c | byteArr[byteInd] << 8);
      
      return c;
   }
   
   public static void main(String args[]) {
      String[] ip = {"The", "quick", "brown", "fox", "jumped", "over", "the", "bush"};
      byte[] onWireData = serialize(ip);
      String[] deserilizedData = deserialize(onWireData);
      
      for (String s : deserilizedData)
         System.out.println(s);
   }
}

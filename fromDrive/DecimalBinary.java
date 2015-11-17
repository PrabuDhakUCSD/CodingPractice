package Misc;


public class DecimalBinary {
   public static String decimalToBinary(double d, int limitDigits) {
      int intPart = (int) d;
      double floatPart = d - intPart;
      
      // System.out.println(intPart);
      // System.out.println(floatPart);
      
      StringBuilder out = new StringBuilder();
      StringBuilder temp = new StringBuilder();
      
      while (intPart > 0) {
         if (intPart%2 == 0) {
            temp.append('0');
         } else {
            temp.append('1');
         }
         
         intPart/=2;
      }
      
      if (floatPart > 0) {
         out.append('.');
         
         while (floatPart > 0 && limitDigits-- > 0) {
            floatPart *= 2;
            if (floatPart < 1) {
               out.append('0');
            } else {
               out.append('1');
               floatPart -= 1;
            }
         }
      }
      
      return temp.reverse().toString() + out.toString();
   }
   
   public static double binaryToDecimal(String b) {
      String[] parts = b.split("\\.");
      if (parts.length > 2)
         throw new IllegalArgumentException();
      
      double intPart = 0;
      
      String ip = new StringBuilder(parts[0]).reverse().toString();
      
      int multiplier = 1;
      for (char ch : ip.toCharArray()) {
         if (ch != '0') {
            intPart = intPart + multiplier;
         }
         
         multiplier *= 2;
      }
      
      double floatPart = 0;
      
      if (parts.length == 2) {
         double floatMultipler = 0.5;
      
         for (char ch : parts[1].toCharArray()) {
            if (ch != '0') {
               floatPart = floatPart + floatMultipler;
            }
            
            floatMultipler /= 2;
         }
      }
      
      return intPart + floatPart;
   }
   
   public static void main(String args[]) {
      System.out.println(decimalToBinary(1348.437239, 50));
      System.out.println(binaryToDecimal("10101000100.011011111110111011100101001001011000100101"));
   }
}

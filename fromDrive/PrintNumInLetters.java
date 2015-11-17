package Misc;

public class PrintNumInLetters {
   private static final String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
   private static final String[] twosFirst = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                                              "seventeen", "eighteen", "nineteen"};
   private static final String[] twosSecond = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
   private static final String[] rest = {"hundred", "thousand", "million", "billion", "trillion"};
   
   public static String numToSentence(String num) {
      
      int len = num.length();
      char c = num.charAt(0);
      switch (len) {
          case 1:
             if (c == '0')
                return "";
             return ones[c-'0'];
             
          case 2:
             if (c == '0')
                return numToSentence(num.substring(1));
             
             if (c == '1') {
                return twosFirst[num.charAt(1)-'0'];
             }
             
             return twosSecond[num.charAt(0) - '0'] + " " + numToSentence(num.substring(1)); 
             
          case 3:
             if (c == '0')
                return numToSentence(num.substring(1));
             
             return numToSentence(num.substring(0,1)) + " hundred " + numToSentence(num.substring(1));
             
          default:
             if (c == '0')
                return numToSentence(num.substring(1));
             
             int restInd = (len-1)/3;
             int segLen = (len-1)%3 + 1;
             
             return numToSentence(num.substring(0, segLen)) + " " + rest[restInd] + " " + numToSentence(num.substring(segLen));
       }
   }
   
   public static void main(String args[]) {
      System.out.println("0" + "\t:\t" + numToSentence("0"));
      System.out.println("6" + "\t:\t" + numToSentence("6"));
      System.out.println("10" + "\t:\t" + numToSentence("10"));
      System.out.println("19" + "\t:\t" + numToSentence("19"));
      System.out.println("40" + "\t:\t" + numToSentence("40"));
      System.out.println("99" + "\t:\t" + numToSentence("99"));
      System.out.println("05" + "\t:\t" + numToSentence("05"));
      
      System.out.println("146" + "\t:\t" + numToSentence("146"));
      System.out.println("305" + "\t:\t" + numToSentence("305"));
      System.out.println("400" + "\t:\t" + numToSentence("400"));
      
      System.out.println("2,345" + "\t:\t" + numToSentence("2345"));
      System.out.println("4,045" + "\t:\t" + numToSentence("4045"));
      System.out.println("6,009" + "\t:\t" + numToSentence("6009"));
      System.out.println("9,000" + "\t:\t" + numToSentence("9000"));
      System.out.println("12,345" + "\t:\t" + numToSentence("12345"));
      System.out.println("345,456" + "\t:\t" + numToSentence("345456"));
      
      System.out.println("4,323,456" + "\t:\t" + numToSentence("4323456"));
      System.out.println("67,896,319" + "\t:\t" + numToSentence("67896319"));
      System.out.println("785,385,245" + "\t:\t" + numToSentence("785385245"));
      
      System.out.println("9,456,234,674" + "\t:\t" + numToSentence("9456234674"));
      System.out.println("10,234,576,809" + "\t:\t" + numToSentence("10234576809"));
      System.out.println("999,999,999,999" + "\t:\t" + numToSentence("999999999999"));
      
      System.out.println("8,945,635,234,678" + "\t:\t" + numToSentence("8945635234678"));
   }
   
}
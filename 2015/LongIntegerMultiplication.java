/*
 * Given two integers a and b represented as strings (i.e., 564387 will be passed as a 
 * string "564387"), write code to multiply them and return the result as a string.
 */
public class LongIntegerMultiplication {

    private static String multiply(String a, String b) {
        char[] left = a.toCharArray();
        char[] right = b.toCharArray();
        
        StringBuilder out = new StringBuilder();
        int numIters = left.length + right.length-1;
        
        int rlen = right.length;
        int llen = left.length;
        
        int reminder = 0;
        
        for(int i=0; i<numIters; i++) {
            int rightStart = rlen - (i+1);
            int leftStart = llen-1;
            
            if (rightStart < 0) {
                leftStart -= (0-rightStart);
                rightStart = 0;
            }
            
            int sum = reminder;
            
            for(; leftStart >= 0 && rightStart < rlen; leftStart--, rightStart++) {
                sum += multiplyChars(left[leftStart], right[rightStart]);
            }
            
            reminder = sum/10;
            out.append(Integer.toString(sum%10));
        }
        
        String stringReminder = (reminder != 0)? Integer.toString(reminder) : "";
        return stringReminder + out.reverse().toString();
    }
    
    private static int multiplyChars(char a, char b) {
        return (a-'0') * (b-'0'); 
    }
    
    public static void main(String[] args) {
        String a = "56475663423437879797945435";
        String b = "35456575546456345435";
        
        System.out.println(multiply(a, b));
    }
}

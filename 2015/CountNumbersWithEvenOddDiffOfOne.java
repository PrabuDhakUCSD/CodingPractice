import java.util.Arrays;

/*
 * Find #of n digit numbers which have sum(evenDigits) - sum(oddDigits) = 1
 */ 
public class CountNumbersWithEvenOddDiffOfOne {

    public static int countNumbers(int n) {
        // dp[n][d] = #of n digit numbers with even odd diff of d.
        int[][] dp = new int[n][10];
        
        // For 1 digit numbers, each diff in [0...9] has exactly one number.
        Arrays.fill(dp[0], 1);
        
        for (int i=1; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(dp, n, 1);
    }
    
    private static int helper(int[][] dp, int numDigits, int diff) {
        if (diff < 0)
            return 0;
        
        assert(diff<=9);
        
        if (dp[numDigits-1][diff] == -1) {
            int count = 0;
            for (int firstDigitValue=0; firstDigitValue<=9; firstDigitValue++) {
                // Required diff = d (let's say 1)
                // Current even lead = firstDigitValue (let's say 9)
                // Required even lead l = d-firstDigitValue (1 - 9 = -8)
                // even-odd = l ==> odd-even = -l (i.e., 8)
                // next recursive call will start with odd as the first digit
                // and hence our -ve logic will just work fine.
                count += helper(dp, numDigits-1, firstDigitValue-diff);
            }
            
            dp[numDigits-1][diff] = count;
        }
        
        return dp[numDigits-1][diff];
    }
    
    public static void main(String[] args) {
        System.out.println(countNumbers(1));
        System.out.println("------------");
        System.out.println(countNumbers(2));
        System.out.println("------------");
        System.out.println(countNumbers(3));
        System.out.println("------------");
        System.out.println(countNumbers(4));
    }
}

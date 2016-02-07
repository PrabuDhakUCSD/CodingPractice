import java.util.Arrays;

public class CountNumbersWithEvenOddDiffOfOne {

    public static int countNumbers(int n) {
        int[][] dp = new int[n][10];
        
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

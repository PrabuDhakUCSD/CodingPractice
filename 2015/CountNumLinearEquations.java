import java.util.Arrays;

/*
   Given a linear equation of n variables, find number of non-negative integer solutions of it.
   It may be assumed that all coefficients in given equation are positive integers.
    
    Example:
    
    Input:  coeff[] = {1, 2}, rhs = 5
    Output: 3
    The equation "x + 2y = 5" has 3 solutions.
    (x=3,y=1), (x=1,y=2), (x=5,y=0)
    
    Input:  coeff[] = {2, 2, 3}, rhs = 4
    Output: 3
    The equation "2x + 2y + 3z = 4"  has 3 solutions.
    (x=0,y=2,z=0), (x=2,y=0,z=0), (x=1,y=1,z=0)
    
 */
public class CountNumLinearEquations {

    public static int countSolutions(int[] coeff, int rhs) {
        int len = coeff.length;
        int[] dp = new int[rhs+1];
        dp[0] = 1;
        
        for(int i=0; i<len; i++) {
            for(int rhsVal=coeff[i]; rhsVal<=rhs; rhsVal++) {
                dp[rhsVal] += dp[rhsVal-coeff[i]];
            }
        }
        
        return dp[rhs];
    }
    
    
    public static void main(String[] args) {
        
        System.out.println(countSolutions(new int[] {1,2}, 5));
        System.out.println(countSolutions(new int[] {1,2}, 15));
        System.out.println(countSolutions(new int[] {2,2,5}, 4));
    }
}


public class CoinChangeK {
    /*
     * Count number of ways to make change for 'value' using denominations given in 'denom' with exactly 'k' coins.
     * This is a refined problem of the simpler problem that asks to find number of ways without the 'k' constraint.
     *
     * dp[k][i][j] = ways to make change for value i using denom[0...j] with exactly k coins 
     * dp[k][i][0] = 0 // no coins to choose
     * dp[k][0][j] = 0 // zero value can't be obtained with 1 or more coins
     * dp[1][i][j] = 1 when denom[j] == i || dp[1][i][j-1] == 1
     * dp[k][i][j] = dp[k][i][j-1] // don't choose denom j 
     *               + ( dp[k-1][i-denom[j]][j] if denom[j] <= i) // choose denom j; #remaning coin becomes k-1
     */
    public static int countWaysKCoins(int[] denom, int value, int k)
    {
        if (value == 0)
            return 0;
        
        int numDenom = denom.length;
        
        int[][][] dp = new int[k][value+1][numDenom+1];
        
        for(int numCoins=1; numCoins<=k; numCoins++) {
            for(int val=0; val<=value; val++) {
                for (int den=0; den<=numDenom; den++) {
                    dp[numCoins-1][val][den] = 0;
                    
                    if (val != 0 && den != 0) {
                        if (numCoins == 1) {
                            if (val == denom[den-1])
                                dp[numCoins-1][val][den] = 1;
                            else
                                dp[numCoins-1][val][den] = dp[numCoins-1][val][den-1];
                        }
                        else {
                            dp[numCoins-1][val][den] = dp[numCoins-1][val][den-1];
                            
                            if(denom[den-1] <= val) {
                                dp[numCoins-1][val][den] += dp[numCoins-2][val-denom[den-1]][den];
                            }
                        }
                    }
                }
            }
        }
        
        return dp[k-1][value][numDenom];
    }
    
    public static void main(String[] args) {
        int[] denom = new int[] {1,2};
        System.out.println(countWaysKCoins(denom, 3, 1));
        System.out.println(countWaysKCoins(denom, 3, 2));
        System.out.println(countWaysKCoins(denom, 3, 3));
        System.out.println(countWaysKCoins(denom, 3, 4));
        
        System.out.println("-------------");
        
        denom = new int[] {1,2,5,10};
        
        System.out.println(countWaysKCoins(denom, 10, 1));
        System.out.println(countWaysKCoins(denom, 10, 2));
        System.out.println(countWaysKCoins(denom, 10, 3));
        System.out.println(countWaysKCoins(denom, 10, 10));
        System.out.println(countWaysKCoins(denom, 6, 2));
        System.out.println(countWaysKCoins(denom, 6, 3));
        System.out.println(countWaysKCoins(denom, 6, 6));
        
        System.out.println("-------------");
        
        denom = new int[] {2,3,4,5};
        
        System.out.println(countWaysKCoins(denom, 9, 3));
    }
}

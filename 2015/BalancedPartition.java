import java.util.*;
/*
 * Given an array of integers, partition them into two sets such that 
 * |sum(set1) - sum(set2)| is minimum.
 */
public class BalancedPartition {
    
    public static void partition(int[] input, List<Integer> set1, List<Integer> set2) {
    
        int halfSum = 0;
        
        for (int val : input) {
            halfSum += val;
        }
        
        halfSum /= 2;
        
        int[][] dp = new int[input.length][halfSum+1];
        
        dp[0][0] = 1;
        if (input[0] <= halfSum)
            dp[0][input[0]] = 2;
        
        for(int index=1; index<input.length; index++) {
            for (int sum=0; sum<= halfSum; sum++) {
                if (dp[index-1][sum] != 0) {
                    dp[index][sum] = 1;
                }
                
                if (sum-input[index] >= 0 && dp[index-1][sum-input[index]] != 0) {
                    dp[index][sum] = 2;
                }
            }
        }
        
        int desiredSum = halfSum;
        for(; desiredSum >=0 && dp[input.length-1][desiredSum] == 0; desiredSum--);
        
        int index = input.length-1;
        
        while (index >= 0) {
            if (dp[index][desiredSum] == 1) { // don't include input[index] in generating desiredSum
                set2.add(input[index]);
            } else if (dp[index][desiredSum] == 2) {
                set1.add(input[index]);
                desiredSum -= input[index];
            } else {
                // should not come here.
                assert(false);
            }
            
            index--;
        }
        
    }
    
    public static void main(String[] args) {
        List<Integer> set1 = new ArrayList<Integer>();
        List<Integer> set2 = new ArrayList<Integer>();
        partition(new int[] {19, 0, 9, 2}, set1, set2);
        
        System.out.println(set1.toString());
        
        int s = 0;
        for (int i : set1)
            s+=i;
        System.out.println(s);
        
        System.out.println(set2.toString());
        s = 0;
        for (int i : set2)
            s+=i;
        
        System.out.println(s);
    }
}
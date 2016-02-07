import java.util.Arrays;

public class MinimizeArray {
    
    public static int getMinSize(int[] input, int k) {
        int len = input.length;
        int[][] dp = new int[len][len];
        
        for(int i=0; i<len; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return getMinSizeHelper(dp, input, 0, len-1, k);
    }
    
    private static int getMinSizeHelper(int[][] dp, int[] input, int si, int ei, int k) {
        if (ei-si+1 < 3)
            return ei-si+1;
        
        if (dp[si][ei] == -1) {
            int result = 1 + getMinSizeHelper(dp, input, si+1, ei, k);
            int first = si;
            for(int second=si+1; second<=ei; second++) {
                for(int third=second+1; third<=ei; third++) {
                    if (input[second]-input[first] == k &&
                        input[third]-input[second] == k && 
                        getMinSizeHelper(dp, input, first+1, second-1, k) == 0 &&
                        getMinSizeHelper(dp, input, second+1, third-1, k) == 0) {
                        result = Math.min(result, getMinSizeHelper(dp, input, third+1, ei, k));
                    }
                }
            }
            
            dp[si][ei] = result;
        }
        
        return dp[si][ei];
    }
    
    public static void main(String[] args) {
        System.out.println(getMinSize(new int[] {2,3,4,5,6,4}, 1));
        System.out.println(getMinSize(new int[] {2,3,4,5,6,5}, 1));
        System.out.println(getMinSize(new int[] {2,3,4,5,6,5}, 2));
        System.out.println(getMinSize(new int[] {2,3,4,6,8,5}, 2));
        System.out.println(getMinSize(new int[] {2,4,4,6,8,6}, 2));
    }
}

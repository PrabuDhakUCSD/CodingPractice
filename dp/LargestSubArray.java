package dp;
import java.util.List;
import java.util.ArrayList;

public class LargestSubArray {
    public static List<Integer> findSum(int[] input) {
        if (input == null || input.length == 0)
            throw new IllegalArgumentException("Invalid input.");
        
        List<Integer> result = new ArrayList<Integer>();
        
        int start = 0, end = 0, currStart = 0, maxSum = input[0], maxSumEndingAtIndex = input[0];
        for (int i = 1; i<input.length; i++) {
            if (input[i] > input[i] + maxSumEndingAtIndex) {
                currStart = i;
                maxSumEndingAtIndex = input[i];
            } else {
                maxSumEndingAtIndex += input[i];
            }
            
            if (maxSumEndingAtIndex > maxSum) {
                maxSum = maxSumEndingAtIndex;
                start = currStart;
                end = i;
            }
        }
        
        result.add(start);
        result.add(end);
        result.add(maxSum);
        
        return result;
    }
}

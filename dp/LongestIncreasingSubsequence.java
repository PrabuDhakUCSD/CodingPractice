package dp;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static List<Integer> getLIS(int[] input) {
        int endIndLIS = 0;
        int maxLen = 1;
        int[] lenLIS = new int[input.length];
        int[] prevInd = new int[input.length];
        
        Arrays.fill(lenLIS, 1);
        Arrays.fill(prevInd, -1);
        
        for (int i=0; i<input.length; i++) {
            int currItem = input[i];
            for(int j=i-1; j>=0; j--) {
                if (input[j] > currItem)
                    continue;
                
                if (lenLIS[j]+1 > lenLIS[i]) {
                    lenLIS[i] = lenLIS[j]+1;
                    prevInd[i] = j;
                }
                
                if (lenLIS[i] > maxLen) {
                    maxLen = lenLIS[i];
                    endIndLIS = i;
                }
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        int ind = endIndLIS;
        while (ind >= 0) {
            result.add(input[ind]);
            ind = prevInd[ind];
        }

        Collections.reverse(result);
        return result;
    }
    
    public static List<Integer> getLISOptimal(int[] input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input.length == 0)
            return result;
        
        int[] lisInd = new int[input.length];
        lisInd[0] = 0;
        int[] prevElemInd = new int[input.length];
        prevElemInd[0] = -1;
        int lisArrayEndInd = 0;
        
        for(int i=1; i<input.length; i++) {
            int curElem = input[i];
            int ind = binSearch(input, lisInd, lisArrayEndInd, curElem);
            lisArrayEndInd = Math.max(lisArrayEndInd, ind);
            lisInd[ind] = i;
            prevElemInd[i] = lisInd[ind-1];
        }
        
        int ind = lisInd[lisArrayEndInd];
        while(ind >=0) {
            result.add(input[ind]);
            ind = prevElemInd[ind];
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private static int binSearch(int[] input, int[] lisInd, int endInd, int k) {
        int start = 0, end = endInd;
        while(start <= end) {
            int mid = (start+end)/2;
            int midValue = input[lisInd[mid]];
            if (k == midValue)
                return mid;
            
            if (k < midValue) {
                if (mid == 0)
                    return mid;
                
                if (k > input[lisInd[mid-1]])
                    return mid;
                
                end = mid-1;
            } else {
                if (mid == end)
                    return mid+1;
                
                start = mid+1;
            }
        }
        
        return -1;
    }
}

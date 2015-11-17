package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Kedanes {
    
    public static List<Integer> kedane2D(int[][] input) {
        int numRows = input.length;
        int numCols = input[0].length;
        
        int rowStart = 0, rowEnd = 0, colStart = 0, colEnd = 0;
        int maxSum = input[0][0];
        
        int[] blendedSum = new int[numCols];
        
        for (int rstart=0; rstart<numRows; rstart++) {
            Arrays.fill(blendedSum ,0);
            for (int rend = rstart; rend<numRows; rend++) {
                addRow(blendedSum, input[rend]);
                List<Integer> out = kedane(blendedSum);
                if (out.get(0) > maxSum) {
                    rowStart = rstart;
                    rowEnd = rend;
                    colStart = out.get(1);
                    colEnd = out.get(2);
                    maxSum = out.get(0);
                }
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(maxSum);
        result.add(rowStart);
        result.add(rowEnd);
        result.add(colStart);
        result.add(colEnd);
        
        return result;
    }
    
    public static List<Integer> kedane(int[] input) {
        int len = input.length;
        int start = 0, end = 0, maxSum = input[0];
        int curSum = input[0], curStart = 0;
        
        for (int i=1; i<len; i++) {
            if (curSum + input[i] > input[i]) {
                curSum += input[i];
            } else {
                curStart = i;
                curSum = input[i];
            }
            
            if (curSum > maxSum) {
                maxSum = curSum;
                start = curStart;
                end = i;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(maxSum);
        result.add(start);
        result.add(end);
        
        return result;
    }
    
    private static void addRow(int[] dest, int[] input) {
        for (int i=0; i<input.length; i++) 
            dest[i] += input[i];
    }
}
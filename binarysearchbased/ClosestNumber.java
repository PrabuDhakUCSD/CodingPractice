package binarysearchbased;

import sorting.HeapSort;

public class ClosestNumber {
    
    // Return element in input that is closest to k.
    public static int getClosest(int[] input, int k) {
        if (input == null || input.length == 0)
            throw new IllegalArgumentException();
        
        HeapSort.sort(input);
        
        int start=0, end=input.length-1;
        int closestValue = 0;
        int distance = Integer.MAX_VALUE;
        
        while (start <= end) {
            int mid = (start+end)/2;
            
            if (Math.abs(input[mid]-k) < distance) {
                distance = Math.abs(input[mid]-k);
                closestValue = input[mid];
            }
            
            if (k > input[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        
        return closestValue;
    }
}

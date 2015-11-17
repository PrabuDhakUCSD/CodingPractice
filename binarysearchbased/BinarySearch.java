package binarysearchbased;

import sorting.QuickSort;

public class BinarySearch {

    public static int search(int[] input, int k) {
        if (input == null)
            throw new IllegalArgumentException();
        
        if (input.length == 0)
            return -1;
        
        QuickSort.sort(input);
        
        int start = 0;
        int end = input.length - 1;
        
        while (start<=end) {
            int mid = (start+end)/2;
            int midVal = input[mid];
            
            if (midVal == k)
                return mid;
            
            if (k > midVal)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    
    public static int searchRotated(int[] input, int k) {
        if (input == null)
            throw new IllegalArgumentException();
        
        if (input.length == 0)
            return -1;
        
        int start = 0, end = input.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            int midVal = input[mid];
            if (k==midVal)
                return mid;
            
            if (midVal < input[end]) {
                // on the smaller side
                if (k < midVal || (k > midVal && k > input[end]))
                    end = mid-1;
                else
                    start = mid+1;
                
            } else {
                if (k > midVal || (k < midVal && k < input[start]))
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        
        return -1;
    }
}

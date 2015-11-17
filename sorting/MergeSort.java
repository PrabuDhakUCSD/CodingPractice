package sorting;

import java.util.Arrays;

import exceptions.SomethingWentWrongException;

public class MergeSort {
    public static void sort(int[] input) throws SomethingWentWrongException {
        if (input == null)
            throw new IllegalArgumentException("Input is null.");
        
        int[] sorted = mergeSort(input, 0, input.length - 1);
        
        if (sorted == null || input.length != sorted.length)
            throw new SomethingWentWrongException(
                    String.format("Array after sort is not of the same size as input array, input %d, sorted %d", input.length, sorted.length));
        System.arraycopy(sorted, 0, input, 0, sorted.length);
    }
    
    private static int[] mergeSort(int[] input, int start, int end) {
        if (start == end) {
            return new int[] {input[start]};
        }
        
        int mid = (start + end)/2;
        
        int[] first = mergeSort(input, start, mid);
        int[] second = mergeSort(input, mid+1, end);
        
        return mergeSorted(first, second);
    }
    
    private static int[] mergeSorted(int[] first, int[] second) {
        if (first == null || second == null)
            throw new IllegalArgumentException("One of the given sorted array is null");
        
        int len1 = first.length;
        int len2 = second.length;
        
        int[] merged = new int[len1+len2];
        
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        
        while (index1 < len1 && index2 < len2) {
            if (first[index1] < second[index2]) {
                merged[index++] = first[index1];
                index1++;
            } else {
                merged[index++] = second[index2];
                index2++;
            }
        }
        
        while (index1 < len1) {
            merged[index++] = first[index1++];
        }
        
        while (index2 < len2) {
            merged[index++] = second[index2++];
        }
        
        return merged;
    }
}

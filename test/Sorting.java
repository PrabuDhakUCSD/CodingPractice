package test;

import static org.junit.Assert.*;
import junit.framework.Assert;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.HeapSort;

import org.junit.Test;

public class Sorting {
    @Test
    public void insertionSortTest() {
        int[] expected = new int[] {1,2,3,4,5};
        int[] input = new int[] {5,4,3,2,1};
        InsertionSort.sort(input);
        assertTrue("Not same", compareArrays(input, expected));
    }
    
    @Test
    public void mergeSortTest() throws Exception {
        int[] expected = new int[] {1,2,3,4,5};
        int[] input = new int[] {5,4,3,2,1};
        MergeSort.sort(input);
        assertTrue("Not same", compareArrays(input, expected));
    }
    
    @Test
    public void quickSortTest() throws Exception {
        int[] expected = new int[] {1,2,3,4,5};
        int[] input = new int[] {5,4,3,2,1};
        QuickSort.sort(input);
        assertTrue("Not same", compareArrays(input, expected));
    }
    
    @Test
    public void heapSortTest() throws Exception {
        int[] expected = new int[] {1,2,3,4,5,6,7,8};
        int[] input = new int[] {4,5,1,2,3,8,6,7};
        HeapSort.sort(input);
        assertTrue("Not same", compareArrays(input, expected));
    }
    
    private boolean compareArrays(int[] first, int[] second) {
        if (first == null || second == null)
            return false;
        
        if (first.length != second.length)
            return false;
        
        for (int i = 0; i< first.length; i++) {
            if (first[i] != second[i])
                return false;
        }
        
        return true;
    }
}

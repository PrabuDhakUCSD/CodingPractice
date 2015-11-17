package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import binarysearchbased.BinarySearch;

import org.junit.Test;

public class BinSearchBased {

    @Test
    public void regularbinarysearchFound1() {
        int[] input = {4, 1, 6, 3, 8, 2, 9, 10};
        int toFind = 9;
        int[] inputCopy = new int[input.length];
        System.arraycopy(input, 0, inputCopy, 0, input.length);
        Arrays.sort(inputCopy);
        int expected = Arrays.binarySearch(inputCopy, toFind);
        assertEquals(expected, BinarySearch.search(input, toFind));
    }
    
    @Test
    public void regularbinarysearchFound2() {
        int[] input = {4, 1, 6, 3, 8, 2, 9, 10};
        int toFind = 6;
        int[] inputCopy = new int[input.length];
        System.arraycopy(input, 0, inputCopy, 0, input.length);
        Arrays.sort(inputCopy);
        int expected = Arrays.binarySearch(inputCopy, toFind);
        assertEquals(expected, BinarySearch.search(input, toFind));
    }
    
    @Test
    public void regularbinarysearchNotFound1() {
        int[] input = {4, 1, 6, 3, 8, 2, 9, 10};
        int toFind = 11;
        int expected = -1;
        int got = BinarySearch.search(input, toFind);
        assertEquals(expected, got);
    }
    
    @Test
    public void rotatedSearchFound1() {
        int[] input = {22, 25, 5, 7, 9, 15, 18};
        for (int i=0; i<input.length; i++) {
            assertEquals(i, BinarySearch.searchRotated(input, input[i]));
        }
    }
    
    @Test
    public void rotatedSearchFound2() {
        int[] input = {1, 2, 3, 4, 5, 6};
        for (int i=0; i<input.length; i++) {
            assertEquals(i, BinarySearch.searchRotated(input, input[i]));
        }
    }
    
    @Test
    public void rotatedSearchNotFound1() {
        int[] input = {22, 25, 5, 7, 9, 15, 18};
        for (int i=0; i<input.length; i++) {
            assertEquals(-1, BinarySearch.searchRotated(input, input[i]+1));
        }
    }
}

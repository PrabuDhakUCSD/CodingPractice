package test;

import static org.junit.Assert.*;
import java.util.*;
import util.Helper;

import org.junit.Test;
import dp.LongestIncreasingSubsequence;

public class LISTest {

    @Test
    public void test1() {
        int[] input = {15, 10, 13, 14, 19, 3, 8, 9, 50, 20, 10, 11, 17};
        List<Integer> output = LongestIncreasingSubsequence.getLIS(input);
        List<Integer> expected = Arrays.asList(3, 8, 9, 10, 11, 17);
        assertTrue(Helper.compareList(expected, output));
    }
    
    @Test
    public void test2() {
        int[] input = {20, 32, 22, 33, 31, 35, 39, 4, 9};
        List<Integer> output = LongestIncreasingSubsequence.getLIS(input);
        List<Integer> expected = Arrays.asList(20, 22, 31, 35, 39);
        assertTrue(Helper.compareList(expected, output));
    }
    
    @Test
    public void test3() {
        int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 8, 7, 15};
        List<Integer> output = LongestIncreasingSubsequence.getLIS(input);
        List<Integer> expected = Arrays.asList(0, 2, 6, 9, 13, 15);
        assertTrue(Helper.compareList(expected, output));
    }
    
    @Test
    public void test4() {
        int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 8, 7, 15};
        List<Integer> output = LongestIncreasingSubsequence.getLISOptimal(input);
        List<Integer> expected = Arrays.asList(0, 2, 6, 9, 13, 15);
        assertTrue(Helper.compareList(expected, output));
    }
    
}

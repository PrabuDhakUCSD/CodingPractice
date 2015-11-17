package test;

import static org.junit.Assert.*;

import org.junit.Test;
import arrays.SpiralPrint;
import java.util.*;
import myutils.utilfuncs;

public class SpiralPrintTest {

    @Test
    public void test1() {
        int[][] input = {
                            {1,2,3,4,5},
                            {16,17,18,19,6},
                            {15,24,25,20,7},
                            {14,23,22,21,8},
                            {13,12,11,10,9}
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
    
    @Test
    public void test2() {
        int[][] input = {
                            {1,2,3,4,5},
                            {14,15,16,17,6},
                            {13,20,19,18,7},
                            {12,11,10,9,8},
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
    
    @Test
    public void test3() {
        int[][] input = {
                            {1,2,3,4,5},
                            {12,13,14,15,6},
                            {11,10,9,8,7}
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
    
    @Test
    public void test4() {
        int[][] input = {
                            {1,2,3,4,5}
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
    
    @Test
    public void test5() {
        int[][] input = {
                            {1,2,3},
                            {12,13,4},
                            {11,14,5},
                            {10,15,6},
                            {9,8,7}
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
    
    @Test
    public void test6() {
        int[][] input = {
                            {1},
                            {2},
                            {3},
                            {4},
                            {5}
                        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        List<Integer> output = SpiralPrint.spiralIt(input);
        assertTrue(utilfuncs.compareList(expected, output));
    }
}

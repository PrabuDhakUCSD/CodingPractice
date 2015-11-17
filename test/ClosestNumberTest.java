package test;

import static org.junit.Assert.*;
import binarysearchbased.ClosestNumber;

import org.junit.Test;

public class ClosestNumberTest {

    @Test
    public void test1() {
        int[] input = {5,8,10,2,9,3,15,1,0};
        int k = 8;
        int expected = 8;
        assertEquals(expected, ClosestNumber.getClosest(input, k));
    }
    
    @Test
    public void test2() {
        int[] input = {5,8,10,2,9,3,15,1,0};
        int k = 7;
        int expected = 8;
        assertEquals(expected, ClosestNumber.getClosest(input, k));
    }

}

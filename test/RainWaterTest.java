package test;

import static org.junit.Assert.*;

import org.junit.Test;
import arrays.RainWater;
public class RainWaterTest {

    @Test
    public void test1() {
        int[] input = {70, 60, 30, 40, 75, 20, 50, 85, 30};
        int expected = 160;
        int output = RainWater.calculateAccumulatedWater(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void test2() {
        int[] input = {70, 60, 30, 40, 75, 20, 50, 85, 30};
        int expected = 160;
        int output = RainWater.calculateAccumulatedWaterNaive(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void test3() {
        int[] input = {70, 60, 30, 40, 100, 20, 50, 85, 30};
        int expected = 180;
        int output = RainWater.calculateAccumulatedWater(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void test4() {
        int[] input = {70, 60, 30, 40, 100, 20, 50, 85, 30};
        int expected = 180;
        int output = RainWater.calculateAccumulatedWaterNaive(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void test5() {
        int[] input = {100, 70, 60, 30, 80};
        int expected = 80;
        int output = RainWater.calculateAccumulatedWater(input);
        assertEquals(expected, output);
    }
    
    @Test
    public void test6() {
        int[] input = {100, 70, 60, 30, 80};
        int expected = 80;
        int output = RainWater.calculateAccumulatedWaterNaive(input);
        assertEquals(expected, output);
    }
}

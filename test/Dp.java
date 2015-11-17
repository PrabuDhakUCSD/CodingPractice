package test;

import static org.junit.Assert.*;
import org.junit.Test;
import dp.LargestSubArray;
import java.util.List;

public class Dp {

    @Test
    public void maxSubArraySum1() {
        int[] input = new int[] {10, 5, 10, -30, 5, -3, 10, -2, 10, 10, -8};
        List<Integer> result = LargestSubArray.findSum(input);
        assertEquals("Start not equal", 4, (int) result.get(0));
        assertEquals("End not equal", 9, (int) result.get(1));
        assertEquals("Max sum not equal", 30, (int)result.get(2));
    }
    
    @Test
    public void maxSubArraySum2() {
        int[] input = new int[] {-5, 10, 2, -6, 2, -10, 15, 2};
        List<Integer> result = LargestSubArray.findSum(input);
        assertEquals("Start not equal", 6, (int) result.get(0));
        assertEquals("End not equal", 6, (int) result.get(1));
        assertEquals("Max sum not equal", 15, (int)result.get(2));
    }

}

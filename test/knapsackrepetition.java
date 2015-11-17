package test;

import static org.junit.Assert.*;

import org.junit.Test;
import dp.knapsack;
import java.util.List;

public class knapsackrepetition {

    @Test
    public void test1() {
        int[] weight = {5, 4, 6, 3};
        int[] value = {10, 40, 30, 50};
        int capacity = 10;
        List<Integer> output = knapsack.withrepetition(weight, value, capacity);
        assertEquals(150, (int) output.get(0));
        assertEquals(3, (int) output.get(1));
        assertEquals(3, (int) output.get(2));
        assertEquals(3, (int) output.get(3));
    }
    
    @Test
    public void test2() {
        int[] weight = {6, 3, 4, 2};
        int[] value = {30, 14, 16, 9};
        int capacity = 10;
        List<Integer> output = knapsack.withrepetition(weight, value, capacity);
        assertEquals(48, (int) output.get(0));
        assertEquals(0, (int) output.get(1));
        assertEquals(3, (int) output.get(2));
        assertEquals(3, (int) output.get(3));
    }
    
    @Test
    public void test3() {
        int[] weight = {3, 7, 2, 1, 5};
        int[] value = {50, 70, 40, 10, 100};
        int capacity = 9;
        List<Integer> output = knapsack.withrepetition(weight, value, capacity);
        assertEquals(180, (int) output.get(0));
    }
}

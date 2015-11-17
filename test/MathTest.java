package test;

import mathops.mathlib;

public class MathTest {
    public static void main(String args[]) {
        int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                       19, 20, 21, 22, 23, 24, 25};
        
        for (int i=0; i<input.length; i++) {
            System.out.println(String.format("%d  --  %d", input[i], mathlib.sqrt(input[i])));
        }
    }
}

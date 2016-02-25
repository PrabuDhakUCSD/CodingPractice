import java.util.*;
/*
 * Calculate largest rectangular area in a histogram.
 *
 * For each index j, we need to find first index i to the left of i
 * whose height is less than j. Similarly, we need to find first index
 * k to the right of i whose height is less than j. Then i+1 to k+1 
 * is the width of the rectangle formed with height[i].
 *
 * Result will be the max (max area formed by each height[i])
 */
public class LargestRectAreaInHistogram {
    public static int getLargestArea(int[] histogram) {
        int maxArea = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int i=0;
        for(i=0; i<histogram.length;) {
            if (dq.isEmpty() || histogram[i] >= histogram[dq.getLast()])
                dq.addLast(i++);
                // Items in the stack are in ascending order.
            else {
                maxArea = Math.max(maxArea, getArea(histogram, dq, i));
            }
        }
        
        while(!dq.isEmpty()) {
            maxArea = Math.max(maxArea, getArea(histogram, dq, i));
        }
        
        return maxArea;
    }
    
    private static int getArea(int[] histogram, Deque<Integer> dq, int currentIndex) {
        // item bigger than hist[currentIndex] is removed from stack
        int height = histogram[dq.removeLast()]; 
        // currentIndex is the first smallest on the right to element we just removed
        int ri = currentIndex-1;
        // for each elem in stack, elem underneath is the first smallest on the left
        int li = dq.isEmpty()? 0 : dq.getLast()+1;
        int width = ri-li+1;
        int area = width*height;
        return area;
    }
    
    public static void main(String[] args) {
        System.out.println(getLargestArea(new int[] {6,2,5,4,5,1,6}));
        System.out.println(getLargestArea(new int[] {6,2,5,4,5,8,6}));
        System.out.println(getLargestArea(new int[] {6,2,5,4,5,8,6,8}));
    }
}

import java.util.*;

public class LargestRectAreaInHistogram {
    public static int getLargestArea(int[] histogram) {
        int maxArea = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int i=0;
        for(i=0; i<histogram.length;) {
            if (dq.isEmpty() || histogram[i] >= histogram[dq.getLast()])
                dq.addLast(i++);
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
        int height = histogram[dq.removeLast()];
        int ri = currentIndex-1;
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

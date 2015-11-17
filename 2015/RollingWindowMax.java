import java.util.*;

/*
 * Given an array of integers and a window size k, print the maximum of each rolling window
 * of size k.
 * 
 * Example:
 * input : [7, 1, 8, 4, 3, 10, 2, 13] and k=5
 * Output: 8, 10, 10, 13
 */
public class RollingWindowMax {

    public static void rollMax(int[] input, int k) {
        Deque<Integer> valueQ = new ArrayDeque<Integer>();
        Deque<Integer> indexQ = new ArrayDeque<Integer>();
        
        for (int i=0; i<input.length; i++) {
            while(!valueQ.isEmpty() && input[i] > valueQ.getLast()) {
                valueQ.removeLast();
                indexQ.removeLast();
            }
            
            valueQ.addLast(input[i]);
            indexQ.addLast(i);
            
            if ( i-indexQ.getFirst()+1 > k) { // More than K elements in the window now. Remove the first element to bring down window size.
                indexQ.removeFirst();
                valueQ.removeFirst();
            }
            
            assert(i-indexQ.getFirst() < k);
            
            if (i+1 >= k) { // We have at least k elements in the window. Once this condition is met, it should always remain true afterwards.
                
                for (int j=i-k+1; j<=i; j++) {
                    System.out.print(input[j] + ", ");
                }
                
                System.out.println("--------" + input[indexQ.getFirst()]);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 8, 4, 3, 10, 2, 13, 15, 9, 55, 32, 4, 2, 8, 1, 10, 13, 11, 12, 100, 0, 8, 5, 9, 12, 19, 20};
        rollMax(input, 5);
    }
}
import java.util.*;

/*
 * Given a stack that contains integers, sort the stack using only push and pop
 * methods. After sorting, continuously popping elements from the stack should 
 * list values in ascending order. You can use additional O(n) storage.
 */
public class SortStack {
    
    public static void sortStack(Deque<Integer> stack) {
        Deque<Integer> helperStack = new ArrayDeque<Integer>();
        
        int stackInitialSize = stack.size();
        
        while(!stack.isEmpty()) {
            
            int stackTop = stack.removeLast();
            
            while (!helperStack.isEmpty() && stackTop < helperStack.getLast()) {
                stack.addLast(helperStack.removeLast());
            }
            
            helperStack.addLast(stackTop);
        }
        
        while(!helperStack.isEmpty()) {
            stack.addLast(helperStack.removeLast());
        }
        
        assert(stack.size() == stackInitialSize);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addLast(10);
        stack.addLast(2);
        stack.addLast(12);
        stack.addLast(5);
        stack.addLast(3);
        stack.addLast(1);
        stack.addLast(13);
        stack.addLast(17);
        stack.addLast(4);
        stack.addLast(8);
        
        sortStack(stack);
        
        while(!stack.isEmpty()) {
            System.out.println(stack.removeLast());
        }
    }
}
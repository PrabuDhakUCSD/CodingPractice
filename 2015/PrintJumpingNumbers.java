import java.util.*;

public class PrintJumpingNumbers {
    private static void helper(int k, int startNumber) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.addLast(startNumber);
        
        while(!dq.isEmpty()) {
            int top = dq.removeFirst();
            
            if (top < k) {
                System.out.println(top);
                
                if (top == 0)
                    continue;
                
                int lsDigit = top%10;
                
                if (lsDigit == 0) {
                    dq.addLast((top*10) + (lsDigit+1));
                } else if(lsDigit == 9) {
                    dq.addLast((top*10) + (lsDigit-1));
                } else {
                    dq.addLast((top*10) + (lsDigit-1));
                    dq.addLast((top*10) + (lsDigit+1));
                }
            }
        }
    }
    
    public static void printJumpingNums(int k) {
        for(int start=0; start<=9 && start<=k; start++)
            helper(k, start);
    }
    public static void main(String[] args) {
        printJumpingNums(6);
        System.out.println("================");
        printJumpingNums(20);
        System.out.println("================");
        printJumpingNums(40);
    }
}
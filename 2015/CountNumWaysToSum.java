import java.util.*;

public class CountNumWaysToSum {
    
    static class Pair {
        int a;
        int b;
        
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int hashCode() {
            int result = 1;
            int prime = 31;
            
            result = prime*result + a;
            result = prime*result + b;
            
            return result;
        }
        
        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Pair))
                return false;
            
            Pair otherPair = (Pair) other;
            
            return this.a == otherPair.a && this.b == otherPair.b;
        }
    }
    
    public static int countWaysMemo(int[] input, int n) {
        int[] recursionCount = { 0 };
        Map<Pair, Integer> dp = new HashMap<Pair, Integer>();
        int result = countHelperMemo(0, input, n, dp, recursionCount);
        System.out.println("Resursion count memo: " + recursionCount[0]);
        return result;
    }
    
    private static int countHelperMemo(int startIndex, int[] input, int n,
            Map<Pair, Integer> dp, int[] recursionCount) {
        
        recursionCount[0] += 1;
        
        if (startIndex == input.length) {
            if (n == 0)
                return 1;
            return 0;
        }
        
        Pair p = new Pair(startIndex, n);
        
        if (!dp.containsKey(p)) {
            int result = countHelperMemo(startIndex+1, input, n-input[startIndex], dp, recursionCount) +
                    countHelperMemo(startIndex+1, input, n, dp, recursionCount);
        
            dp.put(p, result);
        } else {
            System.out.println(String.format("Memo hit for (%d, %d)", startIndex, n));
        }
        
        return dp.get(p);
    }
    
    public static int countWaysSimple(int[] input, int n) {
        int[] recursionCount = { 0 };
        int result = countHelper(0, input, n, recursionCount);
        System.out.println("Resursion count: " + recursionCount[0]);
        return result;
    }
    
    private static int countHelper(int startIndex, int[] input, int n,
            int[] recursionCount) {
        
        recursionCount[0] += 1;
        
        if (startIndex == input.length) {
            if (n == 0)
                return 1;
            return 0;
        }
        
        return countHelper(startIndex+1, input, n-input[startIndex], recursionCount) +
                countHelper(startIndex+1, input, n, recursionCount);
    }
    
    public static void main(String[] arg) {
        int[] input = {1, 3, 5, 8, 12, 13, 16, 19};
        System.out.println(countWaysSimple(input, 19));
        System.out.println(countWaysMemo(input, 19));
        System.out.println(countWaysSimple(input, 17));
        System.out.println(countWaysMemo(input, 17));
        
        int[] input1 = {5, 3, 8, -5};
        System.out.println(countWaysSimple(input1, 0));
        System.out.println(countWaysMemo(input1, 0));
    }
}
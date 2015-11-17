package mathops;

public class mathlib {
    public static int sqrt(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        
        if (n == 0 || n == 1)
            return 1;
        
        int start=0, end=n/2;
        while (start <= end) {
            int mid = (start+end)/2;
            int res = (int) Math.pow(mid, 2);
            if (res == n)
                return mid;
            
            if (res > n) {
                end = mid-1;
                continue;
            }
            
            if (Math.pow(mid+1, 2) > n)
                return mid;
            
            start = mid+1;
        }
        
        return -1;
    }
}

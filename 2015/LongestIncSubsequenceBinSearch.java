import java.util.*;

public class LongestIncSubsequenceBinSearch {

    public static void lis(int[] input) {
        int len = input.length;
        List<Integer> lis = new ArrayList<Integer>();
        int[] prev = new int[len];
        prev[0] = -1;
        lis.add(0);
        
        for(int i=1; i<len; i++) {
            int posInLIS = binSearch(lis, input[i], input);
            if (posInLIS == 0) {
                prev[i] = -1;
                lis.set(posInLIS, i);
            } else if (posInLIS == lis.size()) {
                prev[i] = lis.get(posInLIS-1);
                lis.add(i);
            } else {
                prev[i] = lis.get(posInLIS-1);
                lis.set(posInLIS, i);
            }
        }
        
        System.out.print("LIS Length: " + lis.size() + "\t");
        
        List<Integer> out = new LinkedList<Integer>();
        int backTrackIndex = lis.get(lis.size()-1);
        while (backTrackIndex != -1) {
            out.add(0, input[backTrackIndex]);
            backTrackIndex = prev[backTrackIndex];
        }
        
        System.out.println(out.toString());
    }
    
    private static int binSearch(List<Integer> lis, int valueToSearch, int[] input) {
        int result = lis.size();
        int start=0, end=lis.size()-1;
        int mid;
        
        while (start <= end) {
            mid = (start+end)/2;
            if (valueToSearch < input[lis.get(mid)]) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        lis(new int[]{5});
        lis(new int[]{5,6,7});
        lis(new int[]{5,4});
        lis(new int[]{5, 10, 15, 30, 13, 14});
        lis(new int[]{5, 10, 15, 30, 13, 14, 45});
        lis(new int[]{5,4});
    }
}
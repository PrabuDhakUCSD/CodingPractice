import java.util.*;

/*
 * There is a river that runs horizontally through an area. There are a set of cities
 * above and below the river. Each city above the river is matched with a city below
 * the river, and you are given this matching as a set of pairs.
 *
 * You are interested in building a set of bridges across the river to connect the
 * largest number of the matching pairs of cities, but you must do so in a way that
 * no two bridges intersect one another.
 * 
 * Follow longest increasing subsequence.
 * 
 * dp[i] = max number of connections possible when considering cities 1 to i. ith
 *         city is the last connected city.
 * dp[1] = 1
 * dp[i] = max ( dp[j] + 1 for all 1<=j<i where end[j] < end[j] ) // end[j] is the location
 *                                                                // of jth pair
 * 
 * result = max (dp[i] 1<=i<=n)
 */
public class ConnectCitiesBridges {

    static class IndexBasedComparator implements Comparator<Integer> {
        int[] valueArray;
        public IndexBasedComparator(int[] valueArray) {
            this.valueArray = valueArray;
        }
        
        @Override
        public int compare(Integer a, Integer b) {
            return valueArray[a] - valueArray[b];
        }
    }
    
    public static void constructBridges(int[] south, int[] north) {
        int len = south.length;
        Integer[] indexArray = new Integer[len];
        for(int i=0; i<len; i++)
            indexArray[i] = i;
        
        Arrays.sort(indexArray, new IndexBasedComparator(south));
        
        int[] dpMaxCount = new int[len];
        int[] dpPrevTracker = new int[len];
        
        Arrays.fill(dpPrevTracker, -1);
        
        int maxIndex = 0;
        int maxValue = 1;
        
        for(int i=0; i<len; i++) {
            dpMaxCount[i] = 1;
            
            for(int j=i-1; j>=0; j--) {
                if (north[indexArray[j]] <= north[indexArray[i]] && dpMaxCount[j]+1 >= dpMaxCount[i]) {
                    dpMaxCount[i] = dpMaxCount[j]+1;
                    dpPrevTracker[i] = j;
                }
            }
            
            if (dpMaxCount[i] > maxValue) {
                maxValue = dpMaxCount[i];
                maxIndex = i;
            }
        }
        
        System.out.println(String.format("Max count: %d, Max count pos: %d", maxValue, maxIndex));
        
        int currentPos = maxIndex;
        
        while(currentPos >= 0) {
            System.out.println(indexArray[currentPos]);
            currentPos = dpPrevTracker[currentPos];
        }
    }
    
    public static void main(String[] args) {
        constructBridges(new int[] {10, 5, 30}, new int[]{8, 32, 17});
        System.out.println();
        constructBridges(new int[] {10, 5, 15}, new int[]{13, 7, });
    }
}

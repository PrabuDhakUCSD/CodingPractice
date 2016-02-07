import java.util.*;

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

package arrays;

public class RainWater {
    public static int calculateAccumulatedWater(int[] input) {
        if (input == null || input.length < 3)
            return 0;
        
        int len = input.length;
        int totalWater = 0;
        int tempWater = 0;
        int maxWallSize = 0;
        
        // Left to right. Handles small left wall and bigger right wall.
        // For each bar, water till top of max left wall is calculated.
        // Once a bigger right wall is found, water accumulated so far 
        // can be added to total water. If no taller right wall is found,
        // then that means there is no bound on the right side and hence 
        // water can not be saved. The next for loop handles the opposite case.
        // That is, smaller right wall and bigger left wall. It moves from right
        // to left and water level till top of tallest right wall is accounted in
        // tempwater. Once a taller left wall is found, accumulated water can be
        // added to total water. If no such wall is found, then that means 
        // there is no bound on the left side and the water can not be saved.
        // Eg. 100 60 30 70 150 80 90 20 120
        // In the above eg, 100 -> 150 is handled by left to right iteration
        // and 150 -> 120 is handled by right to left iteration in reverse order.
        for (int i=0; i<len; i++) {
            if (input[i] <= maxWallSize) {
                tempWater += maxWallSize - input[i];
            } else {
                totalWater += tempWater;
                tempWater = 0;
                maxWallSize = input[i];
            }
        }
        
        tempWater = maxWallSize = 0;
        
        for (int i=len-1; i>=0; i--) {
            if (input[i] <= maxWallSize) {
                tempWater += maxWallSize - input[i];
            } else {
                totalWater += tempWater;
                tempWater = 0;
                maxWallSize = input[i];
            }
        }
        
        return totalWater;
    }
    
    public static int calculateAccumulatedWaterNaive(int[] input) {
        if (input == null || input.length < 3)
            return 0;
        
        int len = input.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        
        maxLeft[0] = 0;
        for (int i=1; i<len; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], input[i-1]);
        }
        
        maxRight[0] = 0;
        for (int i=len-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], input[i+1]);
        }
        
        int totalWater = 0;
        for (int i=0; i<len; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (input[i] < min) {
                totalWater += min-input[i];
            }
        }
        
        return totalWater;
    }
}

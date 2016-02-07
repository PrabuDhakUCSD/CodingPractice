
public class SelectKMultipleConstraint {

    public static int selectK(int[] matchboxes, int k, int f) {
        int len = matchboxes.length;
        int[][][] dp = new int[k+1][len][f];
        
        for(int i=0; i<len; i++) {
                dp[0][i][0] = 0;
            for(int j=1; j<f; j++) {
                dp[0][i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int totalSelection=1; totalSelection<=k; totalSelection++) {
            for(int boxInd=0; boxInd<len; boxInd++) {
                for(int reminder=0; reminder<f; reminder++) {
                    int currentValue = Integer.MAX_VALUE;
                    int previousLayerValue;
                    int totalBoxSum = 0;
                    if (boxInd+1 >= totalSelection) {
                        
                        if (boxInd+1 == totalSelection) {
                            for (int bi = 0; bi <= boxInd; bi++) {
                                totalBoxSum += matchboxes[bi];
                            }
                            
                            if (totalBoxSum % f == reminder) {
                                currentValue = totalBoxSum;
                            }
                        } else {
                            currentValue = dp[totalSelection][boxInd-1][reminder];
                            
                            int requiredReminder = ((reminder - (matchboxes[boxInd] % f)) + f) % f;
                            previousLayerValue = dp[totalSelection-1][boxInd-1][requiredReminder];
                            if (previousLayerValue != Integer.MAX_VALUE)
                                currentValue = Math.min(currentValue, previousLayerValue + matchboxes[boxInd]);
                        }
                    }
                    
                    dp[totalSelection][boxInd][reminder] = currentValue;
                }
            }
        }
        
        print3D(dp, len, f, k+1);
        return dp[k][len-1][0];
    }
    
    private static void print3D(int[][][] arr, int rows, int cols, int k) {
        for(int layer=0; layer<k; layer++){
            System.out.println("\n\nLayer: " + layer + "\n");
            for (int i=0; i<rows; i++) {
                for (int j=0; j<cols; j++) {
                    if (arr[layer][i][j] == Integer.MAX_VALUE)
                        System.out.print("x   ");
                    else
                        System.out.print(arr[layer][i][j] + "  ");
                }
                System.out.println();
            }
        }
        
        System.out.println("==================\n\n");
    }
    public static void main(String[] args) {
        System.out.println(selectK(new int[] {8, 7, 3, 4, 10}, 3, 3));
    }
}

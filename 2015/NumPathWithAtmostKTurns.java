
public class NumPathWithAtmostKTurns {

    public static int getPathsHelper(int rows, int cols, int k, int[][][][] dp, int ri, int ci, int dir) {
        if (ri >= rows || ci >= cols || k < 0)
            return 0;
        
        if (ri == rows-1 && ci == cols-1)
            return 1;
        
        if (dp[ri][ci][k][dir] != -1)
            return dp[ri][ci][k][dir];
        
        int result = 0;
        int oppDir = (dir == 0)? 1: 0;
        
        if (dir == 0) {
            if (ri == rows-1 && ci + 1 == cols-1) {
                result = 1;
            } else {
                result = getPathsHelper(rows, cols, k, dp, ri, ci+1, dir) +
                         getPathsHelper(rows, cols, k-1, dp, ri, ci+1, oppDir);
            }
            
        } else if (dir == 1) {
            if (ri + 1 == rows-1 && ci == cols-1) {
                result = 1;
            } else {
                result = getPathsHelper(rows, cols, k, dp, ri+1, ci, dir) +
                         getPathsHelper(rows, cols, k-1, dp, ri+1, ci, oppDir);
            }
        }
        
        dp[ri][ci][k][dir] = result;
        return result;
    }
    
    public static int getPaths(int rows, int cols, int k) {
        int[][][][] dp = new int[rows][cols][k+1][2];
        initDp(dp, rows, cols, k);
        
        return getPathsHelper(rows, cols, k, dp, 0, 0, 0) +
               getPathsHelper(rows, cols, k, dp, 0, 0, 1);
    }
    
    public static void initDp(int[][][][] dp, int rows, int cols, int k) {
        for(int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                for(int turns=0; turns<=k; turns++) {
                    for (int dir=0; dir<2; dir++) {
                        dp[r][c][turns][dir] = -1;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getPaths(4, 4, 2));
    }
}

public class PathInGridWithKCoins {

    public static int countPaths(int[][] grid, int m, int n, int k) {
        int[][][] dp = new int[k+1][m][n];
        
        for(int totalCount=0; totalCount<=k; totalCount++) {
            for(int row=m-1; row>=0; row--){
                for(int col=n-1; col>=0; col--) {
                    if (row == m-1 && col==n-1) {
                        dp[totalCount][row][col] = (grid[row][col] == totalCount)? 1 : 0;
                    } else if(grid[row][col] > totalCount) {
                        dp[totalCount][row][col] = 0;
                    } else {
                        int rightCount = (col+1 < n)? dp[totalCount-grid[row][col]][row][col+1] : 0;
                        int leftCount = (row+1 < m)? dp[totalCount - grid[row][col]][row+1][col] : 0;
                        dp[totalCount][row][col] = rightCount + leftCount;
                    }
                }
            }
        }
        
        return dp[k][0][0];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},
                        {4,5,4},
                        {3,2,0}};
        
        System.out.println(countPaths(grid, 3, 3, 10));
    }
}

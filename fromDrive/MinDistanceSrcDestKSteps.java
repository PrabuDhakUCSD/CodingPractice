package Misc;

public class MinDistanceSrcDestKSteps {
   public static int minDistance(int[][] adj, int src, int dest, int k) {
      if (k == 0) {
         if (src == dest)
            return 0;
         
         return Integer.MAX_VALUE;
      }
      
      if (k == 1) {
         return adj[src][dest];
      }
      
      int numVertices = adj.length;
      int dp[][][] = new int[k][numVertices][numVertices];
      
      for (int step=0; step < k; step++) {
         for (int row=0; row<numVertices; row++) {
            for (int col=0; col<numVertices; col++) {
               if (step == 0) {
                  dp[step][row][col] = adj[row][col];
               } else {
                  dp[step][row][col] = Integer.MAX_VALUE;
                  
                  for (int neighbor=0; neighbor<numVertices; neighbor++) {
                     if (adj[row][neighbor] == Integer.MAX_VALUE || dp[step-1][neighbor][col] == Integer.MAX_VALUE)
                        continue;
                     
                     dp[step][row][col] = Math.min(dp[step][row][col], adj[row][neighbor] + dp[step-1][neighbor][col]);
                  }
               }
            }
         }
      }
      
      return dp[k-1][src][dest];
   }
   
   public static void main(String args[]) {
      int max = Integer.MAX_VALUE;
      
      int[][] adj = { 
            { max, 10, 3, 2 },
            { max, max, 5, 7},
            { max, max, max, 16},
            { max, max, max, max}
      };
      
      System.out.println(minDistance(adj,0,3,3));
   }
}

package Misc;

public class CoinChange {
   public static int numWays(int N, int[] denoms) {
      if (N == 0)
         return 0;
      
      int[] ways = new int[N+1];
      ways[0] = 1;
      
      for (int i=1; i<=N; i++) {
         ways[i] = 0;
         for (int d : denoms) {
            if (d <= i) {
               ways[i] += ways[i-d];
            }
         }
      }
      
      return ways[N];
   }
   
   public static void main(String args[]) {
      int[] denoms = new int[] {1,2,3};
      System.out.println(numWays(4, denoms));
   }
}

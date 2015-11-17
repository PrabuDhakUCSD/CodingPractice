package Misc;

import java.util.Arrays;

public class CoinChangeV2 {
   public static int getNumWays(int[] denoms, int value) {
      int[] numWays = new int[value+1];
      Arrays.fill(numWays, 0);
      numWays[0] = 1;
      
      for(int d : denoms)
         for (int v=d; v<=value; v++)
            numWays[v] += numWays[v-d];
      
      return numWays[value];
   }
   
   public static void main(String args[]) {
      int[] denoms = {3,4,7};
      System.out.println(getNumWays(denoms, 7));
   }
}
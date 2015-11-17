package Misc;
import java.util.*;

public class PebblingCheckerboard {
   
   private static class Pair {
      int a;
      int b;
      
      public Pair(int a, int b) {
         this.a = a;
         this.b = b;
      }
      
      @Override
      public boolean equals(Object other) {
         Pair oth = (Pair) other;
         return (oth.a == this.a && oth.b == this.b);
      }
      
      @Override
      public int hashCode() {
         return 31*a + b;
      }
   }
   
   private static Set<Pair> compatPairs = new HashSet<Pair>();
   
   static {
      compatPairs.add(new Pair(0,1));
      compatPairs.add(new Pair(0,2));
      compatPairs.add(new Pair(0,3));
      compatPairs.add(new Pair(0,4));
      compatPairs.add(new Pair(0,5));
      compatPairs.add(new Pair(0,6));
      compatPairs.add(new Pair(0,7));
      
      compatPairs.add(new Pair(1,2));
      compatPairs.add(new Pair(1,3));
      compatPairs.add(new Pair(1,4));
      compatPairs.add(new Pair(1,7));
      
      compatPairs.add(new Pair(2,3));
      compatPairs.add(new Pair(2,4));
      compatPairs.add(new Pair(2,5));
      compatPairs.add(new Pair(2,6));
      
      compatPairs.add(new Pair(3,4));
      compatPairs.add(new Pair(3,6));
      compatPairs.add(new Pair(3,7));
      
      compatPairs.add(new Pair(4,5));
      
      compatPairs.add(new Pair(5,7));
   }
   
   public static boolean isCompatible(int patA, int patB) {
      if (patA > patB) {
         int temp = patA;
         patA = patB;
         patB = temp;
      }
      
      return compatPairs.contains(new Pair(patA, patB));
   }
   
   public static int getPatCost(int[][] ip, int c, int patInd) {

      switch (patInd) {
         case 0:
            return 0;
         case 1:
         case 2:
         case 3:
         case 4:
            return ip[patInd-1][c];
         case 5:
            return ip[0][c] + ip[2][c];
         case 6:
            return ip[0][c] + ip[3][c];
         case 7:
            return ip[1][c] + ip[3][c];
      }
      return 0;
   }
   
   public static void fillColumn(boolean[][] op, int c, int patInd) {
      switch (patInd) {
      case 0:
         return;
      case 1:
      case 2:
      case 3:
      case 4:
         op[patInd-1][c] = true;
         return;
         
      case 5:
         op[0][c] = op[2][c] = true;
         return;
      case 6:
         op[0][c] = op[3][c] = true;
         return;
      case 7:
         op[1][c] = op[3][c] = true;
         return;
      }
   }
   
   public static void findOptimalPlacement(int[][] ip) {
      int cols = ip[0].length;
      
      int[] cost = new int[cols];
      boolean[] compatWithPrev = new boolean[cols];
      int[] patChosen = new int[cols];
      
      compatWithPrev[0] = true;
      cost[0] = Integer.MIN_VALUE;
      
      for (int patInd=0; patInd<=7; patInd++) {
         int patCost = getPatCost(ip, 0, patInd);
         if (patCost > cost[0]) {
            cost[0] = patCost;
            patChosen[0] = patInd;
         }
      }
      
      for (int col=1; col<cols; col++) {
         patChosen[col] = 0; // no pebble in the column.
         compatWithPrev[col] = true; // no pebble pat is compatible with all other patterns.
         cost[col] = cost[col-1];
         
         for (int patInd=1; patInd<=7; patInd++) {
            int patCost = getPatCost(ip, col, patInd);
            boolean comp = false;
            
            if (isCompatible(patChosen[col-1], patInd)) {
               patCost += cost[col-1];
               comp = true;
            } else {
               patCost += (col > 1)? cost[col-2] : 0;
            }
            
            if (patCost > cost[col] ) {
               cost[col] = patCost;
               patChosen[col] = patInd;
               compatWithPrev[col] = comp;
            }
         }
      }
      
      System.out.println("Max cost: " + cost[cols-1]);
      
      boolean[][] output = new boolean[4][cols];
      
      int currentCol = cols-1;
      
      while(currentCol >= 0) {
         fillColumn(output, currentCol, patChosen[currentCol]);
         
         if (compatWithPrev[currentCol]) {
            currentCol -=1;
         } else {
            currentCol -=2;
         }
      }
      
      for (int i=0; i<4; i++) {
         for (int j=0; j<cols; j++) {
            System.out.print(output[i][j] + "\t");
         }
         
         System.out.println();
      }
      
   }
   
   public static void main(String arg[]) {
      int[][] grid = new int[][] {
               {3,100},
               {2,5},
               {7,200},
               {5,8}
            };
      
      findOptimalPlacement(grid);
   }
}
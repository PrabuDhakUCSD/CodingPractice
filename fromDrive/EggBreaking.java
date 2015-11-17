package Misc;
import java.util.*;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggBreaking {

   private static class Pair {
      
      public Pair(boolean breaks, int floorId, int att) {
         this.breaks = breaks;
         this.floorId = floorId;
         this.maxAttempts = att;
      }
      
      boolean breaks;
      int floorId; // Floor id from which the trial is conducted. Result of the trial is recorded in 'boolen breaks'.
                   // For floor 'f', we will try all the floors from 1 to 'f' and pick the floor that minimizes attempts.
      int maxAttempts;
   }
   
   public static List<Integer> findTestingFloors(int numFloors, int numEggs) {
      List<Integer> output = new ArrayList<Integer>();
      
      if (numFloors == 0)
         return output;

      Pair[][] dp = new Pair[numFloors+1][numEggs];
      
      for (int egg=0; egg<numEggs; egg++) {
         dp[0][egg] = new Pair(false, 0, 0); // When there are no floors, we need only zero attempts.
      }
      
      /*
       * When there is one egg, we need 'f' attempts for 'f' floors.
       * And, we need trails from floor 1 to 'f' in the worst case. This
       * is achieved by having floor id as 1 and breaks = false.
       * In the recursive formulation, floorid simply means the relative floor id
       * w.r.t to the numfloors being tested in current recursion and not the 
       * absolute floorid w.r.t the total floors given in the input.
       */
      for (int floor=1; floor<numFloors+1; floor++) {
         dp[floor][0] = new Pair(false, 1, floor); 
      }
      
      for (int floor=1; floor<numFloors+1; floor++) {
         for (int egg=1; egg<numEggs; egg++) {
            
            int minAttempts = Integer.MAX_VALUE;
            int floorId = -1;
            boolean breaks = false;
            
            for (int f=1; f<=floor; f++) {
               int ifBreaks = dp[f-1][egg-1].maxAttempts;
               int ifNBreaks = dp[floor-f][egg].maxAttempts;
               
               if ((1+Math.max(ifBreaks, ifNBreaks)) < minAttempts) {
                  minAttempts = 1 + Math.max(ifBreaks, ifNBreaks);
                  floorId = f;
                  breaks = ifBreaks > ifNBreaks;
               }
            }
            
            dp[floor][egg] = new Pair(breaks, floorId, minAttempts);
         }
      }
      
      
      int f=numFloors, egg=numEggs-1;
      Pair p;
      
      int prevFloor = 0;
      
      while(f > 0) {
         p = dp[f][egg];
         output.add(p.floorId);
         System.out.print(prevFloor + p.floorId + ", ");
         if (p.breaks) {
            f = p.floorId-1;
            egg -= 1;
         } else {
            f = f - p.floorId;
            prevFloor += p.floorId;
         }
      }
      
      System.out.println("\n\nNum attempts: " + dp[numFloors][numEggs-1].maxAttempts);
      return output;
   }
   
   public static void main(String[] args) {
      List<Integer> output = findTestingFloors(100, 2);
      // System.out.println(findTestingFloors(100, 2));
      
      int prev=0;
      for (int i : output) {
         System.out.print(prev+i + ", ");
         prev += i;
      }
   }

}

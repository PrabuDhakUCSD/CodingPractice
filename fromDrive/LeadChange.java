
package Misc;
import java.util.*;

public class LeadChange {
   
   private static class Pair<E,F> {
      E item1;
      F item2; 
      
      public Pair(E item1, F item2) {
         this.item1 = item1;
         this.item2 = item2;
      }
      
      @Override
      public boolean equals(Object other) {
         if (other == null)
            return false;
         
         if (this == other)
            return true;
         
         if (!(other instanceof Pair))
            return false;
         
         Pair<?,?> p = (Pair<?,?>) other;
         
         if (this.item1 == p.item1 && this.item2 == p.item2)
            return true;
         
         return false; 
      }
      
      @Override
      public int hashCode() {
         final int prime = 31;
         int result = 1;
         
         result = result*prime + ((item1 == null)?0:item1.hashCode());
         result = result*prime + ((item2 == null)?0:item2.hashCode());
         
         return result;
      }
   }
   
   public static int leadChange(int s1, int s2, int[] points) {
      Map<Pair<Integer, Integer>, Integer> m = new HashMap<Pair<Integer, Integer>, Integer>();
      Map<Pair<Integer, Integer>, Pair<Integer, Integer>> bt = new HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>>();
       
      int changes = leadChangeHelper(0, 0, s1, s2, points, m ,bt);
      int ss1 = 0, ss2 = 0;
      
      while (ss1 < s1 || ss2 < s2) {
         Pair p = new Pair<Integer, Integer>(ss1, ss2);
         Pair<Integer, Integer> scores = bt.get(p);
         // System.out.println(String.format("%d,%d", scores.item1, scores.item2));
         ss1 += scores.item1;
         ss2 += scores.item2;
         
         System.out.println(String.format("%d,%d", ss1, ss2));
      }
      
      return changes;
      // return helper(0, 0, s1, s2, points, 0);
   }
   
   private static int helper(int accS1, int accS2, int s1, int s2, int[] points, int changeSoFar) {
      if (accS1 == s1 && accS2 == s2)
         return changeSoFar;
      
      int maxChange = -1;
      
      for (int i=0; i<points.length; i++) {
         int cs1 = points[i];
         for (int j=0; j<points.length; j++) {
            int cs2 = points[j];
            
            // Invalid current score.
            if ((cs1 == 0 && cs2 == 0) || accS1 + cs1 > s1 || accS2 + cs2 > s2)
               continue;
            
            int leadChange;
            
            int newAccS1 = accS1 + cs1;
            int newAccS2 = accS2 + cs2;
            
            if (cs1 == cs2) {
               leadChange = 0;
            } else if(accS1 == accS2 || (accS1 > accS2 && newAccS1 < newAccS2) || (accS2 > accS1 && newAccS1 > newAccS2)) {
                  leadChange = 1;
            } else {
               leadChange = 0;
            }
            
            int c = helper(newAccS1, newAccS2, s1, s2, points, changeSoFar+leadChange);
            if (c > maxChange)
               maxChange = c;
         }
      }
      
      return maxChange;
   }

   private static int leadChangeHelper(int startScore1, int startScore2, int finalScore1, int finalScore2,
         int[] points, Map<Pair<Integer, Integer>, Integer> m,
         Map<Pair<Integer, Integer>, Pair<Integer, Integer>> bt) 
   {
      if (startScore1 == finalScore1 && startScore2 == finalScore2)
         return 0;
      
      if (startScore1 > finalScore1 || startScore2 > finalScore2) {
         // Invalid state to be in. Return -1 to indicate this.
         return -1;
      }
      
      Pair<Integer, Integer> p = new Pair<Integer, Integer>(startScore1, startScore2);
      
      if (m.containsKey(p)) {      
         System.out.println(String.format("Got from cache for start state (%d, %d)", startScore1, startScore2));
         return m.get(p);
      }
      
      
      int maxChangeFromStartScoreToGoalScore = -1;
      
      int currS1, currS2;
      for (int i=0; i<points.length; i++) {
         currS1 = points[i];         
         for (int j=0; j<points.length; j++) {
            currS2 = points[j];
            
            if (currS1 == 0 && currS2 == 0)
               continue;
            
            int changeIntroduced = 0;
            
            if (currS1 == currS2)
               changeIntroduced = 0;
            else if (startScore1 == startScore2 || 
                  (startScore1 < startScore2 && startScore1 + currS1 > startScore2 + currS2) ||
                  (startScore2 < startScore1 && startScore2 + currS2 > startScore1 + currS1)) {
               changeIntroduced = 1;
            }
            
            int c = leadChangeHelper(startScore1+currS1, startScore2+currS2, finalScore1, finalScore2, points, m, bt);
            if (c == -1)
               continue;
            
            if (c + changeIntroduced > maxChangeFromStartScoreToGoalScore) {
               maxChangeFromStartScoreToGoalScore = c+ changeIntroduced;
               Pair key = new Pair<Integer, Integer>(startScore1, startScore2);
               Pair pointsScored = new Pair<Integer, Integer>(currS1, currS2);
               bt.put(key, pointsScored);
            }
         }
      }
      
      System.out.println(String.format("Added start state to cache (%d, %d -- %d)", startScore1, startScore2, maxChangeFromStartScoreToGoalScore));
      m.put(new Pair<Integer, Integer>(startScore1, startScore2), maxChangeFromStartScoreToGoalScore);
      return maxChangeFromStartScoreToGoalScore;
   }
   
   static class Score {
      int s1;
      int s2;
      
      public Score(int s1, int s2) {
         this.s1 = s1;
         this.s2 = s2;
      }
   }
   
   public static int leadChangeDP(int s1, int s2, int[] points) {
      int[][] dp = new int[s1+1][s2+1];
      Score[][] dpScore = new Score[s1+1][s2+1];
      
      for (int ts1=0; ts1<=s1; ts1++) {
         for (int ts2=0; ts2<=s2; ts2++) {
            if ( ts1 == 0 && ts2 == 0) {
               dp[ts1][ts2] = 0;
               dpScore[ts1][ts2] = new Score(0, 0);
               continue;
            }
            
            dp[ts1][ts2] = -1; // mark this state as impossible to reach;
            
            for (int t1i=0; t1i<points.length; t1i++) {
               for (int t2i=0; t2i<points.length; t2i++) {
                  int cs1 = points[t1i];
                  int cs2 = points[t2i];
                  
                  if (isValidScore(ts1, ts2, cs1, cs2, dp)) {
                     int changes = dp[ts1-cs1][ts2-cs2];
                     
                     if (leadChanges(ts1-cs1, ts2-cs2, ts1, ts2))
                        changes += 1;
                     
                     if (changes > dp[ts1][ts2]) {
                        dp[ts1][ts2] = changes;
                        dpScore[ts1][ts2] = new Score(cs1, cs2);
                     }
                  }
               }
            }
         }
      }
      
      int ts1=s1, ts2=s2;
      List<Score> games = new ArrayList<Score>();
      
      while(true) {
         games.add(0, new Score(ts1, ts2));
         
         if (ts1 == 0 && ts2 == 0)
            break;
         
         Score s = dpScore[ts1][ts2];
         ts1 -= s.s1;
         ts2 -= s.s2;
      }
      
      for(Score s : games) {
         System.out.println(s.s1 + "," + s.s2);
      }
      
      return dp[s1][s2];
   }
   
   private static boolean isValidScore(int ts1, int ts2, int cs1, int cs2, int[][] dp) {
      if ((cs1 == 0 && cs2 == 0) || ts1-cs1 < 0 || ts2-cs2 < 0 || dp[ts1-cs1][ts2-cs2] == -1)
         return false;
      
      return true;
   }
   
   private static boolean leadChanges(int pts1, int pts2, int ts1, int ts2) {
      if ((pts1 > pts2 && ts2 >= ts1) || (pts2 > pts1 && ts1 >= ts2) || (pts1 == pts2 && ts1 != ts2))
         return true;
   
      return false;
   }
   
   public static void main(String args[]) {
      int[] points = new int[] {0,2,3};
      int c = leadChangeDP(10, 6, points);
      System.out.println(c);
   }
}

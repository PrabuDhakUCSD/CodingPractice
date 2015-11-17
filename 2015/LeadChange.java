import java.util.*;

public class LeadChange {
    
    static class Pair
    {
        int a;
        int b;
        
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Pair))
                return false;
            
            Pair otherPair = (Pair) other;
            
            return otherPair.a == this.a && otherPair.b == this.b;
        }
        
        @Override
        public int hashCode() {
            int hash = 7*31 + a;
            hash = hash*31 + b;
            
            return hash;
        }
    }

    public static int countLeadChange(int[] points, int scoreA, int scoreB)
    {
        Map<Pair, Integer> dp = new HashMap<Pair, Integer>();
        return leadChangeHelper(points, 0, 0, scoreA, scoreB, dp);
    }
    
    private static int leadChangeHelper(int[] points, int startA, int startB, int finalA, int finalB, Map<Pair, Integer> dp) {
        assert (startA <= finalA && startB <= finalB);
        
        Pair p = new Pair(startA, startB);
        
        if (dp.containsKey(p))
            return dp.get(p);
        
        int maxChange = 0;
        
        int scoreLen = points.length;
        
        for (int i=0; i<scoreLen; i++) {
            for (int j=0; j<scoreLen; j++) {
                if (isValidScore(points[i], points[j], startA, startB, finalA, finalB)) {
                    int restChange = leadChangeHelper(points, startA + points[i], startB + points[j], finalA, finalB, dp);
                    if (isLeadChange(startA, startB, startA + points[i], startB + points[j]))
                        restChange++;
                    
                    maxChange = (restChange > maxChange)? restChange : maxChange;
                }
            }
        }
        
        dp.put(p,  maxChange);
        
        return maxChange;
    }
    
    private static boolean isLeadChange(int startA, int startB, int newA, int newB) {
        if ( (startA == startB && newA != newB) || ( startA > startB && newA < newB) || ( startB > startA && newB < newA) )
            return true;
        
        return false;
    }
    
    private static boolean isValidScore(int scoreA, int scoreB, int startA, int startB, int finalA, int finalB) {
        if ((scoreA == 0 && scoreB == 0) || startA + scoreA > finalA || startB + scoreB > finalB)
            return false;
            
       return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

import java.util.*;
import java.util.regex.*;

public class SmallestWindowContainingSubstrings {

    public static void getSmallestWindow(String text, String p1, String p2, String p3) {
        Set<Integer> ind_p1 = getAllOccurences(text, p1);
        Set<Integer> ind_p2 = getAllOccurences(text, p2);
        Set<Integer> ind_p3 = getAllOccurences(text, p3);
        
        int[] currentOccurence = new int[] {-1, -1, -1};
        int start = -1, end = -1, windowSize = Integer.MAX_VALUE;
        int[] startEnd = new int[2];
        
        for(int i=0; i<text.length(); i++) {
            if (ind_p1.contains(i))
                currentOccurence[0] = i;
            if (ind_p2.contains(i))
                currentOccurence[1] = i;
            if (ind_p3.contains(i))
                currentOccurence[2] = i;
            
            if (currentOccurence[0] >=0 && currentOccurence[1] >= 0 && currentOccurence[2] >= 0) {
                calculateWindowStartEnd(currentOccurence, startEnd, p1, p2, p3);
                
                if (startEnd[1]-startEnd[0]+1 < windowSize) {
                    windowSize = startEnd[1]-startEnd[0]+1;
                    start = startEnd[0];
                    end = startEnd[1];
                }
                clearEarliestStartWordOccurence(currentOccurence);
            }
        }
        
        if (start != -1) {
            System.out.println(String.format("Smallest window: (%d - %d); Size: %d", start, end, windowSize));
        }
        else {
            System.out.println("No valid window found.");
        }
    }
    
    private static void calculateWindowStartEnd(int[] currentOccurence, int[] startEnd, String p1, String p2, String p3) {
        startEnd[0] = getMinMax(currentOccurence[0], currentOccurence[1], currentOccurence[2], true);
        startEnd[1] = getMinMax(currentOccurence[0] + p1.length() - 1, currentOccurence[1] + p2.length() -1,
                currentOccurence[2] + p3.length() - 1, false);
    }
    
    private static int getMinMax(int a, int b, int c, boolean isMin) {
        if (isMin)
            return Math.min(Math.min(a, b), c);
        return Math.max(Math.max(a, b), c);
    }
    
    private static void clearEarliestStartWordOccurence(int[] currentOccurence) {
        int earliestStart = getMinMax(currentOccurence[0], currentOccurence[1], currentOccurence[2], true);
        if (currentOccurence[0] == earliestStart) 
            currentOccurence[0] = -1;
        if (currentOccurence[1] == earliestStart) 
            currentOccurence[1] = -1;
        if (currentOccurence[2] == earliestStart) 
            currentOccurence[2] = -1;
    }
    
    private static Set<Integer> getAllOccurences(String text, String p1) {
        Pattern p = Pattern.compile(p1);
        Matcher matcher = p.matcher(text);
        
        Set<Integer> indices = new HashSet<Integer>();
        while(matcher.find()) {
            indices.add(matcher.start());
        }
        
        return indices;
    }
    
    public static void main(String[] args) {
        getSmallestWindow("foobarapplebarblahbazkiwikiwiblahgrapefooapplebarkiwigrapeapple", "kiwi", "grape", "apple");
    }
}

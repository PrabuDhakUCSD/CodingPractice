import java.util.*;

public class SmallestWindow {

    public static int[] getSmallestWindow(String[] input, Map<String, Integer> dic)
    {
        int bestStart = 0, bestEnd = 0, shortestLen = Integer.MAX_VALUE;
        int reqEntries = dic.size();
        int seenEntries = 0;
        
        int currentStart = 0;
        int currentEnd = -1;
        
        while(currentEnd < input.length)
        {
            if (seenEntries != reqEntries)
            {
                // Consume input words using currentEnd pointer. This one fills up seenEntries.
                if (++currentEnd < input.length)
                {
                    String currentWord = input[currentEnd];
                    if (dic.containsKey(currentWord))
                    {                
                        int newFreq = dic.get(currentWord)-1;
                        dic.put(currentWord, newFreq);
                    
                        if (newFreq == 0)
                            seenEntries++;
                    }
                }
                else
                {
                    // No more words to consume.
                    break;
                }
            }
            else
            {
                if (currentEnd - currentStart + 1 < shortestLen)
                {
                    bestStart = currentStart;
                    bestEnd = currentEnd;
                    shortestLen = currentEnd - currentStart + 1;
                }
                
                String currentStartWord = input[currentStart];
                if (dic.containsKey(currentStartWord))
                {
                    // This one drains seenEntries.
                    int newFreq = dic.get(currentStartWord) + 1;
                    dic.put(currentStartWord, newFreq);
                    
                    if (newFreq == 1)
                    {
                        seenEntries--;
                    }
                }
                
                currentStart++;
            }
        }
        
        return new int[] {bestStart, bestEnd, shortestLen};
    }
    
    public static void main(String[] args) {
        String[] input = new String[] {"foo", "bar", "a", "b", "baz", "foo", "bar"};
        Map<String, Integer> map = new HashMap<String, Integer>(){{ put("a", 1);
                                                                    put("b", 1);
                                                                    put("bar", 1);}};
                                                                    
        int[] smallestInterval = getSmallestWindow(input, map);
        if (smallestInterval[2] == Integer.MAX_VALUE)
            System.out.println("Input string does not have all the given words.");
        else
            System.out.println(String.format("%d to %d", smallestInterval[0], smallestInterval[1]));
    }
}
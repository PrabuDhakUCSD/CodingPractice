package strings;

public class KMP {
    public static int isSubString(String input, String pat) {
        if (input == null || pat == null)
            throw new IllegalArgumentException();
        
        if (input.length() < pat.length())
            return -1;
        
        char[] inputC = input.toCharArray();
        char[] patC = pat.toCharArray();
        int[] sufMatchedPrefixLength = new int[patC.length];
        int prevMatchLen = 0;
        
        // For every char in pattern, calculate the longest prefix that 
        // is also a suffix. 
        for (int i=1; i<patC.length; i++) {
            // prevMatchLen is the suff_len of prev character.
            // Iterate until a match is found || no match can be found
            while (prevMatchLen > 0 && patC[prevMatchLen] != patC[i])
                prevMatchLen = sufMatchedPrefixLength[prevMatchLen-1];
            
            if (patC[prevMatchLen] == patC[i])
                prevMatchLen += 1;
            
            sufMatchedPrefixLength[i] = prevMatchLen;
        }
        
        int numMatched = 0;
        for (int i=0; i<inputC.length; i++) {
            // find index of pattern to match with input index i.
            while (numMatched > 0 && patC[numMatched] != inputC[i])
                numMatched = sufMatchedPrefixLength[numMatched-1];
            
            if (patC[numMatched] == inputC[i])
                numMatched++;
            
            if (numMatched == patC.length)
                return i-patC.length + 1;
            
        }
        
        return -1;
    }
}

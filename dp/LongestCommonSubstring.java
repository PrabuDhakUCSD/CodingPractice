package dp;

public class LongestCommonSubstring {
    public static String LCSS(String first, String second) {
        int numRows = first.length();
        int numCols = second.length();
        
        if (numRows == 0 || numCols == 0)
            return "";
        
        char[] fi = first.toCharArray();
        char[] se = second.toCharArray();
        
        int maxLen = 0;
        int endInd = 0;
        
        int[][] lenLCS = new int[numRows][numCols];
        
        for (int col=0; col<numCols; col++) {
            lenLCS[0][col] = (fi[0] == se[col])? 1:0;
            
            if (lenLCS[0][col] > maxLen) {
                maxLen = lenLCS[0][col];
                endInd = 0;
            }
        }
        
        for (int row=0; row<numRows; row++) {
            lenLCS[row][0] = (fi[row] == se[0])? 1:0;
            
            if (lenLCS[row][0] > maxLen) {
                maxLen = lenLCS[row][0];
                endInd = row;
            }
        }
        
        for(int row=1; row<numRows; row++) {
            for (int col=1; col<numCols; col++) {
                lenLCS[row][col] = (fi[row] == se[col])? lenLCS[row-1][col-1]+1 : 0;
                if (lenLCS[row][col] > maxLen) {
                    maxLen = lenLCS[row][col];
                    endInd = row;
                }
            }
        }
        
        int start = endInd - (maxLen - 1);
        String longestCommonSubstring = first.substring(start, endInd+1);
        return longestCommonSubstring;
    }
}

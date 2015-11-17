package dp;

public class LongestCommonSubSequence {
    public static String lcs(String first, String second) {
        int nr = first.length();
        int nc = second.length();
        
        char[] fi = first.toCharArray();
        char[] se = second.toCharArray();
        
        if (nr == 0 || nc == 0)
            return "";
        
        int[][] dir = new int[nr][nc];
        int[][] lenLCS = new int[nr][nc];
        
        for(int c=0; c<nc; c++) {
            dir[0][c] = 2;
            if (fi[0] == se[c]) {
                lenLCS[0][c] = 1;
                dir[0][c] = 1;
            }
        }
        
        for(int r=0; r<nr; r++) {
            dir[r][0] = 2;
            if (fi[r] == se[0]) {
                lenLCS[r][0] = 1;
                dir[r][0] = 1;
            }
        }
        
        for(int r=1; r<nr; r++) {
            for (int c=1; c<nc; c++) {
                lenLCS[r][c] = 0;
                dir[r][c] = 2;
                
                if (fi[r] == se[c]) {
                    lenLCS[r][c] = lenLCS[r-1][c-1] + 1;
                    dir[r][c] = 1;
                }
                
                if (lenLCS[r-1][c] > lenLCS[r][c]) {
                    lenLCS[r][c] = lenLCS[r-1][c];
                    dir[r][c] = 0;
                }
                
                if (lenLCS[r][c-1] > lenLCS[r][c]) {
                    lenLCS[r][c] = lenLCS[r][c-1];
                    dir[r][c] = 2;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        int r=nr-1;
        int c=nc-1;
        
        while (r>=0 && c>=0) {
            if (dir[r][c] == 1) {
                result.append(fi[r]);
                r--;
                c--;
            } else if (dir[r][c] == 0) {
                r--;
            } else {
                c--;
            }
        }
        
        return result.reverse().toString();
    }
}

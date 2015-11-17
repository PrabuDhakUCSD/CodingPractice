package arrays;
import java.util.*;
public class SpiralPrint {
    public static List<Integer> spiralIt(int[][] input) {
        List<Integer> output = new ArrayList<Integer>();
        
        int rs = 0, cs = 0, re = input.length-1, ce = input[0].length-1;
        
        
        // At each iteration, num rows and num cols reduces by 2.
        // Keep spiralling until there is only one row or one column,
        // in which case, just cover the row or column in a single loop.
        while (rs <= re && cs <= ce) {
            if (rs == re) {
                for (int i=cs; i<=ce; i++) {
                    output.add(input[rs][i]);
                }
            } else if (cs == ce) {
                for (int i = rs; i<=re; i++) {
                    output.add(input[i][cs]);
                }
            } else {
                for (int col=cs; col<ce; col++) {
                    output.add(input[rs][col]);
                }
                
                for (int row=rs; row<re; row++) {
                    output.add(input[row][ce]);
                }
                
                for (int col=ce; col>cs; col--) {
                    output.add(input[re][col]);
                }
                
                for (int row=re; row>rs; row--) {
                    output.add(input[row][cs]);
                }
            }
            
            rs++;
            re--;
            cs++;
            ce--;
        }
        
        return output;
    }
}

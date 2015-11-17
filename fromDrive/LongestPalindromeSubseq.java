package Misc;

public class LongestPalindromeSubseq {
   
   public static String lpsubseq(String input) {
      
      char[] ip = input.toCharArray();
      int len=ip.length;
      
      int[][] dir = new int[len][len];
      int[][] palinLen = new int[len][len];
      
      for (int row=len-1; row>=0; row--) {
         palinLen[row][row] = 1;
         
         for (int col=row+1; col<len; col++) {
            if (col == row+1 && ip[row] == ip[col]) {
               palinLen[row][col] = 2;
               dir[row][col] = 0;
            } else if (ip[row] == ip[col]) {
               palinLen[row][col] = palinLen[row+1][col-1]+2;
               dir[row][col] = 0;
            } else {
               if (palinLen[row+1][col] > palinLen[row][col-1]) {
                  palinLen[row][col] = palinLen[row+1][col];
                  dir[row][col] = 6;
               } else {
                  palinLen[row][col] = palinLen[row][col-1];
                  dir[row][col] = 9;
               }
            }
         }
      }
      
      System.out.println("Len: " + palinLen[0][len-1]);
      return constructSubSeq(ip, dir, 0, len-1);
   }
   
   public static String constructSubSeq(char[] ip, int[][] dir, int s, int e) {
      if (s > e)
         return "";
      
      if (s == e)
         return new String(new char[] {ip[s]});
      
      if (dir[s][e] == 6)
         return constructSubSeq(ip, dir, s+1, e);
      
      if (dir[s][e] == 9)
         return constructSubSeq(ip, dir, s, e-1);
      
      StringBuilder output = new StringBuilder();
      output.append(ip[s]);
      output.append(constructSubSeq(ip, dir, s+1, e-1));
      output.append(ip[s]);
      
      return output.toString();
   }

   public static void main(String[] args) {
      String input = "GEEKSFORGEEKS";
      System.out.println("Longest palin subsequence: " + lpsubseq(input));
   }
}

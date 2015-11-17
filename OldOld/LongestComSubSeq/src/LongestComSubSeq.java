import java.lang.StringBuilder;

public class LongestComSubSeq {

  public static void main(String[] args) {
    new LongestComSubSeq().Start();
  }
  
  private void Start() {
    System.out.println(LCS("XMJYAUZ","MZJAWXU"));
  }
  
  private String LCS(String A, String B) {
    int lenA = A.length();
    int lenB = B.length();
    
    int[][] dirGrid = new int[lenA+1][lenB+1];
    int[][] countGrid = new int[lenA+1][lenB+1];
      
    for (int i=0; i<(lenA+1); i++) {
      countGrid[i][0] = 0;
    }
    
    for (int i=0; i<(lenB+1); i++) {
      countGrid[0][i] = 0;
    }
    
    for (int row=1; row<lenA+1; row++) {
      int indA = row-1;
      for (int col=1; col<lenB+1; col++) {
        int indB = col-1;
        
        countGrid[row][col] = 0;
        
        if (countGrid[row-1][col] >= countGrid[row][col]) {
          countGrid[row][col] = countGrid[row-1][col];
          dirGrid[row][col] = 0;
        }
        
        if (countGrid[row][col-1] > countGrid[row][col]) {
          countGrid[row][col] = countGrid[row][col-1];
          dirGrid[row][col] = 2;
        }
        
        if (A.charAt(indA) == B.charAt(indB)) {
          if (countGrid[row-1][col-1]+1 > countGrid[row][col]) {
            countGrid[row][col] = countGrid[row-1][col-1]+1;
            dirGrid[row][col] = 1;
          }
        }
      }
    }
    
    int row=lenA;
    int col=lenB;
    
    StringBuilder commSeq = new StringBuilder();
    
    while (countGrid[row][col] > 0 ) {
      if (dirGrid[row][col] == 1) {
        commSeq.insert(0, A.charAt(row-1));
        row-=1;
        col-=1;
      }
      
      else if (dirGrid[row][col] == 2) {
        col-=1;
      }
      
      else {
        row-=1;
      }
    }
    
    return commSeq.toString();
  }
}
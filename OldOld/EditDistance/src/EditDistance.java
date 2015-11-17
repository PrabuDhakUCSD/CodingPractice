
public class EditDistance {

  public static void main(String[] args) {
    new EditDistance().Start();
  }
  
  private void Start() {
    System.out.println(ED("exponential","polynomial"));
  }
  
  private String ED(String A, String B) {
    int lenA = A.length();
    int lenB = B.length();
    
    int[][] dirGrid = new int[lenA+1][lenB+1];
    int[][] countGrid = new int[lenA+1][lenB+1];
      
    for (int i=0; i<(lenA+1); i++) {
      countGrid[i][0] = i;
      dirGrid[i][0] = 0;
    }
    
    for (int i=0; i<(lenB+1); i++) {
      countGrid[0][i] = i;
      dirGrid[0][i] = 2;
    }
    
    for (int row=1; row<lenA+1; row++) {
      int indA = row-1;
      for (int col=1; col<lenB+1; col++) {
        int indB = col-1;

        countGrid[row][col] = countGrid[row-1][col]+1;
        dirGrid[row][col] = 0;
        
        if (countGrid[row][col-1]+1 < countGrid[row][col]) {
          countGrid[row][col] = countGrid[row][col-1]+1;
          dirGrid[row][col] = 2;
        }
        
        int diff = 1;
        if (A.charAt(indA) == B.charAt(indB))
          diff = 0;
        
        if (countGrid[row-1][col-1]+diff < countGrid[row][col]) {
          countGrid[row][col] = countGrid[row-1][col-1]+diff;
          dirGrid[row][col] = 1;
        }

      }
    }
    
    System.out.println("Min cost to change: " + countGrid[lenA][lenB] + "\n\n");
    
    int row=lenA;
    int col=lenB;
    
    StringBuilder commSeq = new StringBuilder();
    
    while (row > 0 || col > 0) {
      if (dirGrid[row][col] == 1) {
        if (A.charAt(row-1) == B.charAt(col-1)) {
          commSeq.insert(0, "Keep " + A.charAt(row-1) + "; ");
        }
        else {
          commSeq.insert(0, "Change '" + A.charAt(row-1) + "' to '" + B.charAt(col-1) + "'; ");
        }
        row-=1;
        col-=1;
      }
      
      else if (dirGrid[row][col] == 2) {
        commSeq.insert(0, "Insert " + B.charAt(col-1) + "; ");
        col-=1;
      }
      
      else {
        commSeq.insert(0, "Delete " + A.charAt(row-1) + "; ");
        row-=1;
      }
    }
    
    return commSeq.toString();
  }
}
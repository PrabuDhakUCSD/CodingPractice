public class MultiDimArray {
  public static void main(String args[]) {
    MultiDimArray a = new MultiDimArray();
    a.Start();
  }
  
  public void Start() {
    
    int[] values = {30,14,16,9};  
    int capacity = 10;
    
    CompType[][] table = new CompType[capacity][values.length+1];
    
    //Init 1st column.
    for (int i=0; i<capacity; i++) {
      table[i][0] = new CompType(false, 0);
    }
    
    for (int row=0; row<capacity; row++) {
      for (int itemIndex=1; itemIndex<=values.length; itemIndex++) {
        int cap = row+1;
        int item = itemIndex-1;
        CompType withItem = new CompType(false, 0);
        
        if (values[item] == cap) {
          table[row][itemIndex] = new CompType(true, 1);
          break;
        }
        
        if (values[item] > cap && table[]) {
        }
        
      }
    }
  }
  
  private class CompType {
    private boolean isPossible;
    private int numCoins;
    
    CompType(boolean isPossible, int numCoins) {
      System.out.println("Const called.");
      this.isPossible = isPossible;
      this.numCoins = numCoins;
    }
    
    boolean GetIsPossible() {
      return isPossible;
    }
    
    void SetIsPossible(boolean value) {
      isPossible = value;
    }
    
    int GetnumCoins() {
      return numCoins;
    }
    
    void SetNumCoins(int value) {
      numCoins = value;
    }
  }
}
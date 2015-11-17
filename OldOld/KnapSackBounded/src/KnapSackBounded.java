import java.util.ArrayList;
import java.util.List;

public class KnapSackBounded {
  public static void main(String args[]) {
    //define input
    int[] weights = {2,5,7,8,10};
    int[] values = {10,13,4,5,9};
    int capacity = 20;
    KnapSackBounded ks = new KnapSackBounded();
    ks.SolveKS(weights, values, capacity);
  }
  
  private void SolveKS(int[] weights, int[] values, int capacity) {
    // Define input grid
    int numrows = capacity+1;
    int numcols = values.length + 1;
    GridValue[][] grid = new GridValue[numrows][numcols];
    
    for (int row=0; row<numrows; row++)
      grid[row][0] = new GridValue(false, 0);
    
    for (int col=0; col<numcols; col++)
      grid[0][col] = new GridValue(false, 0);
    
    for (int cap=1; cap<numrows; cap++) {
      for (int item=1; item<numcols; item++) {
        grid[cap][item] = new GridValue(false, 0);
        int itemIndex = item-1;
        int withoutValue = grid[cap][item-1].GetMaxValue();
        int withValue = 0;
        
        if (weights[itemIndex] <= cap)
          withValue = values[itemIndex] + grid[cap-weights[itemIndex]][item-1].GetMaxValue();
        
        if (withValue > withoutValue) {
          grid[cap][item].SetValue(true, withValue);
        }
        else {
          grid[cap][item].SetValue(false, withoutValue);
        }
      }
    }
    
    System.out.println("Maximum obtainable value: " + grid[capacity][values.length].GetMaxValue() + "\n");
    
    // Backtrack to identify items to include.
    List<Integer> itemsPicked = new ArrayList<Integer>();
    int cap = capacity;
    int item = values.length;
    while( cap > 0 && item > 0) {
      int itemIndex = item-1;
      if (grid[cap][item].GetIsInclude()) {
        itemsPicked.add(item);
        cap = cap-weights[itemIndex];
        item = item-1;
      }
      else {
        item = item-1;
      }
    }
    
    for (int i=itemsPicked.size()-1; i>=0; i--){
      System.out.print(itemsPicked.get(i) + ", ");
    }
  }
  
  private class GridValue {
    
    public GridValue(boolean includeitem, int maxvalue) {
      this.includeitem = includeitem;
      this.maxvalue = maxvalue;
    }
    
    public void SetValue (boolean includeitem, int maxvalue) {
      this.includeitem = includeitem;
      this.maxvalue = maxvalue;
    }
    
    public int GetMaxValue() {
      return maxvalue;
    }
    
    public boolean GetIsInclude() {
      return includeitem;
    }
    
    private boolean includeitem;
    private int maxvalue;
  }
}

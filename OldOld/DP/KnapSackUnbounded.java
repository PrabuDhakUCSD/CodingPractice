public class KnapSackUnbounded {
  public static void main (String args[]) {
    int[] values = {30,14,16,9};
    int[] weights = {6,3,4,2};
    int capacity = 10;
    
    System.out.println("Maximum attainable value: " + unboundedKnap(values, weights, capacity));
  }
  
  private static int unboundedKnap(int[] values, int[] weights, int capacity) {
    int[] dpTable = new int[capacity+1];
    
    for (int currentCap=1; currentCap<=capacity; currentCap++) {
      for (int items=0; items<values.length; items++) {
        if (weights[items] > currentCap) {
          continue;
        }
        
        if ((dpTable[currentCap-weights[items]] + values[items]) > dpTable[currentCap])
            dpTable[currentCap] = dpTable[currentCap-weights[items]] + values[items];
      }
    }
    
    return dpTable[capacity];
  }
}
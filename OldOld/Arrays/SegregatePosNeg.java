public class SegregatePosNeg {

  public static void main (String args[]) {
    int[] input = {1,2,3,-1,-2,4,-3,5,-4,-5,6,-6};
    segregate(input, input.length);
    for (int i=0; i<input.length; i++) {
      System.out.print(input[i] + " ");
    }
  }
  
  private static void segregate(int[] input, int size) {
    if (size < 2)
      return;
    
    int runningPtr = 0;
    int nextNegPos = 0;
    
    while (runningPtr < size) {
      if (input[runningPtr] >= 0) {
        runningPtr++;
        continue;
      }
      
      // Avoid unnecessary swap.
      if (runningPtr == nextNegPos) {
        runningPtr++;
        nextNegPos++;
        continue;
      }
      
      int temp = input[runningPtr];
      input[runningPtr] = input[nextNegPos];
      input[nextNegPos] = temp;
      
      runningPtr++;
      nextNegPos++;   
    }
  }
} 
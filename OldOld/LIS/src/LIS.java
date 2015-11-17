import java.util.ArrayList;

public class LIS {

  public static void main(String[] args) {
    LIS l = new LIS();
    l.start();
  }
  
  private void start() {
    int[] input = {10,7,6,9,12,11,10,7,8,15,13,12,9,10};
    ArrayList<Integer> quadratic = findLISQuad(input);
    // printarray("Result", quadratic);
    ArrayList<Integer> logrithmic = findLISLog(input);
    
    if (quadratic.size() != logrithmic.size() || !quadratic.equals(logrithmic)) {
      System.out.println("Test failed.");
      printarray("Quad", quadratic);
      printarray("Log", logrithmic);
    }
    else {
      System.out.println("Test Passed.");
      printarray("Result", quadratic);
    }
  }
  
  private ArrayList<Integer> findLISLog(int[] input) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int len = input.length;
    
    if (len == 1) {
      result.add(input[0]);
      return result;
    }
    
    int[] parent = new int[len];
    int maxSeqLen = 0;
    ArrayList<Integer> LISArr = new ArrayList<Integer>();
    LISArr.add(0);
    parent[0] = -1;
    
    for(int i=1; i<len; i++) {
      if (input[i] >= input[LISArr.get(maxSeqLen)]) {
        LISArr.add(i);
        parent[i] = LISArr.get(maxSeqLen);
        maxSeqLen += 1;
      }
      
      else {
        int index = BinSearch(LISArr, input, 0, maxSeqLen, input[i]);
        LISArr.set(index, i);
        parent[i] = -1;
        if (index != 0) {
          parent[i] = LISArr.get(index-1);
        }
      }
    }
    
    int index = LISArr.get(maxSeqLen);
    while (index != -1) {
      result.add(0, input[index]);
      index = parent[index];
    }
    
    return result;
  }
  
  private int BinSearch(ArrayList<Integer> inputIndex, int[] input, int l, int r, int N) {
    int mid = (l+r)/2;
    int midElem = input[inputIndex.get(mid)];
    
    if (N < midElem) {
      if (mid == 0)
        return mid;
      
      if (N >= input[inputIndex.get(mid-1)])
        return mid;
      
      return BinSearch(inputIndex, input, l, mid-1, N);
    }
    
    else {
      if (N < input[inputIndex.get(mid+1)])
        return mid+1;
      
      return BinSearch(inputIndex, input, mid+1, r, N);
    }
  }
  
  private ArrayList<Integer> findLISQuad(int[] input) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int len = input.length;
    
    if (len == 1) {
      result.add(input[0]);
      return result;
    }
      
    int[] lisEndingAt = new int[len];
    int[] parent = new int[len];
    int maxLisIndex = 0;
    int maxSeqLen = 1;
    
    lisEndingAt[0] = 1;
    maxLisIndex = 0;
    parent[0] = -1;
    
    for (int i=1; i<len; i++) {
      lisEndingAt[i] = 1;
      parent[i] = -1;
      
      for (int j=i-1; j>=0; j--) {
        if (input[i] >= input[j]) {
          if (lisEndingAt[j]+1 > lisEndingAt[i]) {
            lisEndingAt[i] = lisEndingAt[j] + 1;
            parent[i] = j;
          }
        }
      }
      
      if (lisEndingAt[i] > maxSeqLen) {
        maxSeqLen = lisEndingAt[i];
        maxLisIndex = i;
      }
    }
    
    int index = maxLisIndex;
    while (index != -1) {
      result.add(0, input[index]);
      index = parent[index];
    }
    
    return result;
  }
  
  private void printarray(String tag, ArrayList<Integer> arr) {
    System.out.println("\n" + tag + "\n");
    for (int i=0; i<arr.size()-1; i++) {
      System.out.print(arr.get(i) + ",");
    }
    System.out.print(arr.get(arr.size()-1));
  }

}

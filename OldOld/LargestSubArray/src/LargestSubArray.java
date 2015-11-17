public class LargestSubArray {

  public static void main(String[] args) {
    
    LargestSubArray s = new LargestSubArray();
    s.Start();
  }
  
  public void Start() {
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    TupleOfThree dp = FindLargestDP(input);
    TupleOfThree kadane = FindLargestKadane(input);
    
    if (dp.equals(kadane)) {
      System.out.println("Test passes!");
      dp.print("Pass");
    }
    
    else {
      System.out.println("Test Fails");
      dp.print("DP");
      kadane.print("Kadane");
    }
  }
  
  public TupleOfThree FindLargestDP(int[] input) {
    
    int maxSumEndsAt = 0;
    int maxSum = input[0];
    int tempSum = input[0];
    int[] count = new int[input.length];
    int[] endingAtSum = new int[input.length];
    
    count[0] = 1;
    endingAtSum[0] = input[0];
    
    for(int i=1; i<input.length; i++) {
      if (input[i] + endingAtSum[i-1] > input[i]) {
        tempSum = endingAtSum[i] = endingAtSum[i-1]+input[i];
        count[i] = count[i-1] + 1;
      }
      else {
        tempSum = endingAtSum[i] = input[i];
        count[i] = 1;
      }
      
      if (tempSum > maxSum) {
        maxSum = tempSum;
        maxSumEndsAt = i;
      }
    }
    
    TupleOfThree result = new TupleOfThree(maxSumEndsAt-(count[maxSumEndsAt]-1), maxSumEndsAt, maxSum);
    return result;
  }
  
  public TupleOfThree FindLargestKadane(int[] input) {
    int si = 0;
    int ei = 0;
    int maxSum = input[0];
    
    int tsi = 0;
    int tei = 0;
    int tempSum = input[0];
    
    for (int i=1; i<input.length; i++) {
      if (tempSum < 0) {
        tempSum = input[i];
        tsi = tei = i;
      }
      else {
        tempSum += input[i];
        tei = i;
      }
      
      if (tempSum > maxSum) {
        maxSum = tempSum;
        si = tsi;
        ei = tei;
      }
    }
    
    TupleOfThree result = new TupleOfThree(si, ei, maxSum);
    return result;
  }

  private class TupleOfThree {
    public final int startIndex;
    public final int endIndex;
    public final int largestSum;
    
    public TupleOfThree(int si, int ei, int maxsum) {
      startIndex = si;
      endIndex = ei;
      largestSum = maxsum;
    }
    
    @Override
    public boolean equals(Object obj) {
      TupleOfThree anotherObj = (TupleOfThree) obj;
      return this.startIndex == anotherObj.startIndex &&
             this.endIndex == anotherObj.endIndex &&
             this.largestSum == anotherObj.largestSum;
    }
    
    public void print(String tag) {
      System.out.println(String.format("Tag: %s | si=%d, ei=%d, maxval=%d", tag, startIndex, endIndex, largestSum));
    }
  }

}

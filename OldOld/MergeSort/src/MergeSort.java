
public class MergeSort {

  public static void main(String[] args) {
    new MergeSort().Start();
  }
  
  private void Start() {
    int[] input = new int[] {10,5,9,8,15,14};
    Sort(input);
    for (int i : input) {
      System.out.print(i + ",");
    }
  }
  
  private void Sort(int[] input) {
    if (input.length <= 1) {
      return;
    }
    
    int[] sortedInput = MergeSort(input, 0, input.length-1);
    
    for (int i=0; i<input.length; i++) {
      input[i] = sortedInput[i];
    }
  }
  
  private int[] MergeSort(int[] input, int l, int r) {
    if (l == r) 
      return new int[] {input[l]};
    
    int mid = (l+r)/2;
    int[] left = MergeSort(input, l, mid);
    int[] right = MergeSort(input, mid+1, r);
    
    return MergeSorted(left, right);
  }
  
  private int[] MergeSorted(int[] left, int[] right) {
    int ls = left.length;
    int rs = right.length;
    
    int[] output = new int[ls+rs];
    int oi = 0;
    
    int li=0, ri=0;
    for (li=0, ri=0; li < ls && ri < rs;) {
      if (left[li] <= right[ri]) {
        output[oi++] = left[li++];
      }
      else {
        output[oi++] = right[ri++];
      }
    }
    
    if (li == ls) {
      for (int j=ri; j<rs; j++) {
        output[oi++] = right[j];
      }
    }
    
    else {
      for (int j=li; j<ls; j++) {
        output[oi++] = left[j];
      }
    }
    
    return output;
  }
}


public class InsertionSort {

  public static void main(String[] args) {
    int[] input = {2,1};
    insertSort(input);
    for (int i=0; i<input.length; i++) {
      System.out.print(input[i] + ", ");
    }
  }
  
  private static void insertSort(int[] input) {
    
    if (input.length == 0)
      return;
    
    for (int i=1; i<input.length; i++) {
      int key = input[i];
      int j = i-1;
      for (; j>=0; j--) {
        if (input[j] > key) {
          input[j+1] = input[j];
        }
        else {
          break;
        }
      }
      
      input[j+1] = key;
    }
  }

}

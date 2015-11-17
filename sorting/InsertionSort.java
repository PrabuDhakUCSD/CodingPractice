package sorting;

public class InsertionSort {
    public static void sort(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("Input is null.");
        
        int len = input.length;
        for (int i=1; i<len; i++) {
            int key = input[i];
            int j = i-1;
            for (; j>=0 && input[j] > key; j--) {
                input[j+1] = input[j];
            }
            input[j+1] = key;
        }
    }
}
package sorting;

public class HeapSort {

    public static void sort(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("Invalid input");
        
        if (input.length <= 1)
            return;
        
        HeapOps.buildMaxHeap(input);
        for (int heapMaxInd = input.length - 1; heapMaxInd > 0; heapMaxInd--) {
            swapValues(input, 0, heapMaxInd);
            HeapOps.maxHeapify(input, 0, heapMaxInd);
        }
    }
    
    private static void swapValues(int[] input, int ind1, int ind2) {
        int temp = input[ind1];
        input[ind1] = input[ind2];
        input[ind2] = temp;
    }
}

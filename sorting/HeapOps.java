package sorting;

public class HeapOps {
    
    public static void buildMaxHeap(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("Invalid input.");
        
        if (input.length <=1 )
            return;
        
        int heapSize = input.length;
        int lastParent = parent(heapSize-1);
        
        for(int i=lastParent; i>=0; i--) {
            maxHeapify(input, i, heapSize);
        }
    }

    public static void maxHeapify(int[] input, int ind, int heapSize) {
        int heapMaxIndex = heapSize - 1;
        int leftInd = left(ind);
        if (leftInd > heapMaxIndex)
            return;
        
        int maxInd = (input[ind] > input[leftInd]) ? ind : leftInd;
        int rightInd = right(ind);
        if (rightInd <= heapMaxIndex && input[rightInd] > input[maxInd])
            maxInd = rightInd;

        if (ind == maxInd)
            return;
        
        swapValues(input, ind, maxInd);
        maxHeapify(input, maxInd, heapSize);
    }
    
    public static int left(int i) {
        return (i*2)+1;
    }
    
    public static int right(int i) {
        return (i*2)+2;
    }
    
    public static int parent(int i) {
        return (i+1)/2-1;
    }
    
    private static void swapValues(int[] input, int ind1, int ind2) {
        int temp = input[ind1];
        input[ind1] = input[ind2];
        input[ind2] = temp;
    }
}
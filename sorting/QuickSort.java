package sorting;

public class QuickSort {
    public static void sort(int[] input) {
        if (input == null)
            throw new IllegalArgumentException("input is null");
        
        if (input.length < 2)
            return;
        
        quickSort(input, 0, input.length-1);
    }
    
    private static void quickSort(int[] input, int start, int end) {
        if (start >= end)
            return;
        
        int pivot = quickSelect(input, start, end);
        quickSort(input, start, pivot-1);
        quickSort(input, pivot+1, end);
    }
    
    private static int quickSelect(int[] input, int start, int end) {
        int key = input[end];
        int lastSmall = start-1;
        
        for (int i = start; i<end; i++) {
            if (input[i] <= key) {
                lastSmall++;
                int temp = input[lastSmall];
                input[lastSmall] = input[i];
                input[i] = temp;
            }
        }
        
        input[end] = input[lastSmall+1];
        input[lastSmall+1] = key;
        
        return lastSmall+1;
    }
}

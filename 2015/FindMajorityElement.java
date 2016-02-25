
public class FindMajorityElement {

    /*
     * Find element that appears strictly more than n/2 times.
     */
    public static int findMajority(int[] input) {
        int majElement = 0;
        int leadCount = 0;
        // Uses tournament method.
        for(int elem : input) {
            if (leadCount == 0) {
                // This means, if there are m elements seen so far, no majority yet.
                // Any element had appeared atmost m/2 times (it's lead is offset by other m/2 elements).
                leadCount = 1;
                majElement = elem;
            } else if (elem == majElement) {
                leadCount++;
            } else {
                leadCount--;
            }
        }
        
        if (leadCount == 0)
            return -1; // no majority element
        
        int count=0;
        
        for(int elem : input){
            if (elem == majElement) {
                count++;
            }
        }
        
        // Even though lead is greater than zero, it does not mean there is a majority element.
        // So verify that the reported majority element is indeed a majority element.
        // Eg. { 3,4,5,6,7,8,9 } --> 9 is reported as majority with lead 1
        // Eg. { 3,4,5,6,7,8,9,9,9 } --> 9 is reported as majority with lead 3
        if (count >= input.length/2+1)
            return majElement;
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(findMajority(new int[] {4,1,4,6,4,4,8})); // 4
        System.out.println(findMajority(new int[] {4,1,4,6,4,4,8,9})); // No maj
        System.out.println(findMajority(new int[] {4,1,4,6,4,4})); // 4
        System.out.println(findMajority(new int[] {4,1,4,6,7})); // No maj
        System.out.println(findMajority(new int[] {4})); // 4 
    }
}

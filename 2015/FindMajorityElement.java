
public class FindMajorityElement {

    /*
     * Find element that appears strictly more than n/2 times.
     */
    public static int findMajority(int[] input) {
        int majElement = 0;
        int leadCount = 0;
        
        for(int elem : input) {
            if (leadCount == 0) {
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

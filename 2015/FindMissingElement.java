
public class FindMissingElement {

    public static int findMissing(int[] input) {
        int si = 0;
        int ei = input.length-1;
        
        while(si < ei) {
            int mi = (si+ei)/2;
            if (mi%2 == 1) { // even absolute position
                if (input[mi-1] == input[mi]) {
                    si = mi+1;
                }
                else {
                    ei = mi;
                }
            } else {
                if (input[mi] == input[mi+1]) {
                    si = mi+2;
                } else {
                    ei = mi;
                }
            }
        }
        
        assert(si == ei);
        return input[si];
    }
    
    public static void main(String[] args) {
        System.out.println(findMissing(new int[] {1,1,2,2,3,3,4}));
        System.out.println(findMissing(new int[] {1,1,2,2,3,4,4}));
        System.out.println(findMissing(new int[] {1,1,2,3,3,4,4}));
        System.out.println(findMissing(new int[] {1,2,2,3,3,4,4}));
        
        System.out.println(findMissing(new int[] {1,1,2,2,3,3,4,4,5}));
        System.out.println(findMissing(new int[] {1,1,2,2,3,3,4,5,5}));
        System.out.println(findMissing(new int[] {1,1,2,2,3,4,4,5,5}));
        System.out.println(findMissing(new int[] {1,1,2,3,3,4,4,5,5}));
        System.out.println(findMissing(new int[] {1,2,2,3,3,4,4,5,5}));
    }
}

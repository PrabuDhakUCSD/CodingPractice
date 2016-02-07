
public class CountNumBigOnRight {

    static class Pair {
        int value;
        int bigcount;
        
        public Pair(int value, int bigcount) {
            this.value = value;
            this.bigcount = bigcount;
        }
    }
    
    public static void countBig(int[] input) {
        int len = input.length;
        Pair[] ip = new Pair[len];
        
        for(int i=0; i<len; i++) {
            ip[i] = new Pair(input[i], 0);
        }
        
        Pair[] merged = mergeSort(ip, 0, len-1);
        
        for(int i=0; i<len; i++) {
            System.out.print(input[i] + " --- ");
        }
        
        System.out.println("");
        
        for(int i=0; i<len; i++) {
            System.out.print(merged[i].bigcount + " --- ");
        }

    }
    
    public static Pair[] mergeSort(Pair[] input, int si, int ei) {
        if (si == ei) {
            return new Pair[] {new Pair(input[si].value, input[si].bigcount)};
        }
        
        int mid = si + (ei-si)/2;
        
        Pair[] firstHalf = mergeSort(input, si, mid);
        Pair[] secondHalf = mergeSort(input, mid+1, ei);
        
        Pair[] merged = new Pair[ei-si+1];

        int firstind = 0, secondind = 0, flen = firstHalf.length, slen = secondHalf.length;
        for (int i=0; i<merged.length; i++) {
            if (firstind < flen && secondind < slen) {
                if (firstHalf[firstind].value < secondHalf[secondind].value) {
                    firstHalf[firstind].bigcount += slen-secondind;
                    merged[i] = firstHalf[firstind++];
                } else {
                    merged[i] = secondHalf[secondind++];
                }
                
            } else if (firstind < flen) {
                merged[i] = firstHalf[firstind++];
            } else {
                merged[i] = secondHalf[secondind++];
            }
        }
        
        return merged;
    }
    
    public static void main(String[] args) {
        countBig(new int[] {3,4,5,9,2,1,3});
    }
}

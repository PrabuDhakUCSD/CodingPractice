/*
 * Given an array of strings, find two strings S and T such that, len(S)*len(T)
 * is maximum and S and T does not have any characters in common.
 */
public class LongestTwoNoOverlap {

    public static void findLongest(String[] input) {
        int len = input.length;
        int[] bitEncoding = new int[len];
        
        for(int i=0; i<len; i++) {
            char[] ip = input[i].toCharArray();
            for (int j=0; j<ip.length; j++) {
                char c = Character.toLowerCase(ip[j]);
                bitEncoding[i] |= (1 << (c-'a'));
            }
        }
        
        int maxProd = 1;
        int firstInd = 0, secondInd = 0;
        
        for(int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if ((bitEncoding[i] & bitEncoding[j]) == 0 && input[i].length() * input[j].length() > maxProd) {
                    maxProd = input[i].length()*input[j].length();
                    firstInd = i;
                    secondInd = j;
                }
            }
        }
        
        System.out.println(String.format("(%s, %s)\t %d", input[firstInd], input[secondInd], maxProd));
    }
    
    public static void main(String[] args) {
        findLongest(new String[] {"foo", "bar"});
        findLongest(new String[] {"foo", "bar", "booz", "apple"});
        findLongest(new String[] {"banana", "grape", "kiwi", "mango", "orange", "melon"});
    }
}

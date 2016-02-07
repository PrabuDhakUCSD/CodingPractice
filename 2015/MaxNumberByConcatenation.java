import java.util.*;
public class MaxNumberByConcatenation {

    static class DigitComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            char f, s;
            int lenA = a.length();
            int lenB = b.length();
            
            for(int i=0; i<Math.max(lenA, lenB); i++) {
                if (i < lenA) {
                    f = a.charAt(i);
                } else {
                    f = a.charAt(0);
                }
                
                if (i < lenB) {
                    s = b.charAt(i);
                } else {
                    s = b.charAt(0);
                }
                
                if (f == s)
                    continue;
                
                return s - f;
            }
            
            return lenB - lenA;
        }
    }
    
    public static String getMax(String[] input) {
        StringBuilder out = new StringBuilder();
        List<List<String>> buckets = new ArrayList<List<String>>();
        
        for(int i=0; i<=9; i++) {
            buckets.add(new ArrayList<String>());
        }
        
        // Add to bucket based on MSB
        for(String ip : input) {
            buckets.get(ip.charAt(0) - '0').add(ip);
        }
        
        boolean hasElements = true;
        
        for(int pos=1; hasElements; pos++) {
            hasElements = false;
            List<String> temp = new ArrayList<String>();
            for(int bucket=9; bucket>=0; bucket--) {
                for(String s : buckets.get(bucket)) {
                    temp.add(s);
                }
                
                buckets.get(bucket).clear();
            }
            
            for(String s : temp) {
                if (pos <= s.length()-1) {
                    hasElements = true;
                    buckets.get(s.charAt(pos)-'0').add(s);
                } else {
                    buckets.get(s.charAt(s.length()-1)-'0').add(s);
                }
            }
        }
        
        for(int bucket=9; bucket>=0; bucket--) {
            for(String s : buckets.get(bucket)) {
                out.append(s);
            }
        }
        
        return out.toString();
    }
    
    public static String getMaxSimple(String[] input) {
        Arrays.sort(input, new DigitComparator());
        StringBuilder sb = new StringBuilder();
        for(String s : input) {
            sb.append(s);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(getMax(new String[] {"34", "37"}));
        System.out.println(getMax(new String[] {"112", "113", "1"}));
        System.out.println(getMax(new String[] {"78", "79", "7"}));
        System.out.println(getMax(new String[] {"74", "79", "7"}));
        System.out.println(getMax(new String[] {"538", "5385"}));
        System.out.println(getMax(new String[] {"538", "53853"}));
        System.out.println(getMax(new String[] {"538", "53857"}));

        System.out.println("\nSimple method output:\n");
        
        System.out.println(getMaxSimple(new String[] {"34", "37"}));
        System.out.println(getMaxSimple(new String[] {"112", "113", "1"}));
        System.out.println(getMaxSimple(new String[] {"78", "79", "7"}));
        System.out.println(getMaxSimple(new String[] {"74", "79", "7"}));
        System.out.println(getMaxSimple(new String[] {"538", "5385"}));
        System.out.println(getMaxSimple(new String[] {"538", "53853"}));
        System.out.println(getMaxSimple(new String[] {"538", "53857"}));
    }
}
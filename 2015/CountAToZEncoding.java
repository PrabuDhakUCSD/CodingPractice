
public class CountAToZEncoding {

    public static int countEncoding(String num)
    {
        char[] ip = num.toCharArray();
        
        if (ip[0] == '0')
            throw new IllegalArgumentException();
        
        int[] count = new int[ip.length+1];
        count[0] = count[1] = 1;
        
        for(int i=2; i<=ip.length; i++) {
            if (ip[i-1] != '0') {
                count[i] = count[i-1];
            }
            
            if (ip[i-2] == '1' || (ip[i-2] == '2' && ip[i-1] >= '0' && ip[i-1] <= '6')) {
                count[i] += count[i-2];
            }
        }
        
        return count[ip.length];
            
    }
    
    public static void main(String[] args) {
        System.out.println(String.format("%s\t-- %d", "24",  countEncoding("24")));
        System.out.println(String.format("%s\t-- %d", "28",  countEncoding("28")));
        System.out.println(String.format("%s\t-- %d", "10",  countEncoding("10")));
        System.out.println(String.format("%s\t-- %d", "12332",  countEncoding("12332")));
        System.out.println(String.format("%s\t-- %d", "42167",  countEncoding("42167")));
    }

}

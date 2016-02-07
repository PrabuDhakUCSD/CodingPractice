
public class LargestNumberofKDigits {

	public static int getLargest(String a, String b, int k) {
		int lenA = a.length();
		int lenB = b.length();
		char[] ipA = a.toCharArray();
		char[] ipB = b.toCharArray();
		
		int[][][] dp = new int[k][lenA+1][lenB+1];
		
		for(int row=lenA; row>=0; row--) {
			for (int col=lenB; col>=0; col--) {
				if (row == lenA && col == lenB) {
					dp[0][row][col] = -1;
				} else if (row == lenA) {
					dp[0][row][col] = Math.max(dp[0][row][col+1], getInt(ipB[col]));
				} else if (col == lenB) {
					dp[0][row][col] = Math.max(dp[0][row+1][col], getInt(ipA[row]));
				} else {
					dp[0][row][col] = Math.max(dp[0][row+1][col], dp[0][row][col+1]);
				}
			}
		}
		
		for(int digit=1; digit<k; digit++) {
			for(int row=lenA; row>=0; row--) {
				for (int col=lenB; col>=0; col--) {
					dp[digit][row][col] = -1;
					
					if (row != lenA) {
						dp[digit][row][col] = Math.max(dp[digit][row][col], dp[digit][row+1][col]);
						dp[digit][row][col] = Math.max(dp[digit][row][col],
													getVal(getInt(ipA[row]), digit, dp[digit-1][row+1][col]));
					}
					
					if (col != lenB) {
						dp[digit][row][col] = Math.max(dp[digit][row][col], dp[digit][row][col+1]);
						dp[digit][row][col] = Math.max(dp[digit][row][col],
													getVal(getInt(ipB[col]), digit, dp[digit-1][row][col+1]));
					}
				}
			}
		}
		
		return dp[k-1][0][0];
	}
	
	private static int getInt(char ch) {
		return ch-'0';
	}
	
	private static int getVal(int currentNumber, int digits, int prevValue) {
		if (prevValue == -1)
			return -1;
		
		return currentNumber * (int) Math.pow(10, digits) + prevValue;
	}
	
	public static void main(String[] args) {
		String a = "429";
		String b = "683";
		
		System.out.println(getLargest(a, b, 6));
	}
}
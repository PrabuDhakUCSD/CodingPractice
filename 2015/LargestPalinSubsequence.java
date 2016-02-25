import java.util.*;

/*
 * Given an input string, find the longest palindrome subsequence.
 * 
 * dp[i][j] = length of longest palindrome subsequence of substring ip[i...j]
 * dp[0][len-1] is what is required
 *
 * dp[i][j] = 0 when i>j
 * dp[i][j] = 1 when i == j
 * dp[i][j] = dp[i+1][j-1]+2 when ip[i] == ip[j] (left diagonal cell)
              // no need to consider diagonal cell when ip[i] != ip[j] since left and bottom cell
              // would have already considered the left diagonal cell.
            = max(dp[i][j-1], dp[i+1][j]) otherwise (left or bottom cell))
 */
public class LargestPalinSubsequence {

	public static void printLongestPalinSubsequence(String input) {
		char[] ip = input.toCharArray();
		int len = ip.length;
		
		int[][] palinLen = new int[len][len];
		
		/*
		 * 0 - include start and end chars
		 * 1 - skip end char
		 * 2 - skip start char 
		 */
		int[][] direction = new int[len][len];
		
		for(int startPos = len-1; startPos >= 0; startPos--) {
			for (int endPos = 0; endPos < len; endPos++) {
				palinLen[startPos][endPos] = 0;
				
				if (endPos == startPos) {
					palinLen[startPos][endPos] = 1;
					direction[startPos][endPos] = 1; // Does not matter. Just want to get the startPos > endPos while tracking back.
				} else if (endPos > startPos) {
					if (ip[startPos] == ip[endPos]) {
						palinLen[startPos][endPos] = palinLen[startPos+1][endPos-1] + 2;
						direction[startPos][endPos] = 0;
					} else if (palinLen[startPos][endPos-1] > palinLen[startPos+1][endPos]) {
						palinLen[startPos][endPos] = palinLen[startPos][endPos-1];
						direction[startPos][endPos] = 1;
					} else {
						palinLen[startPos][endPos] = palinLen[startPos+1][endPos];
						direction[startPos][endPos] = 2;
					}
				}
			}
		}
		
		StringBuffer seqPart1 = new StringBuffer();
		StringBuffer seqPart2 = new StringBuffer();
		String output = "";

		int startPos = 0;
		int endPos = len-1;
		
		while (startPos <= endPos) {
			if (startPos == endPos) {
				seqPart1.append(ip[startPos]); // while loop should break in next iteration since there is no more subproblems.
			} else if (ip[startPos] == ip[endPos]) {
				seqPart1.append(ip[startPos]);
				seqPart2.insert(0, ip[startPos]);		
			}
			
			if (direction[startPos][endPos] == 0) {
				startPos += 1;
				endPos -= 1;
			} else if (direction[startPos][endPos] == 1) {
				endPos -= 1;
			} else {
				startPos +=1;
			}
		}
		
		output = seqPart1.toString() + seqPart2.toString();
		
		System.out.println(String.format("Longest palindrome subsequence: %s", output));
	}
	
	public static void main(String[] args) {
		printLongestPalinSubsequence("a"); // Expected 'a'
		printLongestPalinSubsequence("abc"); // Expected 'c'
		printLongestPalinSubsequence("abba"); // Expected 'abba'
		printLongestPalinSubsequence("a02p2pl608ee9l5tp34p45acat"); // Expected 'appleelppa'
		printLongestPalinSubsequence("geeks for geeks"); // Expected 'ee r ee'
	}
}

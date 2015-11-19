import java.util.*;

/*
 * Given a list of words as string, print all pairs which when joined together forms a palindrome string.
 * Eg. ("cat", "rat", "bat", "tar", "foo", "tac", "bar") should print ("cat", "tac") and ("rat", "tar").
 */
public class PalindromePair {

	public static void printPalindromePair(String[] input) {
		Set<String> hashSet = new HashSet<String>();
		
		for(String s : input) {
			String rev_s = reverseString(s);
			if (hashSet.contains(rev_s)) {
				System.out.println(String.format("(%s, %s)", rev_s, s));
			} else {
				hashSet.add(s);
			}
		}
	}
	
	private static String reverseString(String input) {
		StringBuffer sb = new StringBuffer(input);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String[] input = {"dog", "cat", "dog", "god", "rat", "bat", "tab", "lion", "king", "queen", "tar", "gink", "blah", "foo", "bar", "oof", "random"};
		printPalindromePair(input);
	}
}
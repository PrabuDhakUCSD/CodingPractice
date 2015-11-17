package strings;

import java.util.*;

public class SearchAndReplace {
	public static String searchAndReplace(String input, String pattern, String replacement) {
		if (input == null || pattern == null || replacement == null)
			throw new IllegalArgumentException();
		
		if (input.length() < pattern.length())
			return input;
		
		List<Integer> indOfPatternInInput = substringMatch(input, pattern);
		
		int offsetValue = replacement.length() - pattern.length();
		int totalOffset = 0;
		
		for(Integer ind : indOfPatternInInput) {
			int adjustedInd = ind + totalOffset;
			input = input.substring(0, adjustedInd) + replacement + input.substring(adjustedInd+pattern.length());
			totalOffset += offsetValue;
		}
		
		return input;
	}
	
	private static List<Integer> substringMatch(String input, String pattern) {
		List<Integer> indices = new ArrayList<Integer>();
		
		char[] inputC = input.toCharArray();
		char[] patC = pattern.toCharArray();
		
		int startIndex = 0;
		while(startIndex < inputC.length) {
			if (findMatch(inputC, patC, startIndex)) {
				indices.add(startIndex);
				startIndex += patC.length;
			} else {
				startIndex++;
			}
		}
		
		return indices;
	}
	
	private static boolean findMatch(char[] input, char[] pattern, int startIndex) {
		int i, j;
		for (i=startIndex, j=0; i<input.length && j<pattern.length; i++, j++) {
			if (input[i] != pattern[j]) {
				return false;
			}
		}
		
		if (j >= pattern.length)
			return true;
		
		return false;
	}
}

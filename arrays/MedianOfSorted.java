package arrays;

public class MedianOfSorted {
	public static double median(int[] input1, int[] input2) {
		if (input1 == null || input2 == null)
			throw new IllegalArgumentException();
		
		int len1 = input1.length;
		int len2 = input2.length;
		int totalLen = len1+len2;
		
		if (totalLen == 0) 
			throw new IllegalArgumentException();
		
		int medianPos = (totalLen+1)/2;
		int medianVal = 0;
		boolean seenFirstHalf = false;
		boolean isOddLength = (totalLen % 2 == 0)? false : true;
		
		int numElems = 0;
		int ind1 = 0, ind2 = 0;
		for (;ind1 < len1 && ind2 < len2;) {
			int smallValue;
			if (input1[ind1] < input2[ind2]) {
				smallValue = input1[ind1];
				ind1++;
			} else {
				smallValue = input2[ind2];
				ind2++;
			}
			
			if (seenFirstHalf) {
				return (double) (medianVal + smallValue)/2;
			}
			
			numElems++;
			if (numElems == medianPos) {
				if (isOddLength)
					return smallValue;
				
				seenFirstHalf = true;
				medianVal = smallValue;
			}
		}
		
		for (; ind1 < len1; ind1++) {
			
			if (seenFirstHalf)
				return (double) (medianVal + input1[ind1])/2;
			
			numElems++;
			if (numElems == medianPos) {
				if (isOddLength)
					return input1[ind1];
				
				seenFirstHalf = true;
				medianVal = input1[ind1];
			}
		}
		
		for (; ind2 < len2; ind2++) {
			
			if (seenFirstHalf)
				return (double) (medianVal + input2[ind2])/2;
			
			numElems++;
			if (numElems == medianPos) {
				if (isOddLength)
					return input2[ind2];
				
				seenFirstHalf = true;
				medianVal = input2[ind2];
			}
		}
		
		throw new IllegalArgumentException();
	}
}

----------------------

public class MedianOfSorted {
	boolean seenFirstHalf;
	double medianVal;
	
	double getMedian(int[] inp1, int[] inp2) {
	}
	
	boolean helper(boolean isOdd, int currPos, int reqIndex, int currVal) {
		if (seenFirstHalf) {
			median = (median+currVal)/2;
			return true;
		}
		
		if (currPos == reqIndex) {
			median = currVal;
			if (isOdd)
				return true;
			seenFirstHalf = true;
		}
	}
}























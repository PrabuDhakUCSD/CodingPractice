#include<stdio.h>


int findSum(int* input, int i, int j) {
	int k, sum = 0;
	for (k=i; k<=j; k++) {
		sum = sum + input[k];
	}
	return sum;
}

int main(int argc, char* argv[]) {
	int input[] = {-2,1,-3,4,-1,2,1,-5,4};
	//int input[] = {-2};
	int len = sizeof(input)/sizeof(int);
	int max = input[0];
	int startIndex = 0, endIndex = 0;
	int i, j, k, subSeqSum;

	// brute force implementation
	for (i=0; i<len; i++) {
		for (j=i; j<len; j++) {
			subSeqSum = findSum(input, i,j);
			if (subSeqSum > max) {
				startIndex = i;
				endIndex = j;
				max = subSeqSum;
			}
		}
	}

	printf(" ---Largest sub sequence----- \n");
	for (k=startIndex; k<= endIndex; k++) {
		printf("%d  ", input[k]);
	}

	printf("\nSum = %d\n", max);

	// one pass algorithm
	max = input[0];
	subSeqSum = 0;
	startIndex = endIndex = 0;
	int newStartIndex = 0;
	for (i=0; i<len; i++) {
		subSeqSum = subSeqSum + input[i];

		if (subSeqSum < input[i]) {
			subSeqSum = input[i];
			newStartIndex = i;
		}

		if (subSeqSum > max) {
			max = subSeqSum;
			startIndex = newStartIndex;
			endIndex = i;
		}
	}

	printf(" ---Largest sub sequence----- \n");
	for (k=startIndex; k<= endIndex; k++) {
		printf("%d  ", input[k]);
	}

	printf("\nSum = %d\n", max);

	return 0;
}

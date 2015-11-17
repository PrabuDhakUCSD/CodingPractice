#include<stdio.h>
#include<stdlib.h>


int findSum(int** input, int rows, int rowe, int cols, int cole) {

	int sum = 0;
	int c;
	for (;rows<=rowe; rows++) {
		for (c = cols;c<=cole; c++) {
			sum = sum + input[rows][c];
		}
	}
	return sum;
}

void printArray(int** input, int rows, int rowe, int cols, int cole) {
	int c;
	for (;rows<rowe; rows++) {
		for (c = cols;c<cole; c++) {
			printf("%d  ", input[rows][c]);
		}
		printf("\n");
	}
}

int kalgo(int* input, int len, int* cols, int* cole) {

	int max, subSeqSum, startIndex, endIndex, i;
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
			*cols = newStartIndex;
			*cole = i;
		}

	}

	return max;
}

int main(int argc, char* argv[]) {

	int rowsize, colsize, rows, cols, rowe, cole;
	printf ("Enter the row, column count: ");
	scanf("%d,%d", &rowsize, &colsize);

	int** input = (int**)malloc(sizeof(int*)*rowsize);
	int i, j, k, l, subSeqSum;

	printf("Feed the array row by row\n");

	for(i=0; i<rowsize; i++) {
		input[i] = (int*)malloc(sizeof(int)*colsize);
		for (j=0; j<colsize; j++) {
			printf("[%d][%d] Element: ", i, j);
			scanf("%d", &input[i][j]);
		}
	}

	printArray(input, 0, rowsize, 0, colsize);

	int max = input[0][0];

	// brute force implementation
	for (i=0; i<rowsize; i++) {
		for (j=i; j<rowsize; j++) {
			for (k=0; k<colsize; k++) {
				for (l=k; l<colsize; l++) {
					subSeqSum = findSum(input, i, j, k, l);

					if (subSeqSum > max) {
						rows = i;
						rowe = j;
						cols = k;
						cole = l;
						max = subSeqSum;
					}
				}
			}
		}
	}

	printf(" ---Largest sub array ----- \n");
	printArray(input, rows, rowe+1, cols, cole+1);

	printf("\nSum = %d\n", max);

	int temp[colsize], temp_cols, temp_cole;
	// optimal solution
	for (i=0; i<rowsize; i++) {

		for (k=0; k<colsize; k++) {
			temp[k] = 0;
		}

		for (j=i; j<rowsize; j++) {

			for (k=0; k<colsize; k++) {
				temp[k] = temp[k] + input[j][k];
			}

			subSeqSum = kalgo(temp, colsize, &temp_cols, &temp_cole);

			if (subSeqSum > max) {
				max = subSeqSum;
				rows = i;
				rowe = j;
				cols = temp_cols;
				cole = temp_cole;
			}
		}
	}

	printf(" ---Largest sub array ----- \n");
	printArray(input, rows, rowe+1, cols, cole+1);

	printf("\nSum = %d\n", max);

	return 0;
}

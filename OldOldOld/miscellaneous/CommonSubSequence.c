#include<stdio.h>
#include<strings.h>
#include<string.h>
#include<stdlib.h>

void buildTables(char* seqA, char* seqB, int lenA, int lenB, int** countArray, int** direction) {
	int row, col, temp;

	for (row=0; row<lenA; row++) {
		for (col=0; col<lenB; col++) {
			if (seqA[row] == seqB[col]) {
				direction[row][col] = 1;
				if (row == 0 || col == 0) {
					countArray[row][col] = 1;
				}
				else {
					countArray[row][col] = countArray[row-1][col-1] + 1;
				}
			}
			else {

				direction[row][col] = 2;
				if (row == 0) 
					countArray[row][col] = 0;
				else
					countArray[row][col] = countArray[row-1][col];

				if (col == 0)
					temp = 0;
				else 
					temp = countArray[row][col-1];

				
				if (temp > countArray[row][col]) {
					direction[row][col] = 3;
					countArray[row][col] = temp;
				}
			}
		}
	}
}

void traceSequence(char* sequence, int row, int col, int** direction) {

	if (row == -1 || col == -1)
		return;

	if (direction[row][col] == 1) {
		traceSequence(sequence, row-1, col-1, direction);
		printf("%c  ", sequence[row]);
		return;
	}

	if (direction[row][col] == 2) {
		traceSequence(sequence, row-1, col, direction);
		return;
	}
	if (direction[row][col] == 3) {
		traceSequence(sequence, row, col-1, direction);
		return;
	}
}

int** allocate2Darray(int rowsize, int colsize) {
	int** array = (int**)malloc(sizeof(int*)*rowsize);
	int i;
	for (i=0; i<rowsize; i++) {
		array[i] = (int*)malloc(sizeof(int)*colsize);
		bzero(array[i], sizeof(int)*colsize);
	}
	return array;
}

int main(int argc, char** argv) {
	char* seqA = argv[1];
	char* seqB = argv[2];
	int lenA = strlen(seqA);
	int lenB = strlen(seqB);

	int** countArray = allocate2Darray(lenA, lenB);
	int** direction = allocate2Darray(lenA, lenB);

	buildTables(seqA, seqB, lenA, lenB, countArray, direction);
	traceSequence(seqA, lenA-1, lenB-1, direction);

	return 0;
}

#include<stdio.h>

void swap(int* input, int posA, int posB) {
	int temp = input[posA];
	input[posA] = input[posB];
	input[posB] = temp;
}

void quickSort(int* input, int start, int end) {
	if (end-start <=0) 
		return;
	
	int key = end;
	int smallest = start-1;
	int runningPointer = start;

	while(runningPointer < key) {

		if (input[runningPointer] <= input[key]) {
			swap(input, smallest+1, runningPointer);
			smallest++;
			runningPointer++;
		}

		else {
			runningPointer++;
		}
	}

	swap(input, smallest+1, key);

	quickSort(input, start, smallest);
	quickSort(input, smallest+2, end);
}

void printArray(int* input, int len) {
	int i;
	for (i=0; i<len; i++)
		printf("%d ", input[i]);
}

int main() {
	//int input[] = { 9, 1, 4, 2, 7, 10, 13, 3, 6};
	//quickSort(input, 0, 8);
	//printArray(input, 9);

	//int input[] = { 9, 1};
	//quickSort(input, 0, 1);
	//printArray(input, 2);

	int input[] = {9};
	quickSort(input, 0, 0);
	printArray(input, 1);

	return 0;
}

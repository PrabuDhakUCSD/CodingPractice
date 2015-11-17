#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void enumerateCombinationRecursive(char* input, char* output, int len, int size, int seensofar, int startPos) {
	if (size == 0) {
		printf("%s\n", output);
		return;
	}

	int i = 0;
	for (i=startPos; len-i>=size; i++) {
		output[seensofar] = input[i];
		enumerateCombinationRecursive(input, output, len, size-1, seensofar+1, i+1);
	}
}

void enumerateCombination(char* input, int size) {
	char* output = (char*)malloc(size);
	bzero(output, size);
	int len = strlen(input);
	enumerateCombinationRecursive(input, output, len, size, 0, 0);
}


int main(int argc, char** argv) {
	char* input = argv[1];
	enumerateCombination(input, 3);

	return 0;
}

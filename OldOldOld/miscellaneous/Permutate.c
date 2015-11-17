#include<stdio.h>
#include<string.h>

void swapChars(char* input, int posA, int posB) {
	char temp = input[posB];
	input[posB] = input[posA];
	input[posA] = temp;
}

void permuteRecursive(char* input, int startPos, int len) {

	if (startPos == len-1) {
		printf("%s\n", input);
	}

	int i;

	for (i=startPos; i<len; i++) {
		swapChars(input, startPos, i);
		permuteRecursive(input, startPos+1, len);
	}
}

void permute(char* input) {
	permuteRecursive(input, 0, strlen(input));
}

int main(int argc, char** argv) {
	char* input = argv[1];
	permute(input);
	return 0;
}

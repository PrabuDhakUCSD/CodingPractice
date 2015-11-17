#include<stdio.h>
#include<string.h>

void reverse(char* input, int startIndex, int endIndex) {
	int len = endIndex - startIndex + 1;
	int i,j;
	char c;

	for (i=startIndex, j=endIndex; i<startIndex+(len/2); i++, j--) {
		c = input[i];
		input[i] = input[j];
		input[j] = c;
	}
}

int main(int argc, char** argv) {
	char* input = argv[1];
	int len = strlen(input);
	int startIndex, endIndex, i;

	reverse(input, 0, len-1);

	for (i=0; i<len; i++) {
		if (input[i] == ' ')
			continue;

		startIndex = i;

		while( i<len && input[i] != ' ') {
			i++;
		}

		endIndex = i-1;

		reverse(input, startIndex, endIndex);
	}

	printf("%s\n", input);

	return 0;
}

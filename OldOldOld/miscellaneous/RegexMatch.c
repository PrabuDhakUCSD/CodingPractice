#include <stdio.h>

int isSame(char* pattern, char* inputstr) {
	while(*pattern != '\0') {

		//if (*inputstr == '\0')
		//	return 0;

 		if (*pattern == '*') {
			pattern ++;

			while( *inputstr != '\0' && !isSame(pattern, inputstr++) );
			if (*inputstr == '\0' && *pattern == '\0')
				return 1;
			else if (*inputstr == '\0')
				return 0;
			else
				return 1;
		}
		if (*(pattern++) != *(inputstr++)) {
			return 0;
		}
	}

	if (*inputstr != '\0')
		return 0;

	return 1;
}

int main(int argc, char** argv) {
	char* pattern = argv[1];
	char* input = argv[2];

	if (isSame(pattern, input) == 1) {
		printf("Matched!\n");
	}
	else {
		printf("Does not match\n");
	}
	return 0;
}

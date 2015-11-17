#include<stdlib.h>
#include<values.h>
#include<stdio.h>
#include<math.h>
#include<string.h>

int main(int argc, char* argv[]) {

	printf("Usage: %s <string representation of integer>\n", argv[0]);

	char* inputStr = argv[1];

	int maxPositiveInt = MAXINT;
	int maxNegativeInt = MAXINT+1;
	int maxInt = maxPositiveInt;

	int length = strlen(inputStr);
	int startPos = 0;
	double digitPos = length-1;

	if (inputStr[0] == '-') {
		maxInt = maxNegativeInt;
		startPos = 1;
		digitPos = length-2;
	}

	unsigned int sum = 0;
	unsigned int prevsum = 0;

	for (;startPos < length; startPos++, digitPos--) {
		prevsum = sum + (inputStr[startPos]-'0')*(pow(10, digitPos));

		if (prevsum < sum || prevsum > maxInt) {
			printf("Overflow");
			sum = maxInt;
			break;
		}

		sum = prevsum;
	}

	if (inputStr[0] == '-') {
		sum = 0 - sum;
	}

	printf("Integer form: %d\n", sum);
	printf("atoi output: %d\n", atoi(inputStr));

	return 0;
}

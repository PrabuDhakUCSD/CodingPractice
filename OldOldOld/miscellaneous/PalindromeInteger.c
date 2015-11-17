#include<stdio.h>
#include<math.h>

int isPalindrome(int number) {
    int forLSB = number;
    int forMSB = number;

    int t = number, i;
    int numdigits = 0;

    while(t != 0) {
        t = t/10;
        numdigits++;
    }

    for (i=0; i<(numdigits/2); i++) {
        if ( (forLSB%10) != (int)(forMSB/pow(10, numdigits-1-i))) {
            return 0;
        }

        forLSB/=10;
        forMSB = forMSB % ((int) pow(10, numdigits-1-i));
    }

    return 1;
}

int main(int argc, char** argv) {
    int number = atoi(argv[1]);

    if (isPalindrome(number)) {
        printf("%d is a palindrome\n", number);
    }

    else {
        printf("%d is NOT a palindrome\n", number);
    }

    return 0;
}

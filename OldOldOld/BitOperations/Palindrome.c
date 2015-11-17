#include<stdio.h>
#include<stdlib.h>

int leftRotate(unsigned int a) {
    return (a<<1 | a>>31);
}

int main(int argc, char** argv) {
    int size = sizeof(int)*8;
    int i;

    unsigned int number = 2147483649;
    unsigned int number_dup = number;

    leftRotate(number);

    for (i=1; i<= size/2; i++) {
        number_dup = leftRotate(number_dup);
//        printf("%ud  -- %ud\n", number, number_dup);
        if ((number & 0x01) != (number_dup & 0x01)) {
            printf("Not a palindrome!");
            return 0;
        }
        number = number >> 1;
    }

    printf("Palindorme\n");


    return 0;
}

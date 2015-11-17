#include<stdio.h>
#include<stdlib.h>

int main() {
    int a = 0x05060799;
    char x = a&0xFF;
    printf("%d\n", a);

    int i, b1, b2;

    for (i=0; i<=3; i++) {
        b1 = ((x>>i)&1);
        b2 = ((x>>(7-i))&1);
        if ( b1 != b2) {
            printf("%d, %d, %d Not palindrome!\n", i, b1, b2);
            exit(0);
        }
    }
    printf("Palindrome!");
    return 0;
}

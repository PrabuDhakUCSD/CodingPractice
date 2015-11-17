#include<stdio.h>
#include<string.h>

void swap(char* num, int posa, int posb) {
    char t = num[posa];
    num[posa] = num[posb];
    num[posb] = t;
}

void nextBiggestNumber(char* num) {

    int numdigits = strlen(num), hidigit, lodigit;
    int len = strlen(num);
    
    if (len == 1)
        return;

    for (hidigit = len-2; hidigit>=0; hidigit--) {
        for (lodigit = hidigit+1; lodigit<=len-1; lodigit++) {
            if (num[hidigit] < num[lodigit]) {
                continue;
            }
            else {
                lodigit = lodigit-1;
                if (hidigit != lodigit) {
                    swap(num, hidigit, lodigit);
                    return;
                }
                else {
                    break;
                }
            }
        }

        if (lodigit == len) {
            swap(num, hidigit, lodigit-1);
            return num;
        }
    }

    return;
}

int main(int argc, char** argv) {

    char* input = argv[1];
    nextBiggestNumber(input);
    printf("Next Biggest: %s\n", input);
    return 0;
}

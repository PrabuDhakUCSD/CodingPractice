#include<stdio.h>
#include<string.h>

void resetHash(int* hash) {
    int i = 25;
    while (i>=0) {
        hash[i] = -1;
        i--;
    }
}

int findLongestSubstring(char* inp, int* start, int* end) {
    int len = strlen(inp);
    int i = 0, max = 0, curStart = 0, curLen = 0;
    int curcharIndex;
    int hash[26];
    resetHash(hash);

    for(i=0; i<len; ) {
        curcharIndex = inp[i]-'a';
        if (hash[curcharIndex] == -1) {
            hash[curcharIndex] = i;
            curLen++;
            if (curLen > max) {
                max = curLen;
                *start = curStart;
                *end = i;
            }
            i++;
        }
        else {
            i = hash[curcharIndex] + 1;
            resetHash(hash);
            curLen = 0;
            curStart = i;
        }
    }

    return max;
}

int main(int argc, char** argv) {
    char* inp = argv[1];
    int start, end, max, i;

    max = findLongestSubstring(inp, &start, &end);

    printf("%d -- Substring: ", max);
    for (i=start; i<=end; i++)
        printf("%c", inp[i]);
    printf("\n");

    return 0;
}

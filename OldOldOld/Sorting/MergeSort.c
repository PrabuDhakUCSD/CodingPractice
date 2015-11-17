#include<stdio.h>
#include<stdlib.h>

int* mergesort(int* a, int left, int right) {
    if (left==right) {
        int* result = (int*)(malloc(sizeof(int)));
        result[0] = a[left];
        return result;
    }

    int i,j;

    int middlelem = left+((right-left)/2);
    int leftsize = middlelem-left+1;
    int rightsize = right-middlelem;

    int* arr1 = mergesort(a, left, middlelem);
    int* arr2 = mergesort(a, middlelem+1, right);
    int* result = (int*)(malloc(sizeof(int)*(leftsize+rightsize)));

    int resultIndex = 0;
    for (i=0, j=0; i<leftsize && j<rightsize;) {
        if (arr1[i] < arr2[j]) {
            result[resultIndex++] = arr1[i];
            i++;
        }
        else {
            result[resultIndex++] = arr2[j];
            j++;
        }
    }

    while(i<leftsize) {
        result[resultIndex++] = arr1[i++];
    }

    while(j<rightsize) {
        result[resultIndex++] = arr2[j++];
    }
    return result;
}

int main() {
    int a[] = {10, 9, 8, 5, 1, 15, 2, 13, 16};
    //int a[] = {9,8,7};
    int* result = mergesort(a, 0, 8);
    int i=0;
    for (i=0; i<=8; i++) {
        printf("%d ", result[i]);
    }

    return 0;
}

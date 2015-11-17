#include<stdio.h>

void transposeMat(int** a, int rs, int cs, int re, int ce) {
    int rows = re-rs;
    if (rows==0)
        return;

    int i, t;
    for (i=rs; i<=rows; i++) {
        t = a[i][cs];
        a[i][cs] = a[cs][i];
        a[cs][i] = t;
    }

    transposeMat(a, rs+1, cs+1, re, ce);
}

void printMat(int** a, int rows, int cols) {
    int i,j;

    for (i=0; i<rows; i++) {
        for (j=0; j<cols; j++) {
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }
}

int main() {
	int rowsize, colsize, rows, cols, rowe, cole;
	printf ("Enter the row, column count: ");
	scanf("%d,%d", &rowsize, &colsize);

	int** input = (int**)malloc(sizeof(int*)*rowsize);
	int i, j, k, l, subSeqSum;

	printf("Feed the array row by row\n");

	for(i=0; i<rowsize; i++) {
		input[i] = (int*)malloc(sizeof(int)*colsize);
		for (j=0; j<colsize; j++) {
			printf("[%d][%d] Element: ", i, j);
			scanf("%d", &input[i][j]);
		}
	}

    printMat(input, rowsize, colsize);
    transposeMat(input, 0, 0, rowsize-1, colsize-1);
    printMat(input, rowsize, colsize);
    return 0;
}

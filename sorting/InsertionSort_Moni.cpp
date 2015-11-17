#include <iostream>
#include <stdlib.h>
using namespace std;
int size;
void swap(int *m, int *n)
{
	int temp;
	temp=*m;
	*m=*n;
	*n=temp;
} 
	
void insertionSort(int *input) 
{
	int i,j;
	for(i=0;i<size;i++)
	{
		for(j=i;j>0;j--)
		{
			while(input[j]<input[j-1])
				swap(input[j],input[j-1]);
		}
	}
}
int main() {
	int *input;
	int i;
	cin>>size;
	input=(int*) malloc(size*sizeof(int));
	for(i=0;i<size;i++)
	{
		cin>>input[i];
	}
	insertionSort(input);
	for(i=0;i<size;i++)
	{
		cout<<input[i]<<" ";
	}
	return 0;
}

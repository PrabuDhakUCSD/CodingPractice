#! /usr/bin/env python
import sys

def mergesort(inp, left, right):
    if (left==right):
        return [inp[left]]

    middleElem = left+((right-left)/2)

    leftArr = mergesort(inp, left, middleElem)
    rightArr = mergesort(inp, middleElem+1, right)
    result = []

    i=0
    j=0

    while (i<len(leftArr) and j<len(rightArr)):
        if (leftArr[i] < rightArr[j]):
            result.append(leftArr[i])
            i+=1
        else:
            result.append(rightArr[j])
            j+=1

    for x in leftArr[i:]:
        result.append(x)

    for x in rightArr[j:]:
        result.append(x)

    return result

if __name__ == '__main__':
    inp = sys.argv[1].split(" ")
    inp = map(lambda x: int(x), inp)
    print inp
    x = mergesort(inp, 0, len(inp)-1)
    print x

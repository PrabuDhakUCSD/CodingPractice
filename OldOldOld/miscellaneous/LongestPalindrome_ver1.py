#! /usr/bin/env python
import sys

def findLengthPalindrome(inp):
    maxStart, maxEnd = 0,0
    maxLength = 0
    for i in range(1, len(inp)):
        length, start, end = findLengthPalindromeatX(i, inp)
        if length>maxLength:
            maxLength = length
            maxStart = start
            maxEnd = end

    print maxStart, maxEnd
    return inp[maxStart:maxEnd+1]

def findLengthPalindromeatX(pos, inp):
    oddNeven = [(pos-1,pos+1, 0), (pos, pos+1, 0)]
    length = len(inp)

    maxLength = 1
    maxStart = pos
    maxEnd = pos

    for (start,end, currentLength) in oddNeven:
        while start>=0 and end<length:
            if start==end:
                currentLength+=1
            elif inp[start] == inp[end]:
                currentLength+=2
            else:
                break
            start-=1
            end+=1

        if(currentLength > maxLength):
            maxLength = currentLength
            maxStart = start+1
            maxEnd = end-1

    return maxLength, maxStart, maxEnd


if __name__ == '__main__':
    inp = sys.argv[1]
    print findLengthPalindrome(inp)

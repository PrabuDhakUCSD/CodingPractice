#! /usr/bin/env python
import sys

def getMinRange(inp, count):
    minLength = 0
    minPos = 1

    startPos = endPos = 1

    while 1:
        if inp[endPos] == 0:
            count-=1
        if count == 0:
            break
        endPos+=1

    minLength = endPos-startPos+1 
    minPos = endPos

    while endPos < len(inp):
        if inp[endPos]!=0:
            endPos+=1
            continue

        while inp[startPos] != 0:
            startPos+=1

        currentDist = endPos-startPos+1

        if (currentDist < minLength):
            minLength = currentDist
            minPos = endPos

        startPos+=1
        endPos+=1

    return minLength, minPos 

inp = map(lambda x : int(x), sys.argv[1].split(' '))
inp.insert(0, 0)
print inp[1:]
count = int(sys.argv[2])

(length, end) = getMinRange(inp, count)
print length, end
print inp[end-length+1:end+1]

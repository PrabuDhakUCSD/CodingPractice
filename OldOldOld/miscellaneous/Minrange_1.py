#!/usr/bin/env python
import sys

def findMinRange(inp, dic):
    minPos = 0
    minLength = len(inp)

    startPos = endPos = 0
    currentLen = 0
    needed = len(dic)

    while endPos < len(inp):

        if inp[endPos] in dic:
            dic[inp[endPos]] -= 1
            if dic[inp[endPos]] == 0:
                needed -=1

        if needed == 0:
            print startPos, endPos
            while (True):
                if inp[startPos] in dic:
                    dic[inp[startPos]] += 1
                    if dic[inp[endPos]] == 1:
                        needed += 1

                    if needed != 0:
                        break
                startPos += 1

            currentLen = endPos-startPos+1

            if currentLen < minLength:
                minLength = currentLen
                minPos = endPos

            startPos += 1
            endPos += 1

        else:
            endPos += 1

    return minLength, minPos

if __name__ == '__main__':
    inp = map(lambda x: int(x), sys.argv[1].split(" "))
    nums = map(lambda x: int(x), sys.argv[2].split(" "))
    freq = map(lambda x: int(x), sys.argv[3].split(" "))
    dic = {}

    for (key,value) in zip(nums, freq):
        dic[key] = value

    print dic

    minRange, endPos = findMinRange(inp, dic)
    print minRange, endPos
    print inp[endPos-minRange+1:endPos+1]

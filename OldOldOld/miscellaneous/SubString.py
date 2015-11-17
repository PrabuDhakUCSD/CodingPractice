#! /usr/bin/env python
import sys

def preprocess(inp):
    longestSuffix = [0]*len(inp)
    matchedSoFar = 0

    for i in range(2, len(inp)):

        while matchedSoFar>1 and inp[matchedSoFar+1] != inp[i]:
            matchedSoFar = longestSuffix[matchedSoFar]

        if inp[matchedSoFar+1] == inp[i]:
            matchedSoFar += 1
            print i
            longestSuffix[i] = matchedSoFar

    return longestSuffix

def findSubstring(inputstr, substr, prefixTable):
    
    matchedSoFar = 0
    for i in range(1, len(inputstr)):

        while matchedSoFar>1 and substr[matchedSoFar+1] != inputstr[i]:
            matchedSoFar = prefixTable[matchedSoFar]

        if substr[matchedSoFar+1] == inputstr[i]:
            matchedSoFar += 1

        if matchedSoFar == len(substr)-1:
            print 'Match occurs with shift: ', i-matchedSoFar
            matchedSoFar = 0


if __name__ == '__main__':
    inputstr = sys.argv[1]
    inputstr = " " + inputstr
    substr = sys.argv[2]
    substr = " " + substr

    prefixTable = preprocess(substr)
    findSubstring(inputstr, substr, prefixTable)

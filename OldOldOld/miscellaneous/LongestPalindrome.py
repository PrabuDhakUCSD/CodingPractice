#! /usr/bin/env python
import sys

def findLengthyPalindrome(inp):
    if len(inp) <=1:
        return len(inp), 0 

    palinLength = [1]
    maxLength = 1
    endPos = 0

    for i in range(1, len(inp)):
        palinLength.append(1)
        prevChar = i-1
        startIndex = prevChar-(palinLength[prevChar]-1)
        print i, startIndex

        if (startIndex != 0 and inp[startIndex-1] == inp[i]):
            palinLength[i] = palinLength[prevChar]+2
        elif (inp[i] == inp[prevChar]):
            palinLength[i] = palinLength[prevChar]+1

        if (palinLength[i] > maxLength):
            maxLength = palinLength[i]
            endPos = i

        print i, palinLength

    return maxLength, endPos-(maxLength-1)


if __name__ == '__main__':
    inp = sys.argv[1]
    length, startPos = findLengthyPalindrome(inp)
    print 'Length: ', length, 'startPos: ', startPos, ' PalindromeString: ', inp[startPos:startPos+length]


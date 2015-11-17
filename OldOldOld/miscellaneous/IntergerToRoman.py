#!/usr/bin/env python
import sys
import collections

dic = {1:'I', 5:'V', 10:'X', 50:'L', 100:'C', 500:'M', 1000:'D'}

romlist = [1, 5, 10, 50, 100, 500, 1000] 
print romlist

def convertToRoman(num):
    if num <= 0:
        return ""

    largestDivisor = 1 

    if num in romlist:
        return dic[num]

    else:
        for i in romlist:
            if i<num:
                largestDivisor = i
            else:
                break

        count = num/largestDivisor
        remaining = num%largestDivisor
        res = dic[largestDivisor]*count

        return res+convertToRoman(remaining)

if __name__ == '__main__':
    inp = int(sys.argv[1])
    print convertToRoman(inp)

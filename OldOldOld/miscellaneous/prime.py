#! /usr/bin/env python
import math
import sys

def isPrime(num):

    if num==1:
        return False

    for i in range(2, int(math.sqrt(num))+1):
        if num%i == 0:
            return False
    return True

inp = int(sys.argv[1])

for num in range (1, inp+1):
    if isPrime(num):
        print num, ' '

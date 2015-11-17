#! /usr/bin/env python
import sys

def nextBigNumber(num):
    number = list(num)
    length = len(number)

    for index in range(length-2, -1, -1):
        if number[index] < number[index+1]:
            left = number[:index]
            right = sorted(number[index:])
            nextNum = number[right.index(number[index])+1]
            right.remove(nextNum)
            return int("".join(left+list(nextNum)+right))

if __name__ == '__main__':
    print 'Enter the number to reverse: '
    num = sys.stdin.readline().rstrip()
    print 'Next biggest number: %d' % nextBigNumber(num)

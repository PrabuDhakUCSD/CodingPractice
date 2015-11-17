#! /usr/bin/env python
import sys

inp = sys.argv[1].split(" ")
length = len(inp)
prev = [-1]
LIS = [1]
maxLen = 1
lastElem = 0;

for i in range(1,length):
    LIS.insert(i,1)
    prev.insert(i,-1)
    for j in range (i-1,-1,-1):
        if ((int(inp[i]) > int(inp[j])) and (LIS[j]+1 > LIS[i])):
            LIS[i] = LIS[j]+1
            if LIS[i] > maxLen:
                maxLen = LIS[i]
                lastElem = i
            prev[i]=j

print 'Max sequence length: %d' % maxLen
# backtrace
result = []
while lastElem>=0:
    result.append(inp[lastElem])
    lastElem = prev[lastElem]

print 'Longest increasing sequence: '
print result[::-1]


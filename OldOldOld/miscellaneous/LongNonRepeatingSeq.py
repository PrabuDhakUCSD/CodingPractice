#! /usr/bin/env python

import sys
import collections

inp = sys.argv[1]
inp = " "+inp[:]
length = len(inp)
dic = collections.defaultdict(int)

maxlen = startpos = endpos = 0
currentlen = 0
currentstart = currentend = 1

for i in range(1, length):
    if dic[inp[i]] != 0:
        currentstart = dic[inp[i]]+1
        currentend = i
        currentlen = currentend-currentstart+1
        dic[inp[i]] = i
    else:
        dic[inp[i]] = i
        currentlen+=1
        currentend = i

    if currentlen > maxlen:
        maxlen = currentlen
        startpos = currentstart
        endpos = currentend

print 'Range: %d-%d' % (startpos, endpos)
print inp[startpos:endpos+1]

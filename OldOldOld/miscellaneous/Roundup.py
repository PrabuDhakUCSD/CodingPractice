#! /usr/bin/env python
import sys

num = int(sys.argv[1])
strnum = str(num)

for i in range (len(strnum)-2, -1, -1):
    if i == '9':
        continue
    else :
        break

pos = len(strnum)-1-i
print (num/(10**pos))*(10**pos)+(10**pos)


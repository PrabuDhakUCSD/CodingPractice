#! /usr/bin/env python

import sys

inp = sys.argv[1]
inp = inp.lower()
result = 0

result = reduce(lambda x, y: x*26 + (ord(y)-ord('a')+1), inp)

#for i in inp:
#    result = result*26+(ord(i)-ord('a')+1)

print result

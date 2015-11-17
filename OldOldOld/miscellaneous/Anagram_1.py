#! /usr/bin/env python

import sys

inp1 = sys.argv[1].lower()
inp2 = sys.argv[2].lower()

l1 = list(inp1)
l2 = list(inp2)

if ' ' in l1:
    l1.remove(' ')
if ' ' in l2:
    l2.remove(' ')

l3 = l1+l2
print l3

if reduce(lambda x,y: (ord(x))^(ord(y)), l3) == 0:
    print 'Anagrams!'
else:
    print 'Not anagram'

#! /usr/bin/env python

import sys

inp1 = sys.argv[1]
inp2 = sys.argv[2]

l1 = list(inp1)
l2 = list(inp2)

if ' ' in l1:
    l1.remove(' ')
if ' ' in l2:
    l2.remove(' ')

dic = {}

for char in l1:
    if char in dic.keys():
        dic[char] += 1
    else:
        dic[char] = 1


for char in l2:
    if char in dic.keys():
        dic[char] -= 1
        if dic[char] == 0:
            del dic[char]
    else:
        print 'Not anagram'
        exit(1)

if len(dic) > 0:
    print 'Not anagram'
else:
    print 'Anagrams!'

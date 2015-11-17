#!/usr/bin/env python
import sys

def permutate(inp):
    if len(inp) <= 1:
        return inp

    firstchar = inp[0]
    perms = permutate(inp[1:])
    result = []
    for aPerm in perms:
        for i in range(0,len(aPerm)+1):
            result.append(aPerm[:i]+firstchar+aPerm[i:])

    return result

inp = sys.argv[1]
perms = permutate(inp)
for i in perms:
    print i

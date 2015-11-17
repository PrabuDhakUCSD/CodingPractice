#! /usr/bin/env python
import sys

def generateCombination(inp):
    if len(inp) == 1:
        return [[],[inp[0]]]

    myContrib = inp[0]
    rest = generateCombination(inp[1:])
    result = []
    for aCombination in rest:
        s = aCombination[:]
        t = aCombination[:]
        t.append(myContrib)
        result.append(s)
        result.append(t)

    return result

if __name__ == '__main__':
    inp = map(lambda x : int(x), sys.argv[1].split(" "))
    result = generateCombination(inp)
    for anItem in result:
        print anItem

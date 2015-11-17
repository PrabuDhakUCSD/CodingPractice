#! /usr/bin/env python
import sys

if __name__ == '__main__':
    inp = map(lambda x: int(x), sys.argv[1].split(' '))
    uniqueElems = set(inp)

    print inp
    print uniqueElems

    for i in uniqueElems:
        inp.append(i)

    res = reduce(lambda x, y: x^y, inp)
    print 'Even occuring elem: ', res

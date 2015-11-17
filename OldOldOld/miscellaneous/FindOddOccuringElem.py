#! /usr/bin/env python
import sys

if __name__ == '__main__':
    inp = map(lambda x: int(x), sys.argv[1].split(' '))
    i = 0
    res = reduce(lambda x, y: x^y, inp)
    print 'Odd occuring elem: ', res

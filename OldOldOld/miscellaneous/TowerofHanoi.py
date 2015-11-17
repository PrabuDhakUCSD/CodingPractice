#! /usr/bin/env python

import sys

def TOH(n, src, inter, dest):
    if (n==1):
        print 'Move %d from %s to %s' % (n, src, dest)
        return
    else:
        TOH(n-1, src, dest, inter)
        print 'Move %d from %s to %s' % (n, src, dest)
        TOH(n-1, inter, src, dest)

n = int(sys.argv[1])
TOH(n, "A", "B", "C")


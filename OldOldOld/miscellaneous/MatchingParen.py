#! /usr/bin/env python

import sys

def isMatch(inp):
    opening = set('({[')
    match = set([('(',')'),('{','}'),('[',']')])
    stack = []

    for char in inp:
        if char in opening:
            stack.append(char)
        else:
            if len(stack) == 0:
                return False
            x = (stack.pop(), char)
            if x not in match:
                return False

    return (len(stack)==0)


if __name__ == '__main__':
    if isMatch(sys.argv[1]):
        print 'Success' 

#! /usr/bin/env python
import sys

def reverse(inputstr):
	if len(inputstr) <= 1:
		return inputstr

	firstchar = inputstr[0]
	subreversed = reverse(inputstr[1:])
	return subreversed+firstchar

if __name__ == '__main__':
	inputstr = sys.stdin.readline().rstrip()
	reversedString = reverse(inputstr)

	print reversedString
	

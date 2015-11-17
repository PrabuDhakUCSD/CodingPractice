#!/usr/bin/env python
import sys

def permutate(inputstr):

	if len(inputstr) <= 1:
		return [inputstr]
	
	aChar = inputstr[0];
	permutations = permutate(inputstr[1:]);
	result = []
	for aWord in permutations:
		for i in range(len(aWord)+1):
			result.append(aWord[:i] + aChar + aWord[i:]) 

	return result

if __name__ == '__main__':
	print "Enter the input string: ",
	inputstr = sys.stdin.readline().rstrip()
	result = permutate(inputstr)

	for aWord in result:
		print aWord



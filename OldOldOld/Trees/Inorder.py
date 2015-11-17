#! /usr/bin/env python

import sys

class Node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right

class TreeOps:

    def __init__(self):
        self.root = None

    def insert(self, value):
        if self.root == None:
            self.root = Node(value, None, None)
            return

        temp = self.root

        while(True):
            if value<= temp.value:
                if temp.left == None:
                    temp.left = Node(value, None, None)
                    return
                else:
                    temp = temp.left

            else:
                if temp.right == None:
                    temp.right = Node(value, None, None)
                    return
                else:
                    temp = temp.right

    def inOrder(self, node):
        if (node == None):
            return

        self.inOrder(node.left)
        print node.value,' ',
        self.inOrder(node.right)

if __name__ == '__main__':
    inp = map(lambda x: int(x), sys.argv[1].split(' '))
    tree = TreeOps()
    for i in inp:
        tree.insert(i)

    print 'Inorder traversal: '
    tree.inOrder(tree.root)


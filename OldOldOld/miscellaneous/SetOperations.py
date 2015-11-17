#! /usr/bin/env python
import sys

if __name__ == '__main__':
    list1 = list(set(sys.argv[1].split(" ")))
    list2 = list(set(sys.argv[2].split(" ")))

    print 'Intersection of list1 and list2'
    intersecList = filter(lambda x: x in list2,list1)

    print intersecList

    print 'Union of list2 and list2'
    unionList = list(set(list1+list2))

    print unionList

    print 'Diff list1-list2'
    diffList = filter(lambda x: x not in list2,list1)
    print diffList

    print 'Diff list2-list1'
    diffList = filter(lambda x: x not in list1,list2)
    print diffList

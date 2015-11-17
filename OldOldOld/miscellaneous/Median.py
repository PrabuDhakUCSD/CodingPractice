#! /usr/bin/env python

import heapq
import sys

class Median:
    
    def __init__(self):
        self.totalElements = 0
        self.maxHeap = []
        self.minHeap = []

    def addElem(self, num):
        if (self.totalElements%2 == 0):
        # Add to the max heap
            if len(self.minHeap) == 0:
                heapq.heappush(self.maxHeap, num*-1)
            elif num >= self.minHeap[0]:
                toMax = heapq.heappushpop(self.minHeap, num)
                heapq.heappush(self.maxHeap, toMax*-1)
            else:
                heapq.heappush(self.maxHeap, num*-1)
        else:
            if num <= self.maxHeap[0]:
                toMin = heapq.heappushpop(self.maxHeap, num*-1)
                heapq.heappush(self.minHeap, toMin*-1)
            else:
                heapq.heappush(self.minHeap, num)

        self.totalElements += 1

    def getMedianAfterAdding(self, num):
        self.addElem(num)
        return self.getMedian()

    def getMedian(self):
        try:
            if (self.totalElements%2 == 0):
                if len(self.minHeap) == 0:
                    return self.maxHeap[0]*-1
                return (self.maxHeap[0]*-1 + self.minHeap[0])/(2.0)
            else:
                return self.maxHeap[0]*-1

        except IndexError, msg: 
            print 'Error', msg

        
if __name__ == '__main__':
    inp = map(lambda x : int(x), sys.argv[1].split(' '))

    obj = Median()
    for i in inp:
        m = obj.getMedianAfterAdding(i)
        print 'Median after inserting element: %d = %f' % (i,m)

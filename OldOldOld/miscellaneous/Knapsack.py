#! /usr/bin/env python
import sys

items = []
value = []
knapTable = []
backTrackTable = []
dic = {}
filledWeight = 0
filledValue = 0
x= 0

def backTrack(weight, tillItem):
    
    global filledWeight, filledValue

    if (weight == 0 or tillItem == 0):
        return

    if (backTrackTable[weight][tillItem] == 1):
        backTrack(weight-items[tillItem], tillItem-1)
        filledWeight += items[tillItem]
        filledValue += value[tillItem]
        print items[tillItem], ' '
    else:
         backTrack(weight, tillItem-1)

def fillKnapsack(weight):
    global filledWeight, filledValue

    for i in range(0, weight+1):
        knapTable.append([])
        backTrackTable.append([])
        for j in range(0, len(items)):
            knapTable[i].append(-1)
            backTrackTable[i].append(0)
            fillKnapsackUsingItems(i, j)

    backTrack(weight, len(items)-1)
    print 'Filled weight: ',  filledWeight, ' Filled Value: ', filledValue
    

def fillKnapsackUsingItems(weight, tillItem):

    if knapTable[weight][tillItem] != -1:
        return knapTable[weight][tillItem]

    if (weight == 0 or tillItem == 0):
        knapTable[weight][tillItem] = 0 
        return 0

    if items[tillItem] > weight:
         withoutCurrenItem = fillKnapsackUsingItems(weight, tillItem-1)
         knapTable[weight][tillItem] = withoutCurrenItem
         return withoutCurrenItem

    withCurrentItem = fillKnapsackUsingItems(weight-items[tillItem], tillItem-1)+value[tillItem]
    withoutCurrenItem = fillKnapsackUsingItems(weight, tillItem-1) 

    if (withCurrentItem > withoutCurrenItem):
        backTrackTable[weight][tillItem] = 1
        knapTable[weight][tillItem] = withCurrentItem
        return withCurrentItem
    else:
        knapTable[weight][tillItem] = withoutCurrenItem
        return withoutCurrenItem

if __name__ == '__main__':
    items = map(lambda x: int(x), sys.argv[1].split(' '))
    items.insert(0, "")
    value = map(lambda x: int(x), sys.argv[2].split(' '))
    value.insert(0, "")
    weight = int(sys.argv[3])
    fillKnapsack(weight)

#!/usr/bin/env python
import sys
import collections

denominations = [1, 2, 5, 10, 20, 50, 100, 500]

#memoization
dic = collections.defaultdict(list)

def countCoins(value):
    if value==0 or value<denominations[0]:
        return 0,[]
    else:

        if dic[value]!=[]:
            return len(dic[value]), dic[value]

        minlength, templist = countCoins(value-denominations[0])
        minlength+=1
        minlist = list(templist)
        minlist.append(denominations[0])

        for i in denominations[1:]:
            if i>value:
                break
            else:
                length, templist = countCoins(value-i)
                length+=1
                lis = list(templist)
                lis.append(i)

                if length<minlength:
                    minlength = length
                    minlist = lis

        dic[value] = minlist
        return minlength, minlist

if __name__ == '__main__':
    value = int(sys.argv[1])
    numcoins, coinlist = countCoins(value)

    print 'Num coins required: %d' % numcoins
    print 'Selected hcoins: ', coinlist

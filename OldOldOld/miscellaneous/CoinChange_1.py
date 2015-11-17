#! /usr/bin/env python
import sys

coins = []
table = [] 
count = 0

def dp(amount, upToCoin):

    global table, coins, count
    count+=1
    if (upToCoin == -1 or amount == 0):
        return 0
    
    if table[amount][upToCoin] == -1:
        withoutCurrentCoin = dp(amount, upToCoin-1)
        withCurrentCoin = 0

        if coins[upToCoin] < amount:
            withCurrentCoin = dp(amount-coins[upToCoin], upToCoin-1)
        elif coins[upToCoin] == amount:
            withCurrentCoin = 1

        table[amount][upToCoin] = withoutCurrentCoin + withCurrentCoin
    
    return table[amount][upToCoin]

if __name__ =='__main__':
    coins = map(lambda x: int(x),sys.argv[1].split(" "))
    amount = int(sys.argv[2])

    table = [ [-1]*len(coins) for i in range(amount+1)]    
    #tableSelectedCoins = [ []*len(coins) for i in range(amount+1)]    

    #for i in range(amount+1):
    #    for j in range(len(coins)):
    #        tableSelectedCoins[i].append([])

    #print tableSelectedCoins

    print 'Possible combinations: ', dp(amount, len(coins)-1), ' #calls(dp): ', count

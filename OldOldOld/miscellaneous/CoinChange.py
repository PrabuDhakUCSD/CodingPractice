#! /usr/bin/env python
import sys

coins = []
table = [] 

def buildTable(amount):
    global table, coins

    for i in range(amount+1):
        table.append([])
        for j in range(len(coins)):
            if i== 0 or j==0:
                table[i].append(0)
            else:
                table[i].append(-1)

    print table

    for row in range(1,amount+1):
        for col in range(1, len(coins)):
            table[row][col] = dp(row, col) 

def dp(amount, upToCoin):
    global table, coins
    
    if table[amount][upToCoin] != -1:
        print amount, upToCoin
        return table[amount][upToCoin]

    withoutCurrentCoin = dp(amount, upToCoin-1)
    withCurrentCoin = 0

    if coins[upToCoin] < amount:
        withCurrentCoin = dp(amount-coins[upToCoin], upToCoin-1)
    elif coins[upToCoin] == amount:
        withCurrentCoin = 1

    return withoutCurrentCoin + withCurrentCoin

if __name__ =='__main__':
    coins = map(lambda x: int(x),sys.argv[1].split(" "))
    coins.insert(0, 0)
    amount = int(sys.argv[2])
    buildTable(amount)
    for item in table:
        print item

def calc_hand(hand):
    cnt = {}
    for c in hand[0]:
        cnt[c] = cnt.get(c, 0) + 1
    if 5 in cnt.values(): return 7
    if 4 in cnt.values(): return 6
    if 3 in cnt.values() and 2 in cnt.values(): return 5
    if 3 in cnt.values(): return 4
    if list(cnt.values()).count(2) == 2: return 3
    if 2 in cnt.values(): return 2
    return 1   

def calc_highest(h, cH):
    order = ['A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2']
    for i in range(5):
        if order.index(h[0][i]) < order.index(cH[0][i]): return True
        if order.index(cH[0][i]) < order.index(h[0][i]): return False

def cmpHands(hand, cmpHand):
    handC = calc_hand(hand)
    cmpHandC = calc_hand(cmpHand)
    if handC == cmpHandC: return calc_highest(hand, cmpHand)
    return handC > cmpHandC

with open('day7.txt') as f:
    input = f.read().splitlines()
    hands = list(zip([a.split()[0] for a in input], [int(a.split()[1]) for a in input]))
    res = []
    for hand in hands: 
        insIndex = 0
        for i in range(len(res)):
            if cmpHands(hand, res[i]): insIndex = i+1
        res.insert(insIndex, hand)
    tot = 0
    for i in range(len(res)):
        tot += res[i][1] * (i+1)
    print(tot)
    
    

    


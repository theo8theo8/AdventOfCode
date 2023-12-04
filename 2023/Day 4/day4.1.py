import math
with open('day4.txt') as f:
    input = f.read().splitlines()
    sum = 0
    for card in input:
        crd = card.split(':')[1].split('|')
        win = crd[0].split()
        nums = crd[1].split()
        p = 0
        for x in nums:
            if x in win:p+=1
        sum += math.floor(pow(2,(p-1)))
    print(sum)
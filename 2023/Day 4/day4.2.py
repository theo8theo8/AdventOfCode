with open('day4.txt') as f:
    input = f.read().splitlines()
    noCards = [1]*len(input)
    for card in input:
        crd = card.split(':')
        crdNo = int(crd[0].split()[1])
        check = crd[1].split('|')
        win = check[0].split()
        nums = check[1].split()
        p = 0
        for x in nums:
            if x in win:p+=1
        for i in range(crdNo, crdNo+p):
            noCards[i] += noCards[crdNo-1]
    print(sum(noCards))
        
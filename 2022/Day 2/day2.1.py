tot_score = 0
with open('day2.txt') as f:
    input = f.read().splitlines()
    for row in input:
        x = row.split()
        opp = ord(x[0])-64
        me = ord(x[1])-87
        tot_score += me
        if me == opp:
            tot_score += 3
        elif me == 3 and opp == 1:
            pass
        elif me > opp or (me == 1 and opp ==3):
            tot_score += 6
print(tot_score)
tot_score = 0
with open('day2.txt') as f:
    input = f.read().splitlines()
    for row in input:
        x = row.split()
        opp = ord(x[0])-64
        if x[1] == "X":
            if opp > 1:
                tot_score += opp-1
            else:
                tot_score += 3
        elif x[1] == "Y":
            tot_score += 3 + opp
        else:
            if opp < 3:
                tot_score += 7+opp
            else:
                tot_score += 7
print(tot_score)
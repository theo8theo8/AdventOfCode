with open('day2.txt') as f:
    input = f.read().splitlines()
    maxR = 12
    maxG = 13
    maxB = 14
    sum = 0
    for row in input:
        r = row.split(':')
        gG = True
        id = int(r[0].split()[1])
        for round in r[1].split(';'):
            for col in round.split(','):
                c = col.split()
                if c[1] == "red" and int(c[0]) > maxR:
                    gG = False
                elif c[1] == "green" and int(c[0]) > maxG:
                    gG = False
                elif c[1] == "blue" and int(c[0]) > maxB:
                    gG = False
        if gG: sum += id
print(sum)
with open('day2.txt') as f:
    input = f.read().splitlines()
    sum = 0
    for row in input:
        r = row.split(':')
        minR = 0
        minG = 0
        minB = 0
        for round in r[1].split(';'):
            for col in round.split(','):
                c = col.split()
                if c[1] == "red" and int(c[0]) > minR:
                    minR = int(c[0])
                elif c[1] == "green" and int(c[0]) > minG:
                    minG = int(c[0])
                elif c[1] == "blue" and int(c[0]) > minB:
                    minB = int(c[0])
        sum += (minR*minG*minB)
print(sum)
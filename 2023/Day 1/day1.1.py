with open('day1.txt') as f:
    input = f.read().splitlines()
    sum = 0
    for row in input:
        digFirst = True
        firstDig = 0
        lastDig = 0
        for a in row:
            if a.isdigit():
                lastDig = a
                if digFirst:
                    firstDig = a
                    digFirst = False
        sum += (int(str(firstDig + lastDig)))
print(sum)
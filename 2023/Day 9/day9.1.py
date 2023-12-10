with open('day9.txt') as f:
    input = f.read().splitlines()
    rows = [[[int(i) for i in line.split()]] for line in input]
    for row in rows:
        for r in row:
            new = []
            for i in range(len(r)-1):
                new.append(r[i+1]-r[i])
            if not all(x == 0 for x in new): row.append(new)

    for row in rows:
        for i in range(len(row)-1, -1 , -1):
            row[i-1].append(row[i-1][-1]+row[i][-1])
    
    tot = 0
    for row in rows:
        tot += row[0][-1]
    print(tot)
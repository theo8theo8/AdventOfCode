import numpy as np
f = open("day4.txt","r").readlines()
draw = f[0].split(",")
f.pop(0)
f.pop(0)
bingos = []
this_bingo = []
last_draft = 0

for line in f:
    if len(line) > 1:
        row = []
        for num in line.split(" "):
            if len(num) > 0:
                row.append([int(num), 0])
        this_bingo.append(row)
    else:
        bingos.append(this_bingo)
        this_bingo = []
bingos.append(this_bingo)

def check_row(row):
    for num in row:
        if num[1] == 0:
            
            return False
    return True

def check_bingos():
    final_bingo = 0
    for bingo in bingos:
        tpbingo = np.swapaxes(bingo,0,1)
        for row in bingo:
            if (check_row(row)):
                return (True, final_bingo)
        for row in tpbingo:
            if (check_row(row)):
                return (True, final_bingo)
        final_bingo += 1
    return (False, 0)

def get_final_res(o):
    total = 0
    for row in bingos[o]:
        for num in row:
            if num[1] == 0:
                total += num[0]
    print(total*last_draft)

for draft in draw:
    last_draft = int(draft)
    for bingo in bingos:
        for row in bingo:
            for num in row:
                if num[0] == int(draft):
                    num[1] = 1
                    break
    o = check_bingos()
    if o[0]:
        get_final_res(o[1])
        break
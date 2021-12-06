import numpy as np
f = open("day4.txt","r").readlines()
draw = f[0].split(",")
f.pop(0)
f.pop(0)
bingos = []
this_bingo = []
last_draft = 0
last_bingo = []

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
    for bingo in bingos:
        tpbingo = np.swapaxes(bingo,0,1)
        for row in bingo:
            if (check_row(row)):
                bingos.remove(bingo)
                return (bingo)   
        for row in tpbingo:
            if (check_row(row)):
                bingos.remove(bingo)
                return (bingo)
    return ([])

def get_final_res():
    total = 0
    print(last_bingo)
    for row in last_bingo:
        for num in row:
            if num[1] == 0:
                total += num[0]
                print(total)
    print(last_draft)
    print(total*last_draft)

for draft in draw:
    for bingo in bingos:
        for row in bingo:
            for num in row:
                if num[0] == int(draft):
                    num[1] = 1
                    break
    o = check_bingos()
    if len(o) > 1:
        last_draft = int(draft)
        last_bingo = o

get_final_res()
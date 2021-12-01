nOLines = 0
preNum = 100000
for line in open("day1.txt","r").readlines():
    if int(line) > preNum:
        nOLines += 1
    preNum = int(line)
print(nOLines) 
nOLines = 0
pre1 = 100000
pre2 = 100000
pre3 = 100000
for line in open("day1.txt","r").readlines():
    if pre2+pre3+int(line) > pre1+pre2+pre3:
        nOLines += 1
    pre1 = pre2
    pre2 = pre3
    pre3 = int(line)
print(nOLines) 
# Get input from test.txt
sums=[]
with open('day1.txt') as f:
    input = f.read().splitlines()
    sum = 0
    for row in input:
        if row == "":
            sums.append(sum)
            sum = 0
        else:
            sum += int(row)
    sums.append(sum)
print(max(sums))
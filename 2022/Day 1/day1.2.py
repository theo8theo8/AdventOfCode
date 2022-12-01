# Get input from test.txt
sums=[]
with open('day1.txt') as f:
    input = f.read().splitlines()
    ind_sum = 0
    for row in input:
        if row == "":
            sums.append(ind_sum)
            ind_sum = 0
        else:
            ind_sum += int(row)
    sums.append(ind_sum)
print(sum(sorted(sums, reverse=True)[:3]))